package br.com.gerenFut.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.util.RequisicaoAPIFutebol;


@Path("/apifutebol")
public class APIFutebolService {

	private static final Logger LOGGER = Logger.getLogger(APIFutebolService.class);
	private RequisicaoAPIFutebol requisicaoAPIFutebol = new RequisicaoAPIFutebol();
	
	
	@GET
	@Path("/atualizarTabela")
	public void requesAPIFutebol() {
		LOGGER.info("APIFutebolService - requesAPIFutebol");
		requisicaoAPIFutebol.requisicaoAPIFutebolObterTabela();
	}
	
	@GET
	@Path("/infoTimesAPIFutebol")
	public void salvarTimesAPIFutebol() {
		LOGGER.info("APIFutebolService - salvarTimesAPIFutebol");
		requisicaoAPIFutebol.requisicaoAPIFutebolObterInfoTimes();
		// fazer todo o direcionamento para atualizar tabela do campeonato.
	}
	
	
	
}
