package br.com.alura.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import br.com.alura.model.Post;
import br.com.alura.service.consumidas.PostService;

@Path("/posts")
public class PostResource {
    @Inject
    @RestClient
    PostService postService;

    @Inject
    Logger log;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getPostById(@PathParam("id") String id) {
        Response response = postService.getPostById(id);
        log.infof("Consultei api de post: %s", response.readEntity(Post.class).getTitle());
        return response;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setPost(Post payloadPost){
        Post responsePost = postService.setPost(payloadPost);
        log.infof("Enviei um post. Resposta: %s", responsePost.getTitle());
        return Response.status(Response.Status.OK).entity(responsePost).build();
    }
}
