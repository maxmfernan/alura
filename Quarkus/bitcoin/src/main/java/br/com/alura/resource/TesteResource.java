package br.com.alura.resource;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.model.InputMensagem;
import br.com.alura.model.ResultadoTesteAPI;

@Path("/teste")
public class TesteResource {
    
    /*
     * 1) Mapear exceção para Response
     * 2) Colocar swagger                       v
     * 3) Colocar rastreio
     * 4) Testar API
     * 4) Testar service
     * 5) Guardar senha em variáveis de ambiente
     */

     @GET
     @Path("/mensagem")
     @Produces(MediaType.APPLICATION_JSON)
     public ResultadoTesteAPI getMensagem(){
        Random random = new Random();
        int randomInt = (random.nextInt( 4) + 1 );
        if(  randomInt == 1){
            throw new RuntimeException("Exceção. num aleatório: " + randomInt);
        }

        return new ResultadoTesteAPI();
     }

     @POST
     @Path("/mensagem")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public ResultadoTesteAPI createMensagem(InputMensagem inputMensagem){
        Pattern pattern = Pattern.compile("F[0-9]{7}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputMensagem.getMatricula());
        if( !matcher.matches() ){
            throw new RuntimeException("Exceção. Matrícula errada: " + inputMensagem.getMatricula());
        }

        return new ResultadoTesteAPI();
     }
}
