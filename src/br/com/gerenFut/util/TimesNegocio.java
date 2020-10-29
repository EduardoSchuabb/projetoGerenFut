package br.com.gerenFut.util;

import java.util.List;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.DTO.TimesDTO;
import br.com.gerenFut.model.*;
import br.com.gerenFut.persistence.TimesDAO;

public class TimesNegocio {

	TimesDAO timesDAO = new TimesDAO();
	private static final Logger LOGGER = Logger.getLogger(TimesNegocio.class);
	
	public TimesNegocio() {
		
	}
	
	public void removerTime(String id) {
		LOGGER.info("TimesNegocio - removerTime");
			
		timesDAO.removerTime(id);
	
	}
	
	
	public List<Times> obterTodosOsTimes(){
		LOGGER.info("TimesNegocio - obterTodosOsTimes");
		
		return timesDAO.obterTodosTimes();
	}
	
	public void salvarTime(TimesDTO timeDTO) {
		LOGGER.info("TimesNegocio - salvarTime");
		
		Times time = new Times();
		time.setNome(timeDTO.getNome());
		time.setEstado(timeDTO.getEstado());
		time.setQtdJogadores(timeDTO.getQtdJogadores());
		
		timesDAO.salvarTime(time);
		
	}
	
	
}
