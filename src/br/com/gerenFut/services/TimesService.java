package br.com.gerenFut.services;

import com.google.gson.Gson;
import com.sun.istack.logging.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import br.com.gerenFut.util.TimesNegocio;
import br.com.gerenFut.validacao.TimesValidacao;
import br.com.gerenFut.DTO.TimesDTO;
import br.com.gerenFut.model.*;

@Path("/times")
public class TimesService {

	
	private TimesNegocio timesNegocio = new TimesNegocio();
	private TimesValidacao timesValidacao = new TimesValidacao();
	private static final Logger LOGGER = Logger.getLogger(TimesService.class);

	
	@POST
	@Path("/testeTime")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String testeTime(String teste) {
		
		LOGGER.info("TimesService - testeTime");
		
		return "<html><body><h1>testeTime</body></h1></html>";

	}
	

	@POST
	@Path("/criaTime")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String criaTime(String timeJson) {
		
		LOGGER.info("TimesService - criaTime");
		
		Gson gson = new Gson();
		TimesDTO timeDTO = gson.fromJson(timeJson, TimesDTO.class);
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		
		int validacao;
		validacao = timesValidacao.validarCriacaoInfoTime(timeDTO);
		
		if(validacao == -1) {

			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Nome do time é obrigatório")
					.build());
		}
		if(validacao == -2) {
			
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Estado do time é obrigatório")
					.build());
		}
		
		if(validacao == 0) {
			timesNegocio.salvarTime(timeDTO);
			
			retorno.put("Confirmacao", true);
			
		}
		LOGGER.info("TimesService - criaTime - OK");
		
		return gson.toJson(retorno);
	}
	
	@GET
	@Path("/removeTime/{timeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String removetime(@PathParam("timeId") String id) {
		
		LOGGER.info("TimesService - removetime");
		
		Gson gson = new Gson();
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		
		timesNegocio.removerTime(id);
		
		retorno.put("Removido", true);
		
		return gson.toJson(retorno);
	}
	
	@POST
	@Path("/atualizaTime")
	public String atualizaTime() {
		
		return "<html><body><h1>atualizaTime</body></h1></html>";
	}
	
	@GET
	@Path("/obtertimes")
	@Produces(MediaType.APPLICATION_JSON)
	public String obterTodosOsTimes(){
		
		LOGGER.info("TimesService - obterTodosOsTimes");
		
		Gson gson = new Gson();
		List<Times> times = timesNegocio.obterTodosOsTimes();
		
		Map<String, List<Times>> retorno = new HashMap<String, List<Times>>();
		retorno.put("Times", times);
		
		LOGGER.info("TimesService - obterTodosOsTimes - OK");
		return gson.toJson(retorno);
	}
	
	
}
