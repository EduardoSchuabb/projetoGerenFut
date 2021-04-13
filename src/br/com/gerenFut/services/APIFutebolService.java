package br.com.gerenFut.services;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.util.RequisicaoAPIFutebol;


@Path("/apifutebol")
public class APIFutebolService {

	private static final Logger LOGGER = Logger.getLogger(APIFutebolService.class);
	private RequisicaoAPIFutebol requisicaoAPIFutebol = new RequisicaoAPIFutebol();
	
	/* OBSERVACAO: Esse metodo demanda varias conexoes com o banco de dados 
	 * (ainda tenho que veriricar a eficiencia desse tipo de trabalho), eh um
	 *  metodo que autlizara as informacoes do campeonatoe sobre cada time apos cada rodada.
	 * */	
	@GET
	@Path("/atualizarTabela")
	@Produces(MediaType.APPLICATION_JSON)
	public Response requesAPIFutebol() {
		LOGGER.info("APIFutebolService - requesAPIFutebol");
		int validacao;

		validacao = requisicaoAPIFutebol.salvarTabelaCampeonato();
		if(validacao == -1) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Erro na requisicao para API-Futebol")
					.build());
		}
		return Response.ok(validacao).header("Access-Control-Allow-Origin", "*").build();
	}
	
	/* OBSERVACAO: Esse metodo nao eh recomendado de ser usado sempre.
	 *  Ele eh um metodo lento e faz 21 requisicoes para a API-Futebol.
	 *  A ideia eh utiliza-lo apenas para obter a real lista com os nomes
	 *  dos times. Uma vez obtida, nao existe a necessidade de obter mais.
	 * */	
	@GET
	@Path("/infoTimesAPIFutebol")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarTimesAPIFutebol() {
		LOGGER.info("APIFutebolService - salvarTimesAPIFutebol");
		int retorno;
		retorno = requisicaoAPIFutebol.requisicaoAPIFutebolObterInfoTimes();
		if(retorno == -1) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Erro na requisicao para API-Futebol")
					.build());
		}
		return Response.ok(retorno).header("Access-Control-Allow-Origin", "*").build();
	}
	
	
}
