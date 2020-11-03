package br.com.gerenFut.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.model.TabelaCampeonato;


public class TabelaCampeonatoDAO {

	private static final Logger LOGGER = Logger.getLogger(TabelaCampeonatoDAO.class);
	
	
	public TabelaCampeonatoDAO() {

	}
	
	public void salvarTabelaCampeonato(TabelaCampeonato linhaTabela) {
		LOGGER.info("TabelaCampeonatoDAO - salvarTabelaCampeonato");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(linhaTabela);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("TabelaCampeonatoDAO - salvarTabelaCampeonato - OK");
	}
	
	public void removerLinhaTabela(String id) {
		LOGGER.info("TabelaCampeonatoDAO - removerLinhaTabela");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		Query queryTabela = entityManager.createQuery("from TabelaCampeonato");
		List<TabelaCampeonato> tabela = null;
		tabela = queryTabela.getResultList();
		return tabela;
	}
	
	
}
