package io.github.sb.error;

public class JsonFileNotFound extends RuntimeException {

    public JsonFileNotFound(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public JsonFileNotFound(String errorMessage) {
        super(errorMessage);
    }
}
