package br.com.alura.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/extensions")
@RegisterRestClient
public interface ExtensionsService {

    @GET
    @Path("/stream/{")
    
}
