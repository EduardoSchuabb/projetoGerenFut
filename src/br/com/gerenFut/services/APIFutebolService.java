package br.com.gerenFut.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sun.istack.logging.Logger;

import br.com.gerenFut.util.RequisicaoAPIFutebol;


@Path("/apifutebol")
public class APIFutebolService {

	private static final Logger LOGGER = Logger.getLogger(APIFutebolService.class);
	private RequisicaoAPIFutebol requisicaoAPIFutebol = new RequisicaoAPIFutebol();
	
	
	@GET
	@Path("/atualizarTabela")
	@Produces(MediaType.APPLICATION_JSON)
	public String requesAPIFutebol() {
		LOGGER.info("APIFutebolService - requesAPIFutebol");
		int retorno;
		Gson gson = new Gson();
		Map<String, Boolean> retornoJson = new HashMap<String, Boolean>();
		retorno = requisicaoAPIFutebol.salvarTabelaCampeonato();
		if(retorno == -1) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Erro na requisicao para API-Futebol")
					.build());
		}
		retornoJson.put("Confirmacao", true);
		return gson.toJson(retornoJson);
		
	}
	
	/* OBSERVACAO: Esse metodo nao eh recomendado de ser usado sempre.
	 *  Ele eh um metodo lento e faz 21 requisicoes para a API-Futebol.
	 *  A ideia eh utiliza-lo apenas para obter a real lista com os nomes
	 *  dos times. Uma vez obtida, nao existe a necessidade de obter mais.
	 * */	
	@GET
	@Path("/infoTimesAPIFutebol")
	@Produces(MediaType.APPLICATION_JSON)
	public String salvarTimesAPIFutebol() {
		LOGGER.info("APIFutebolService - salvarTimesAPIFutebol");
		int retorno;
		Gson gson = new Gson();
		Map<String, Boolean> retornoJson = new HashMap<String, Boolean>();
		retorno = requisicaoAPIFutebol.requisicaoAPIFutebolObterInfoTimes();
		if(retorno == -1) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Erro na requisicao para API-Futebol")
					.build());
		}
		retornoJson.put("Confirmacao", true);
		return gson.toJson(retornoJson);
	}
	
	
}
