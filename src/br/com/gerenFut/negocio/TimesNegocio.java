package br.com.gerenFut.negocio;

import java.util.ArrayList;
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
	
	public void atualizarTime(TimesDTO timeDTO) {
		LOGGER.info("TimesNegocio - atualizarTime");
		// Procurar o time a partir do timeDTO.
		
		Times time = timesDAO.obterTimeNome(timeDTO.getNome());
		
		timesDAO.atualizarTime(time);
	}
	
	public void removerTime(String id) {
		LOGGER.info("TimesNegocio - removerTime");	
		timesDAO.removerTime(id);
	}
	
	public List<TimesDTO> obterTodosOsTimes(){
		LOGGER.info("TimesNegocio - obterTodosOsTimes");
		List<TimesDTO> timesDTO = new ArrayList<TimesDTO>();
		List<Times> times = new ArrayList<Times>();
		
		times = timesDAO.obterTodosTimes();
		for(Times time : times) {
			TimesDTO timeTemp = new TimesDTO();
			timeTemp.setEstado(time.getEstado());
			timeTemp.setLinkImagem(time.getLinkImagem());
			timeTemp.setNome(time.getNome());
			timeTemp.setQtdJogadores(time.getQtdJogadores());
			timeTemp.setSigla(time.getSigla());
			timesDTO.add(timeTemp);
		}
		return timesDTO;
	}
	
	public void salvarTime(TimesDTO timeDTO) {
		LOGGER.info("TimesNegocio - salvarTime");
		
		Times time = new Times();
		time.setNome(timeDTO.getNome().toLowerCase());
		time.setEstado(timeDTO.getEstado());
		time.setQtdJogadores(timeDTO.getQtdJogadores());
		time.setSigla(timeDTO.getSigla());
		time.setLinkImagem(timeDTO.getLinkImagem());
		
		timesDAO.salvarTime(time);
	}
	
	public void salvarTimeFromApiFutebol(Times time) {
		LOGGER.info("TimesNegocio - salvarTimeFromApiFutebol");
		timesDAO.salvarTime(time);
		
	}
	
	
}
