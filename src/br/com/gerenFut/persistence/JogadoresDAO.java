package br.com.gerenFut.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.istack.logging.Logger;


import br.com.gerenFut.model.Jogadores;
import br.com.gerenFut.model.Times;

public class JogadoresDAO {

	private static final Logger LOGGER = Logger.getLogger(JogadoresDAO.class);
	
	public JogadoresDAO() {
		
	}
	
	public void salvarJogador(Jogadores jogador) {
		LOGGER.info("JogadoresDAO - salvarJogador");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(jogador);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("JogadoresDAO - salvarJogador - OK");
	}
	
	public void removerJogador(String id) {
		LOGGER.info("JogadoresDAO - removerJogador");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		int idInteiro = Integer.parseInt(id);  
		
		Jogadores jogador = entityManager.find(Jogadores.class, idInteiro);
		
		entityManager.getTransaction().begin();
		entityManager.remove(jogador);
		entityManager.getTransaction().commit();
		entityManager.close();
	
		LOGGER.info("JogadoresDAO - removerJogador - OK");
	}
	
	public Jogadores obterJogardorId(int id) {
		LOGGER.info("JogadoresDAO - obterJogaresId");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		Jogadores jogador = entityManager.find(Jogadores.class, id);
		
		return jogador;
	}
	
	public Jogadores obterJogadorNome(String nome) {
		LOGGER.info("JogadoresDAO - obterJogadorNome");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		Query queryTimePorNome = entityManager
				.createQuery("SELECT j FROM Jogadores j WHERE j.nome = :jogadorNome")
				.setParameter("jogadorNome", nome);
		try {
			Jogadores jogadorBanco = (Jogadores) queryTimePorNome.getSingleResult();
			return jogadorBanco;
			
		} catch(Exception e) {
			return null;
		}
	}
	
	public void atualizarJogador(Jogadores jogador) {
		LOGGER.info("JogadoresDAO - atualizarJogador");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(jogador);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("JogadoresDAO - atualizarJogador - OK");
	}
	
	@SuppressWarnings("unchecked")
	public List<Jogadores> obterJogadoresPorTime(Times time){
		LOGGER.info("JogadoresDAO - obterJogadoresPorTime");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		Query queryJogadoresPorTime = entityManager
				.createQuery("SELECT j FROM Jogadores j WHERE j.time = :time")
				.setParameter("time", time);
		
		List<Jogadores> jogadoresTime = null;
		jogadoresTime = queryJogadoresPorTime.getResultList();
		
		return jogadoresTime;
	}
	
	
}
