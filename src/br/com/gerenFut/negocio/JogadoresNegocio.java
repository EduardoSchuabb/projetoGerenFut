package br.com.gerenFut.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.DTO.JogadoresDTO;
import br.com.gerenFut.model.Jogadores;
import br.com.gerenFut.model.Times;
import br.com.gerenFut.persistence.JogadoresDAO;
import br.com.gerenFut.persistence.TimesDAO;

public class JogadoresNegocio {

	JogadoresDAO jogadoresDAO = new JogadoresDAO();
	TimesDAO timesDAO = new TimesDAO();
	private static final Logger LOGGER = Logger.getLogger(JogadoresNegocio.class);
	
	public JogadoresNegocio() {
		
	}
	
	public void removerJogador(String id) {
		LOGGER.info("JogadoresNegocio - removerJogador");
		jogadoresDAO.removerJogador(id);
	}
	
	
	public void salvarJogador(JogadoresDTO jogadorDTO) {
		LOGGER.info("JogadoresNegocio - salvarJogador");
		Jogadores jogador = new Jogadores();
		jogador.setNome(jogadorDTO.getNome());
		jogador.setAltura(jogadorDTO.getAltura());
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataFormatada;
		try {
			dataFormatada = formato.parse(jogadorDTO.getDataNascimento());
			jogador.setDataNascimento(dataFormatada);
		} catch (ParseException e) {
			jogador.setDataNascimento(null);
		}
		jogador.setNacionalidade(jogadorDTO.getNacionalidade());
		jogador.setPosicao(jogadorDTO.getPosicao());
		jogador.setValorMercado(jogadorDTO.getValorMercado());
		Times timeJogador = timesDAO.obterTimeNome(jogadorDTO.getNomeTime());
		jogador.setTime(timeJogador);
		
		jogadoresDAO.salvarJogador(jogador);
		
	}
	
	public void atualizarJogador(JogadoresDTO jogadorDTO, String jogadorId) {
		LOGGER.info("JogadoresNegocio - atualizarJogador");
		
		Jogadores jogador = new Jogadores();
		jogador.setNome(jogadorDTO.getNome());
		jogador.setAltura(jogadorDTO.getAltura());
		jogador.setId(Integer.parseInt(jogadorId));
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataFormatada;
		try {
			dataFormatada = formato.parse(jogadorDTO.getDataNascimento());
			jogador.setDataNascimento(dataFormatada);
		} catch (ParseException e) {
			jogador.setDataNascimento(null);
		}
		jogador.setNacionalidade(jogadorDTO.getNacionalidade());
		jogador.setPosicao(jogadorDTO.getPosicao());
		jogador.setValorMercado(jogadorDTO.getValorMercado());
		Times timeJogador = timesDAO.obterTimeNome(jogadorDTO.getNomeTime());
		jogador.setTime(timeJogador);
		
		jogadoresDAO.atualizarJogador(jogador);
	}
	
	public List<JogadoresDTO> obterJogadoresPorTime(String timeNome){
		LOGGER.info("JogadoresNegocio - obterJogadoresPorTime");
		
		Times time = timesDAO.obterTimeNome(timeNome);
		
		List<Jogadores> jogadores =  jogadoresDAO.obterJogadoresPorTime(time);
		
		List<JogadoresDTO> jogadoresInfo = new ArrayList<>();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		for(Jogadores jogador : jogadores) {
			
			String dataNascimento = jogador.getDataNascimento() != null ? 
					formato.format(jogador.getDataNascimento()) : "sem data";
			
			JogadoresDTO jogadorDTOTemp = new JogadoresDTO();
			jogadorDTOTemp.setNome(jogador.getNome());
			jogadorDTOTemp.setDataNascimento(dataNascimento);
			jogadorDTOTemp.setAltura(jogador.getAltura());
			jogadorDTOTemp.setPosicao(jogador.getPosicao());
			jogadorDTOTemp.setValorMercado(jogador.getValorMercado());
			jogadorDTOTemp.setNacionalidade(jogador.getNacionalidade());
			jogadorDTOTemp.setNomeTime(jogador.getTime().getNome());
			
			jogadoresInfo.add(jogadorDTOTemp);
			
		}
		
		return jogadoresInfo;
	}
	
	
	
	
}
