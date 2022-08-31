package br.com.alura.service.consumidas;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.alura.model.ResultadoToDo;
import br.com.alura.model.ToDo;

@Path("/todos")
@RegisterRestClient(configKey="todos")
public interface ToDosService {

    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    // public List<ResultadoToDo> getTodoDos();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ToDo getToDosById(@PathParam("id") int id);

}
