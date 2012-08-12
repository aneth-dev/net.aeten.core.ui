package net.aeten.core.parsing;

/**
 *
 * @author Thomas Pérennou
 */
public class ParsingException extends Exception {

	public ParsingException(Throwable cause) {
		super(cause);
	}

	public ParsingException(String message, String line, int errorPosition) {
		super(String.format("%s in \"%s\" at position %d", message, line, errorPosition));
	}

	public ParsingException(String message, String line, int errorPosition, Throwable cause) {
		super(String.format("%s in \"%s\" at position %d", message, line, errorPosition), cause);
	}
	
}