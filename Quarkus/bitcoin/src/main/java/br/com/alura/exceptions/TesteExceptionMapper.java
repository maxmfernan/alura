package br.com.alura.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class TesteExceptionMapper implements ExceptionMapper<TesteException>{

    @Override
    public Response toResponse(TesteException exception) {
        return Response
            .status(exception.getError().getHttpCode())
            .entity(exception.getError().getMensagem() + " " + exception.getError().getCode())
            .build();
    }
    
}
