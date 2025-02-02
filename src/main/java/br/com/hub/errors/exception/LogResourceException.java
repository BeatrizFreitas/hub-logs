package br.com.hub.errors.exception;

public class LogResourceException extends Exception {
    public LogResourceException() {
        super();
    }

    public LogResourceException(String message) {
        super(message);
    }

    public LogResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogResourceException(Throwable cause) {
        super(cause);
    }

    public LogResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

