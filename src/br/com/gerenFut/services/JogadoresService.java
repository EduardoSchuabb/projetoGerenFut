package br.com.gerenFut.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sun.istack.logging.Logger;

import br.com.gerenFut.DTO.JogadorInfoDTO;
import br.com.gerenFut.DTO.JogadoresDTO;
import br.com.gerenFut.negocio.JogadoresNegocio;
import br.com.gerenFut.validacao.JogadoresValidacao;

@Path("/jogadores")
public class JogadoresService {

	
	private JogadoresNegocio jogadoresNegocio = new JogadoresNegocio();
	private JogadoresValidacao jogadoresValidacao = new JogadoresValidacao();
	private static final Logger LOGGER = Logger.getLogger(JogadoresService.class);

	
	@GET
	@Path("/removeJogador/{jogadorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String removejogador(@PathParam("jogadorId") String id) {
		LOGGER.info("JogadoresService - removetime");
		
		Gson gson = new Gson();
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		
		if(jogadoresValidacao.existeJogadorPorId(Integer.parseInt(id)))
			jogadoresNegocio.removerJogador(id);
		else {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Jogador nao existe.")
					.build());
		}
		
		retorno.put("Removido", true);
		return gson.toJson(retorno);
	}
	
	@POST
	@Path("/criaJogadores")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String criaJogador(String jogadorJson) {
		LOGGER.info("JogadoresService - criaJogador");
		Gson gson = new Gson();
		JogadoresDTO jogadorDTO = gson.fromJson(jogadorJson, JogadoresDTO.class);
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		
		int validacao;
		validacao = jogadoresValidacao.validarInfoJogador(jogadorDTO);
		
		if(validacao == -1) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Nome do jogador � obrigat�rio")
					.build());
		}
		if(validacao == -2) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Posicao do jogador � obrigat�rio")
					.build());
		}
		if(validacao == -3) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Time n�o encontrado")
					.build());
		}
		if(!jogadoresValidacao.existeJogadorPorNome(jogadorDTO.getNome()))
			jogadoresNegocio.salvarJogador(jogadorDTO);
		else {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Jogador ja existe.")
					.build());
		}
		
		retorno.put("Confirmacao", true);
		LOGGER.info("JogadoresService - criaJogador - OK");
		
		return gson.toJson(retorno);
	}
	
	@PUT
	@Path("/atualizaJogador/{jogadorId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String atualizaJogador(@PathParam("jogadorId") String jogadorId, String jogadorJson) {
		
		LOGGER.info("JogadoresService - atualizaJogador");
		
		Gson gson = new Gson();
		JogadoresDTO jogadorDTO = gson.fromJson(jogadorJson, JogadoresDTO.class);
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		
		int validacao;
		validacao = jogadoresValidacao.validarInfoJogador(jogadorDTO);
		
		if(validacao == -1) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Nome do jogador � obrigat�rio")
					.build());
		}
		if(validacao == -2) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Posicao do jogador � obrigat�rio")
					.build());
		}
		if(validacao == -3) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Time n�o encontrado")
					.build());
		}
		if(jogadoresValidacao.existeJogadorPorNome(jogadorDTO.getNome()))
			jogadoresNegocio.atualizarJogador(jogadorDTO, jogadorId);
		else {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Jogador n�o existe.")
					.build());
		}
		
		retorno.put("Atualizado", true);
		return gson.toJson(retorno);
	}
	
	@GET
	@Path("/jogadorePorTime/{nomeTime}")
	@Produces(MediaType.APPLICATION_JSON)
	public String obterJogadoresPorTime(@PathParam("nomeTime") String nomeTime) {
		LOGGER.info("JogadoresService - obterJogadoresPorTime");
		
		Gson gson = new Gson();
		List<JogadorInfoDTO> jogadoresInfo = jogadoresNegocio.obterJogadoresPorTime(nomeTime);
		
		
		Map<String, List<JogadorInfoDTO>> retorno = new HashMap<String, List<JogadorInfoDTO>>();
		retorno.put("Jogadores", jogadoresInfo);
		
		LOGGER.info("JogadoresService - obterJogadoresPorTime - OK");
		return gson.toJson(retorno);
			
	}
	
	
	
	
	
	
	
}
