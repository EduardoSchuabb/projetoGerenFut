package br.com.gerenFut.util;

import java.util.List;

import br.com.gerenFut.model.*;
import br.com.gerenFut.persistence.TimesDAO;

public class TimesNegocio {

	TimesDAO TimesDAO = new TimesDAO();
	
	
	public TimesNegocio() {
		
	}
	
	public List<Times> obterTodosOsTimes(){
		
		return TimesDAO.obterTodosTimes();
	}
	
	
}
