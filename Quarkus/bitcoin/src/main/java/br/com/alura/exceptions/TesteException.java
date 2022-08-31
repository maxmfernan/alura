package br.com.alura.exceptions;

public class TesteException extends RuntimeException{
    public TesteException() {
    }

    public TesteException(String message) {
        super(message);
    }

    public TesteException(String message, Throwable cause) {
        super(message, cause);
    }

    public TesteException(Throwable cause) {
        super(cause);
    }

    public TesteException(String message, Throwable cause, 
                           boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
