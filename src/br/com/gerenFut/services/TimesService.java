package br.com.gerenFut.services;

import com.google.gson.Gson;
import com.sun.istack.logging.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.gerenFut.util.TimesNegocio;
import br.com.gerenFut.model.*;

@Path("/times")
public class TimesService {

	
	private TimesNegocio timesNegocio = new TimesNegocio();
	Logger logger;
	
	@GET
	@Path("/getTimes")
	//@Produces("application/json")
	@Produces("text/html")
	public String getTimes() {
		
		return "<html><body><h1>getTimes</body></h1></html>";
	}

	@POST
	@Path("/criaTime")
	public String criaTime() {
		
		/* Validar a formatacao dos dados de entrada
			chamar o metodo em *.util e dentro dessse metodo
			realizar a validacao das informacoes. 
		*/
		
		return "<html><body><h1>criaTime</body></h1></html>";
	}
	
	@GET
	@Path("/removeTime")
	public String removetime() {
		
		
		return "<html><body><h1>removetime</body></h1></html>";
	}
	
	@POST
	@Path("/atualizaTime")
	public String atualizaTime() {
		
		return "<html><body><h1>atualizaTime</body></h1></html>";
	}
	
	@GET
	@Path("/obtertimes")
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String obterTodosOsTimes(){
		
		Gson gson = new Gson();
		List<Times> times = timesNegocio.obterTodosOsTimes();
		
		Map<String, List<Times>> retorno = new HashMap<String, List<Times>>();
		retorno.put("Times", times);
		
		return gson.toJson(retorno);
		
		
	}
	
	
}
