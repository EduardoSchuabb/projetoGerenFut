package br.com.gerenFut.services;

import java.util.HashMap;
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

import com.google.gson.Gson;
import com.sun.istack.logging.Logger;

import br.com.gerenFut.DTO.JogadoresDTO;
import br.com.gerenFut.DTO.TimesDTO;
import br.com.gerenFut.util.JogadoresNegocio;
import br.com.gerenFut.validacao.JogadoresValidacao;

@Path("/jogadores")
public class jogadoresService {

	
	private JogadoresNegocio jogadoresNegocio = new JogadoresNegocio();
	private JogadoresValidacao jogadoresValidacao = new JogadoresValidacao();
	private static final Logger LOGGER = Logger.getLogger(jogadoresService.class);

	
	@GET
	@Path("/removeJogador/{jogadorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String removetime(@PathParam("jogadorId") String id) {
	
		return "<html><body><h1>removetime</body></h1></html>";
	}
	
	
	@POST
	@Path("/criaJogador")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String criaJogador(String jogadorJson) {
		LOGGER.info("JogadoresService - criaJogador");
		Gson gson = new Gson();
		JogadoresDTO jogadorDTO = gson.fromJson(jogadorJson, JogadoresDTO.class);
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		
		int validacao;
		validacao = jogadoresValidacao.validarCriacaoInfoJogador(jogadorDTO);
		
		if(validacao == -1) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Nome do jogador é obrigatório")
					.build());
		}
		if(validacao == -2) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Posicao do jogador é obrigatório")
					.build());
		}
		if(validacao == -3) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Time nao encontrado")
					.build());
		}
		if(!jogadoresValidacao.verificaSeExisteJogadorPorNome(jogadorDTO.getNome()))
			jogadoresNegocio.salvarJogador(jogadorDTO); // ainda nao implementada
		else {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Jogador ja existe.")
					.build());
		}
		
		retorno.put("Confirmacao", true);
		LOGGER.info("JogadoresService - criaJogador - OK");
		
		return gson.toJson(retorno);
	}
	
	
	@POST
	@Path("/atualizaJogador")
	public String atualizaJogador() {
		
		return "<html><body><h1>atualizaJogador</body></h1></html>";
	}
	
	
	
	
	
	
	
	
	
	
}
