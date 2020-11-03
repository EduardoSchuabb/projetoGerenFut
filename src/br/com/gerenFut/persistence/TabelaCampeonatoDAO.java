package br.com.gerenFut.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.model.TabelaCampeonato;


public class TabelaCampeonatoDAO {

	
	private static TabelaCampeonatoDAO instance;
	protected EntityManager entityManager;
	private static final Logger LOGGER = Logger.getLogger(TabelaCampeonatoDAO.class);
	
	
	public static TabelaCampeonatoDAO getInstance() {
		
		if(instance == null)
			instance = new TabelaCampeonatoDAO();
	
		return instance;
	}
	
	
	public TabelaCampeonatoDAO() {
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		if (entityManager == null) 
			entityManager = factory.createEntityManager();
		return entityManager;
	}
	
	public void salvarTabelaCampeonato(TabelaCampeonato linhaTabela) {
		LOGGER.info("TabelaCampeonatoDAO - salvarTabelaCampeonato");
		
		entityManager.getTransaction().begin();
		entityManager.persist(linhaTabela);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("TabelaCampeonatoDAO - salvarTabelaCampeonato - OK");
	}
	
	public void removerLinhaTabela(String id) {
		LOGGER.info("TabelaCampeonatoDAO - removerLinhaTabela");
		int idInteiro = Integer.parseInt(id);
		
		TabelaCampeonato linhaTabela = entityManager.find(TabelaCampeonato.class, idInteiro);
		
		entityManager.getTransaction().begin();
		entityManager.remove(linhaTabela);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("TabelaCampeonatoDAO - removerLinhaTabela - OK");
	}
	
	@SuppressWarnings("unchecked")
	public List<TabelaCampeonato> obterTabela(){
		LOGGER.info("TabelaCampeonatoDAO - obterTabela");
		Query queryTabela = entityManager.createQuery("from TabelaCampeonato");
		List<TabelaCampeonato> tabela = null;
		tabela = queryTabela.getResultList();
		return tabela;
	}
	
	
}
