package br.com.alura.resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import br.com.alura.model.ListaResultadoToDo;
import br.com.alura.model.ResultadoToDo;
import br.com.alura.service.consumidas.ToDosService;

@Path("/todos")
public class ToDosResource {

    @Inject
    Logger log;

    @Inject
    @RestClient
    ToDosService todosService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getToDos() {
        Response response = todosService.getTodoDos();
        //log.infof("Response no formato string: %s", response.readEntity(String.class));
        List<ResultadoToDo> resultadosToDo =  response.readEntity(new GenericType<List<ResultadoToDo>>(){});

        log.infof("Obtive o resultado: %s", resultadosToDo.get(0).getResults());

        return response;

    }

}
