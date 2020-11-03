package br.com.gerenFut.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.model.Times;



public class TimesDAO{
	
	private static final Logger LOGGER = Logger.getLogger(TimesDAO.class);
	
	
	public TimesDAO() {
		
	}
	
	public void removerTime(String id) {
		LOGGER.info("TimesDAO - removerTime");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		
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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(time);
		entityManager.flush();
		entityManager.clear();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("TimesDAO - salvarTime - OK");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Times> obterTodosTimes(){
		LOGGER.info("TimesDAO - obterTodosTimes");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		Query listaTodosTimes = entityManager.createQuery("from Times");
		
		List<Times> times = null;
		times = listaTodosTimes.getResultList();
		
		return times;
	}
	
	public Times obterTimeId(int id) {
		LOGGER.info("TimesDAO - obterTimeId");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		Times timeBanco = entityManager.find(Times.class, id);
		
		return timeBanco;
	}
	
	public Times obterTimeNome(String nome) {
		LOGGER.info("TimesDAO - obterTimeNome");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(time);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("TimesDAO - atualizarTime - OK");
	}
	
	
}













