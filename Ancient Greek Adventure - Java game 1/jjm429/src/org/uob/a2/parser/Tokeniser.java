package org.uob.a2.parser;

import java.util.ArrayList;

/**
 * The {@code Tokeniser} class is responsible for converting a string input into a list of tokens
 * that can be parsed into commands by the game.
 * 
 * <p>
 * The tokeniser identifies keywords, variables, and special symbols, assigning each a {@code TokenType}.
 * </p>
 */
public class Tokeniser {

    ArrayList<Token> tokens = new ArrayList<Token>();

    public Tokeniser() {}

    public void tokenise(String s) {
        String[] words = s.split(" ");
        for (String word : words) {
            switch (word.toLowerCase()) {
                case "use":
                    tokens.add(new Token(TokenType.USE, word)); break;
                case "combine":
                    tokens.add(new Token(TokenType.USE, word)); break;
                case "get":
                    tokens.add(new Token(TokenType.GET)); break;
                case "drop":
                    tokens.add(new Token(TokenType.DROP)); break;
                case "look":
                    tokens.add(new Token(TokenType.LOOK)); break;
                case "status":
                    tokens.add(new Token(TokenType.STATUS)); break;
                case "help":
                    tokens.add(new Token(TokenType.HELP)); break;
                case "move":
                    tokens.add(new Token(TokenType.MOVE)); break;
                case "quit":
                    tokens.add(new Token(TokenType.QUIT)); break;
                case "error":
                    tokens.add(new Token(TokenType.ERROR)); break;
                case "on":
                    tokens.add(new Token(TokenType.PREPOSITION, word)); break;
                case "with":
                    tokens.add(new Token(TokenType.PREPOSITION, word)); break;//might have to add more prepositions
                case "and":
                    tokens.add(new Token(TokenType.PREPOSITION, word)); break;
                /**case "escape":
                    tokens.add(new Token(TokenType.EOL)); break;*/
                default:
                    tokens.add(new Token(TokenType.VAR, word));
            }
        }
        tokens.add(new Token(TokenType.EOL));
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public String sanitise(String s) {
        int i = 0;
        while (i < s.length()-1) {
            for (i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') {
                    s = s.substring(0, i) + s.substring(i + 1);
                    break;
                }
            }
        }

        return s.toLowerCase().trim();
    }


}
