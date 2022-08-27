package br.com.alura.service;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.alura.model.Post;

@Path("/posts")
@RegisterRestClient(configKey = "bitcoin-service")
public interface BitcoinService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list();
    
}
