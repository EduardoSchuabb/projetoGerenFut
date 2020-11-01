package br.com.gerenFut.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.model.Times;



public class TimesDAO{
	
	
	private static TimesDAO instance;
	protected EntityManager entityManager;
	private static final Logger LOGGER = Logger.getLogger(TimesDAO.class);
	
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
	
	public void removerTime(String id) {
		LOGGER.info("TimesDAO - removerTime");
		int idInteiro = Integer.parseInt(id);  
		
		Times time = entityManager.find(Times.class, idInteiro);
		
		entityManager.getTransaction().begin();
		entityManager.remove(time);
		entityManager.getTransaction().commit();
		entityManager.close();
	
		LOGGER.info("TimesDAO - removerTime - OK");
	}
	
	public void salvarTime(Times time) {
		LOGGER.info("TimesDAO - salvarTime");
		
		entityManager.getTransaction().begin();
		entityManager.persist(time);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("TimesDAO - salvarTime - OK");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Times> obterTodosTimes(){
		LOGGER.info("TimesDAO - obterTodosTimes");
		
		Query listaTodosTimes = entityManager.createQuery("from Times");
		
		List<Times> times = null;
		times = listaTodosTimes.getResultList();
		
		return times;
	}
	
	public Times obterTimeId(int id) {
		LOGGER.info("TimesDAO - obterTimeId");
		Times timeBanco = entityManager.find(Times.class, id);
		
		return timeBanco;
	}
	
	public Times obterTimeNome(String nome) {
		LOGGER.info("TimesDAO - obterTimeNome");

		Query queryTimePorNome = entityManager
				.createQuery("SELECT t FROM Times t WHERE t.nome = :timeNome")
				.setParameter("timeNome", nome);
		try {
			Times timeBanco = (Times) queryTimePorNome.getSingleResult();
			return timeBanco;
			
		} catch(Exception e) {
			return null;
		}
	}
	
	public void atualizarTime(Times time) {
		LOGGER.info("TimesDAO - atualizarTIme");
		entityManager.getTransaction().begin();
		entityManager.merge(time);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("TimesDAO - atualizarTime - OK");
	}
	
	
}













