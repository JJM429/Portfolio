package org.uob.a2.commands;

/**
 * Represents an exception thrown when an unrecognized or invalid command is encountered.
 * 
 * <p>
 * This exception is used to indicate parsing or processing errors related to commands entered by the player.
 * </p>
 */
public class CommandErrorException extends Exception {

    public CommandErrorException(String error) {
        super(error);
    }


    /**
     * Returns a string representation of the exception, including its message.
     *
     * @return a string describing the command error
     */
    @Override
    public String toString() {
        return "CommandError: " + getMessage();
    }
}
