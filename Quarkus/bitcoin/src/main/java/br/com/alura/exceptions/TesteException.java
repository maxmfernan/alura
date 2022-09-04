package br.com.alura.exceptions;

public class TesteException extends RuntimeException{

    private Error error;
    public TesteException() {
    }

    public TesteException(Error error) {
        super(error.getMensagem());
        this.error = error;
        
    }

    public Error getError() {
        return error;
    }




    

}
