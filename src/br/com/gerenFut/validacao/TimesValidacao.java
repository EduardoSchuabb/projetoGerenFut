package br.com.gerenFut.validacao;


import com.sun.istack.logging.Logger;

import br.com.gerenFut.DTO.TimesDTO;
import br.com.gerenFut.model.Times;
import br.com.gerenFut.persistence.TimesDAO;

public class TimesValidacao {

	TimesDAO timesDAO = new TimesDAO();
	private static final Logger LOGGER = Logger.getLogger(TimesValidacao.class);

	
	public TimesValidacao() {
		
	}
	
	public int validarCriacaoInfoTime(TimesDTO time) {
		
		LOGGER.info("TimesValidacao - validarCriacaoInfoTime");
		int retorno = 0;
		
		if(time.getNome() == null || time.getNome().isEmpty()) {
			LOGGER.severe("Validacao de criacao de time - Nome vazio.");
			retorno = -1;
		}
		if(time.getEstado() == null || time.getEstado().isEmpty()) {
			LOGGER.severe("Validacao de criacao de time - Estado vazio.");
			retorno = -2;
		}
		
		return retorno;
	}
	
	public int validarModicacaoInfoTime(Times time) {
		LOGGER.info("TimesValidacao - validarModicacaoInfoTime");
		
		int retorno = 0;
		
		if(time.getNome() == null || time.getNome().isEmpty()) {
			LOGGER.severe("Validacao de atualizacao de time - Nome vazio.");
			retorno = -1;
		}
		if(time.getEstado() == null || time.getEstado().isEmpty()) {
			LOGGER.severe("Validacao de atualizacao de time - Estado vazio.");
			retorno = -2;
		}
		
		return retorno;
	}
	
	public Boolean verificarSeExisteTimePorId(int id) {
		LOGGER.info("TimesValidacao - verificarSeExisteTimePorId");
		Times timeBanco = timesDAO.obterTimeId(id);
		return (timeBanco != null);
		
	}
	
	public Boolean verificaSeExisteTimePorNome(String nome) {
		LOGGER.info("TimesValidacao - verificaSeExisteTimePorNome");
		
		Times timeBanco = timesDAO.obterTimeNome(nome);
		
		return (timeBanco != null);
	}
	
	
	
}
