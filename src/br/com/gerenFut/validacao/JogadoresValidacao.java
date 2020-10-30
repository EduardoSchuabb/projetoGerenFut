package br.com.gerenFut.validacao;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.DTO.JogadoresDTO;
import br.com.gerenFut.model.Jogadores;
import br.com.gerenFut.persistence.JogadoresDAO;

public class JogadoresValidacao {

	
	private static final Logger LOGGER = Logger.getLogger(JogadoresValidacao.class);
	private TimesValidacao timesValidacao = new TimesValidacao();
	private JogadoresDAO jogadoresDAO = new JogadoresDAO();
	
	public JogadoresValidacao() {
		
	}
	
	public int validarCriacaoInfoJogador(JogadoresDTO jogador) {
		
		LOGGER.info("JogadoresValidacao - validarCriacaoInfoJogador");
	
		int retorno = 0;
	
		if(jogador.getNome() == null || jogador.getNome().isEmpty()) {
			LOGGER.severe("Validacao de criacao de jogador - Nome vazio.");
			retorno = -1;
		}
		if(jogador.getPosicao() == null || jogador.getPosicao().isEmpty()) {
			LOGGER.severe("Validacao de criacao de jogador - Posicao vazio.");
			retorno = -2;
		}
		if(jogador.getPosicao() == null || jogador.getPosicao().isEmpty()) {
			LOGGER.severe("Validacao de criacao de jogador - Posicao vazio.");
			retorno = -2;
		}
		if(!timesValidacao.verificarSeExisteTimePorId(jogador.getIdTime())) {
			LOGGER.severe("Validacao de criacao de jogador - Time nao existe.");
			retorno = -3;
		}
		
		return retorno;
	}
	
	public Boolean verificaSeExisteJogadorPorNome(String nome) {
		LOGGER.info("JogadoresValidacao - validarCriacaoInfoJogador");
		
		Jogadores jogadorBanco = jogadoresDAO.obterJogadorNome(nome);
		
		return (jogadorBanco != null);
	}
	
	
	
}
