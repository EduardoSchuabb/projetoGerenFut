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
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.istack.logging.Logger;

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
	public Response removejogador(@PathParam("jogadorId") String id) {
		LOGGER.info("JogadoresService - removetime");
		
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		
		if(jogadoresValidacao.existeJogadorPorId(Integer.parseInt(id)))
			jogadoresNegocio.removerJogador(id);
		else {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Jogador nao existe.")
					.build());
		}
		
		retorno.put("Removido", true);
		return Response.ok(retorno).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@POST
	@Path("/criaJogadores")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response criaJogador(JogadoresDTO jogadorDTO) {
		LOGGER.info("JogadoresService - criaJogador");
		
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		
		int validacao;
		validacao = jogadoresValidacao.validarInfoJogador(jogadorDTO);
		
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
					Response.status(Response.Status.BAD_REQUEST).entity("Time não encontrado")
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
		
		return Response.ok(retorno).header("Access-Control-Allow-Origin", "*").build();
	}
	
	// Esse metodo mudara em um futuro proximo.
	// Objetivo: nao faz sentido utilizar o jogadorId
	@PUT
	@Path("/atualizaJogador/{jogadorId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaJogador(@PathParam("jogadorId") String jogadorId, JogadoresDTO jogadorDTO) {
		
		LOGGER.info("JogadoresService - atualizaJogador");
		
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		
		int validacao;
		validacao = jogadoresValidacao.validarInfoJogador(jogadorDTO);
		
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
					Response.status(Response.Status.BAD_REQUEST).entity("Time não encontrado")
					.build());
		}
		if(jogadoresValidacao.existeJogadorPorNome(jogadorDTO.getNome()))
			jogadoresNegocio.atualizarJogador(jogadorDTO, jogadorId);
		else {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Jogador não existe.")
					.build());
		}
		
		retorno.put("Atualizado", true);
		return Response.ok(retorno).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@GET
	@Path("/jogadorePorTime/{nomeTime}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterJogadoresPorTime(@PathParam("nomeTime") String nomeTime) {
		LOGGER.info("JogadoresService - obterJogadoresPorTime");
		
		List<JogadoresDTO> jogadoresInfo = jogadoresNegocio.obterJogadoresPorTime(nomeTime);
		GenericEntity<List<JogadoresDTO>> retorno = new GenericEntity<List<JogadoresDTO>>(jogadoresInfo) {};
		
		
		LOGGER.info("JogadoresService - obterJogadoresPorTime - OK");
		return Response.ok(retorno).header("Access-Control-Allow-Origin", "*").build();
			
	}
	
	
	
	
	
	
	
}
