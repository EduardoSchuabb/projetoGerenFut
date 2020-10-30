package br.com.gerenFut.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.model.Jogadores;

public class JogadoresDAO {

	private static JogadoresDAO instance;
	protected EntityManager entityManager;
	private static final Logger LOGGER = Logger.getLogger(JogadoresDAO.class);
	
	public static JogadoresDAO getInstance() {
		
		if(instance == null)
			instance = new JogadoresDAO();
	
		return instance;
	}
	
	public JogadoresDAO() {
		entityManager = getEntityManager();	
	}
	
	private EntityManager getEntityManager() {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		
		if (entityManager == null) 
			entityManager = factory.createEntityManager();
		
		return entityManager;
	}
	
	
	public void salvarJogador(Jogadores jogador) {
		LOGGER.info("JogadoresDAO - salvarJogador");
		
		entityManager.getTransaction().begin();
		entityManager.persist(jogador);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("JogadoresDAO - salvarJogador - OK");
	}
	
	public void removerJogador(String id) {
		LOGGER.info("JogadoresDAO - removerJogador");
		int idInteiro = Integer.parseInt(id);  
		
		Jogadores jogador = entityManager.find(Jogadores.class, idInteiro);
		
		entityManager.getTransaction().begin();
		entityManager.remove(jogador);
		entityManager.getTransaction().commit();
		entityManager.close();
	
		LOGGER.info("JogadoresDAO - removerJogador - OK");
	}
	
	public Jogadores obterJogaresId(int id) {
		
		LOGGER.info("JogadoresDAO - obterJogaresId");
		Jogadores jogador = entityManager.find(Jogadores.class, id);
		
		return jogador;
	}
	
	public Jogadores obterJogadorNome(String nome) {
		LOGGER.info("JogadoresDAO - obterJogadorNome");
		//Times timeBanco = entityManager.find(Times.class, id);
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
		entityManager.getTransaction().begin();
		entityManager.merge(jogador);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("JogadoresDAO - atualizarJogador - OK");
	}
	
	
}
