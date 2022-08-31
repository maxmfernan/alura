package br.com.alura.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class TesteExceptionMapper implements ExceptionMapper<TesteException>{

    @Override
    public Response toResponse(TesteException arg0) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
