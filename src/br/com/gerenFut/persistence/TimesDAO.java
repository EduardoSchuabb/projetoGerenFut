package br.com.gerenFut.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.gerenFut.model.Times;



public class TimesDAO{
	
	
	private static TimesDAO instance;
	protected EntityManager entityManager;
	
	public static TimesDAO getInstance() {
		
		if(instance == null)
			instance = new TimesDAO();
	
		return instance;
	
	}
	
	public TimesDAO() {
	
		entityManager = getEntityManager();
		
	}
	
	private EntityManager getEntityManager() {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		
		if (entityManager == null) 
			entityManager = factory.createEntityManager();
		
		return entityManager;
		
	}
	
	public void salvarTime(Times time) {
		
				
	}
	
	@SuppressWarnings("unchecked")
	public List<Times> obterTodosTimes(){
		
		Query listaTodosQuery = entityManager.createQuery("from Times");
		
		
		List<Times> times = null;
		times = listaTodosQuery.getResultList();
		
		return times;
	}
	
	
}













