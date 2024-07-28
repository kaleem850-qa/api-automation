package io.github.sb.error;

public class PropertyKeyNotFound extends RuntimeException {

    public PropertyKeyNotFound(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public PropertyKeyNotFound(String errorMessage) {
        super(errorMessage);
    }
}
