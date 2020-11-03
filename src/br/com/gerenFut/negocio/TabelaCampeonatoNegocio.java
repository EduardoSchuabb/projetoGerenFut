package br.com.gerenFut.negocio;

import java.util.List;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.DTO.RequisicaoTabelaDTO;
import br.com.gerenFut.model.TabelaCampeonato;
import br.com.gerenFut.model.Times;
import br.com.gerenFut.persistence.TabelaCampeonatoDAO;
import br.com.gerenFut.persistence.TimesDAO;

public class TabelaCampeonatoNegocio {

	private static final Logger LOGGER = Logger.getLogger(TabelaCampeonatoNegocio.class);
	private TimesDAO timesDAO = new TimesDAO();
	private TabelaCampeonatoDAO tabelaCampeonatoDAO = new TabelaCampeonatoDAO();
	
	public TabelaCampeonatoNegocio() {
		
	}
	
	private TabelaCampeonato setTabelaCampeonatoPorRequisicaoDTO(RequisicaoTabelaDTO linhaTabelaDTO) {
		LOGGER.info("TabelaCampeonatoNegocio - setTabelaCampeonatoPorRequisicaoDTO");
		TabelaCampeonato linhaTabela = new TabelaCampeonato();
		
		linhaTabela.setAproveitamento(Double.parseDouble(linhaTabelaDTO.getAproveitamento()));
		linhaTabela.setGolsContra(Integer.parseInt(linhaTabelaDTO.getGols_contra()));
		linhaTabela.setGolsPro(Integer.parseInt(linhaTabelaDTO.getGols_pro()));
		linhaTabela.setPontos(Integer.parseInt(linhaTabelaDTO.getPontos()));
		linhaTabela.setPosicao(Integer.parseInt(linhaTabelaDTO.getPosicao()));
		linhaTabela.setQuantDerrotas(Integer.parseInt(linhaTabelaDTO.getDerrotas()));
		linhaTabela.setQuantEmpates(Integer.parseInt(linhaTabelaDTO.getEmpates()));
		linhaTabela.setQuantJogos(Integer.parseInt(linhaTabelaDTO.getJogos()));
		linhaTabela.setQuantVitorias(Integer.parseInt(linhaTabelaDTO.getVitorias()));
		linhaTabela.setSaldoGols(Integer.parseInt(linhaTabelaDTO.getSaldo_gols()));
		
		Times time = timesDAO.obterTimeNome(linhaTabelaDTO.getTime().getNome_popular());
		linhaTabela.setTime(time);
		linhaTabela.setUltimosJogos(linhaTabelaDTO.retornarUltimosJogosString());
		linhaTabela.setVariacaoPosicao(Integer.parseInt(linhaTabelaDTO.getSaldo_gols()));
		
		return linhaTabela;
	}
	
	public void salvarTabelaPorRequisicaoDTO(List<RequisicaoTabelaDTO>  listaTabelaDTO) {
		LOGGER.info("TabelaCampeonatoNegocio - salvarTabelaPorRequisicaoDTO");
		for(RequisicaoTabelaDTO linhaTabelaRequisicaoDTO : listaTabelaDTO) {
			TabelaCampeonato linhaTabela = setTabelaCampeonatoPorRequisicaoDTO(linhaTabelaRequisicaoDTO);
			tabelaCampeonatoDAO.salvarTabelaCampeonato(linhaTabela);
		}
		
		
		
	}
	
	
	
	
	
}
