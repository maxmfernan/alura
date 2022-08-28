package br.com.alura.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import br.com.alura.model.Post;
import br.com.alura.service.BitcoinService;

@Path("/bitcoins")
public class BitcoinResource {

    @Inject
    @RestClient
    BitcoinService bitcoinService;

    @Inject
    Logger log;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        log.infof("Chamando a API consumida.");
        Response response = bitcoinService.list();
        log.infof("Resposta tem entidade?: " + response.hasEntity());
        
        log.infof("Resposta stringficada: " + 
            response.readEntity(new GenericType<List<Post>>() {}).stream()
                    .map((p) -> p.getTitle())
                    .collect(Collectors.toList())
        );
                
            

        return response;
    }

}
