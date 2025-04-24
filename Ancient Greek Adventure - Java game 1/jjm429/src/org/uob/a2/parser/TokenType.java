package org.uob.a2.parser;

/**
 * Represents the types of tokens that can be identified and processed by the parser.
 * 
 * <p>
 * Each {@code TokenType} corresponds to a specific category of input, such as a command,
 * variable, or special symbol. These token types are used during the tokenisation and parsing process.
 * </p>
 */
public enum TokenType {
    /**
     * Represents the "use" command.
     */
    USE,

    /**
     * Represents the "get" command.
     */
    GET,

    /**
     * Represents the "drop" command.
     */
    DROP,

    /**
     * Represents the "look" command.
     */
    LOOK,

    /**
     * Represents the "status" command.
     */
    STATUS,

    /**
     * Represents the "help" command.
     */
    HELP,

    /**
     * Represents the "quit" command.
     */
    QUIT,

    /**
     * Represents an error token, typically for invalid input.
     */
    ERROR,

    /**
     * Represents a variable or unclassified word.
     */
    VAR,

    /**
     * Represents the "move" command.
     */
    MOVE,

    /**
     * Represents a preposition such as "on", "with", or "using".
     */
    PREPOSITION,

    /**
     * Represents the end of a line or command.
     */
    EOL;

    /**
    public static TokenType[] values() {
        return new TokenType[] {};
    }
    public static TokenType valueOf(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        switch(name.toLowerCase()) {
            case "use":
                return USE;
            case "get":
                return GET;
            case "drop":
                return DROP;
            case "look":
                return LOOK;
            case "status":
                return STATUS;
            case "help":
                return HELP;
            case "quit":
                return QUIT;
            case "error":
                return ERROR;
            case "var":
                return VAR;
            case "move":
                return MOVE;
            case "preposition":
                return PREPOSITION;
            case "escape":
                return EOL;
            default:
                throw new IllegalArgumentException("Unknown token type: " + name);
        }
    }*/
}

