package br.com.gerenFut.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.model.TabelaCampeonato;
import br.com.gerenFut.model.Times;


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
	
	public void atualizarTabelaCampeonato(TabelaCampeonato novaLinhaTabela, int idLinhaTabelaCampeonato) {
		LOGGER.info("TabelaCampeonatoDAO - atualizarTabelaCampeonato");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		TabelaCampeonato antigaLinhaTabela = entityManager.find(TabelaCampeonato.class, idLinhaTabelaCampeonato);
		entityManager.getTransaction().begin();
		
		// Atualizar as informacoes antigas.
		if(antigaLinhaTabela != null) {
			antigaLinhaTabela.setAproveitamento(novaLinhaTabela.getAproveitamento());
			antigaLinhaTabela.setGolsContra(novaLinhaTabela.getGolsContra());
			antigaLinhaTabela.setGolsPro(novaLinhaTabela.getGolsPro());
			antigaLinhaTabela.setPontos(novaLinhaTabela.getPontos());
			antigaLinhaTabela.setPosicao(novaLinhaTabela.getPontos());
			antigaLinhaTabela.setQuantDerrotas(novaLinhaTabela.getQuantDerrotas());
			antigaLinhaTabela.setQuantEmpates(novaLinhaTabela.getQuantEmpates());
			antigaLinhaTabela.setQuantJogos(novaLinhaTabela.getQuantJogos());
			antigaLinhaTabela.setQuantVitorias(novaLinhaTabela.getQuantVitorias());
			antigaLinhaTabela.setSaldoGols(novaLinhaTabela.getSaldoGols());
			antigaLinhaTabela.setUltimosJogos(novaLinhaTabela.getUltimosJogos());
			antigaLinhaTabela.setVariacaoPosicao(novaLinhaTabela.getVariacaoPosicao());
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		LOGGER.info("TabelaCampeonatoDAO - atualizarTabelaCampeonato - OK");
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
		entityManager.getTransaction().begin();
		tabela = queryTabela.getResultList();
		entityManager.close();
		return tabela;
	}
	
	public TabelaCampeonato obterLinhaDaTabelaByTimeId(Times time){
		LOGGER.info("TabelaCampeonatoDAO - obterLinhaDaTabelaByTimeId");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudGerenFut");
		EntityManager entityManager = factory.createEntityManager();
		Query queryTabela = entityManager
				.createQuery("SELECT t FROM TabelaCampeonato t WHERE t.time = :time")
				.setParameter("time", time);
		TabelaCampeonato linhaCampeonato;
		entityManager.getTransaction().begin();
		
		try {
			linhaCampeonato = (TabelaCampeonato) queryTabela.getSingleResult();
		}catch(Exception e) {
			linhaCampeonato = null;
		} finally {
			entityManager.close();
		}
		
		return linhaCampeonato;
	}
	
	
	
	
	
}
