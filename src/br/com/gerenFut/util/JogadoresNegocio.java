package br.com.gerenFut.util;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.DTO.JogadoresDTO;
import br.com.gerenFut.persistence.JogadoresDAO;

public class JogadoresNegocio {

	JogadoresDAO timesDAO = new JogadoresDAO();
	private static final Logger LOGGER = Logger.getLogger(JogadoresNegocio.class);
	
	public JogadoresNegocio() {
		
	}
	
	public void removerJogador(String id) {
		LOGGER.info("JogadoresNegocio - removerJogador");
		
		
	}
	
	
	public void salvarJogador(JogadoresDTO jogadorDTO) {
		LOGGER.info("JogadoresNegocio - salvarJogador");
		
		
	}
	
	
	
	
}
