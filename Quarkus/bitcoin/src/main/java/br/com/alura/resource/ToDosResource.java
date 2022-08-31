package br.com.alura.resource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import br.com.alura.model.ToDo;
import br.com.alura.service.consumidas.ToDosService;

@Path("/todos")
public class ToDosResource {

    @Inject
    Logger log;

    @Inject
    @RestClient
    ToDosService todosService;

    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response getToDos() {
    //     List<ResultadoToDo> resultadosToDo = todosService.getTodoDos();
    //     //log.infof("Response no formato string: %s", response.readEntity(String.class));
    //     // List<ResultadoToDo> resultadosToDo =  response.readEntity(new GenericType<List<ResultadoToDo>>(){});

    //     log.infof("Obtive o resultado: %s", resultadosToDo.get(0).getResults());

    //     return Response.status(Response.Status.OK).entity(resultadosToDo).build();

    // }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getToDosById(@PathParam("id") int id){
        ToDo todo = todosService.getToDosById(id);
        log.infof("Obtive o resultado: %s", todo.getTitle());

        return Response.status(Response.Status.OK).entity(todo).build();
    }

}
