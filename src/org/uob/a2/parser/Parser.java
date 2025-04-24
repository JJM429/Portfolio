package org.uob.a2.parser;

import java.util.ArrayList;

import org.uob.a2.commands.*;

/**
 * The {@code Parser} class processes a list of tokens and converts them into {@code Command} objects
 * that can be executed by the game.
 * 
 * <p>
 * The parser identifies the type of command from the tokens and creates the appropriate command object.
 * If the command is invalid or incomplete, a {@code CommandErrorException} is thrown.
 * </p>
 */
public class Parser {

    public Parser() {}

    public void add(Token token) {

    }/** again check if this is correct as may need to overload with other parameters*/

    public Command parse(ArrayList<Token> tokens) throws CommandErrorException {
        for (int i=0; i<tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token.getTokenType().equals(TokenType.MOVE)) {
                if (tokens.size()<2) {
                    throw new CommandErrorException("Move commands must have a direction.");
                }
                if (tokens.get(i+1).getTokenType().equals(TokenType.VAR)) {
                    return new Move(tokens.get(i+1).getValue());
                }
                throw new CommandErrorException("Move commands must have a valid direction.");
            }
            else if (token.getTokenType().equals(TokenType.USE)) {
                try {token.getValue().equals("use");}
                catch (Exception e) {
                    token.setValue("use");
                }
                if (token.getValue().equals("use")) {
                    if (tokens.size()<4) {
                        return new Use(tokens.get(i+1).getValue(),null);
                    }
                    if (tokens.get(i+1).getTokenType().equals(TokenType.VAR) && tokens.get(i+2).getTokenType().equals(TokenType.PREPOSITION) && tokens.get(i+3).getTokenType().equals(TokenType.VAR)) {
                        return new Use(tokens.get(i+1).getValue(), tokens.get(i+3).getValue());
                    }
                    throw new CommandErrorException("Use commands must have two valid items and a valid preposition.");
                } else if (token.getValue().equals("combine")) {
                    if (tokens.size() < 4) {
                        throw new CommandErrorException("Combine commands must have two items and a preposition.");
                    } else if (tokens.get(i + 1).getTokenType().equals(TokenType.VAR) && tokens.get(i + 2).getTokenType().equals(TokenType.PREPOSITION) && tokens.get(i + 3).getTokenType().equals(TokenType.VAR)) {
                        return new Combine(tokens.get(i + 1).getValue(), tokens.get(i + 3).getValue());
                    }
                    throw new CommandErrorException("Combine commands must have two valid items and a valid preposition.");
                }

            }
            else if (token.getTokenType().equals(TokenType.HELP)) {
                if (tokens.get(i+1).getTokenType().equals(TokenType.VAR)) {
                    return new Help(tokens.get(i+1).getValue());
                } else if (tokens.get(i+1).getTokenType().equals(TokenType.MOVE)) {
                    return new Help("move");
                } else if (tokens.get(i+1).getTokenType().equals(TokenType.USE)) {
                    if (tokens.get(i+1).getValue().equals("use")) {
                        return new Help("use");
                    } else {
                        return new Help("combine");
                    }
                } else if (tokens.get(i+1).getTokenType().equals(TokenType.GET)) {
                    return new Help("get");
                } else if (tokens.get(i+1).getTokenType().equals(TokenType.DROP)) {
                    return new Help("drop");
                } else if (tokens.get(i+1).getTokenType().equals(TokenType.HELP)) {
                    return new Help("help");
                } else if (tokens.get(i+1).getTokenType().equals(TokenType.LOOK)) {
                    return new Help("look");
                } else if (tokens.get(i+1).getTokenType().equals(TokenType.QUIT)) {
                    return new Help("quit");
                } else if (tokens.get(i+1).getTokenType().equals(TokenType.STATUS)) {
                    return new Help("status");
                }
                else {
                    return new Help("null");
                }
            }
            else if (token.getTokenType().equals(TokenType.GET)) {
                if (tokens.size() < 2) {
                    throw new CommandErrorException("Get commands must have a target.");
                }
                if (tokens.get(i+1).getTokenType().equals(TokenType.VAR)) {
                    return new Get(tokens.get(i+1).getValue());
                }
                throw new CommandErrorException("Get commands must have a valid target.");
            } else if (token.getTokenType().equals(TokenType.QUIT)) {
                return new Quit();
            } else if (token.getTokenType().equals(TokenType.STATUS)) {
                return new Status(tokens.get(i+1).getValue());
            } else if (token.getTokenType().equals(TokenType.LOOK)) {
                return new Look(tokens.get(i+1).getValue());
            } else if (token.getTokenType().equals(TokenType.DROP)) {
                return new Drop(tokens.get(i+1).getValue());
            } else if (token.getTokenType().equals(TokenType.EOL)) {
                return new NoAction();
            }

        }
        throw new CommandErrorException("Cannot find that command");
    }
}
