package io.github.sb.error;

public class PropertyFileNotFound extends RuntimeException {

    public PropertyFileNotFound(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public PropertyFileNotFound(String errorMessage) {
        super(errorMessage);
    }
}
