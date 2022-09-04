package br.com.alura.exceptions;

import javax.ws.rs.core.Response.Status;

public interface Error {

    public String getCode();

    public String getMensagem();

    public Status getHttpCode();

    
}
