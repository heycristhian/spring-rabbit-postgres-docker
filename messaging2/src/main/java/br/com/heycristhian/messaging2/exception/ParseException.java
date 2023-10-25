package br.com.heycristhian.messaging2.exception;

public class ParseException extends RuntimeException {
    public ParseException(String objectName) {
        super("An error occurred while converting the object: " + objectName);
    }
}
