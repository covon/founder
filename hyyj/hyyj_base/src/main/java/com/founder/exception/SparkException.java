package com.founder.exception;

public class SparkException extends RuntimeException{
    public SparkException() {
        super();
    }

    public SparkException(String message) {
        super(message);
    }

    public SparkException(String message, Throwable cause) {
        super(message, cause);
    }

    public SparkException(Throwable cause) {
        super(cause);
    }

    protected SparkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
