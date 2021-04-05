package br.com.gerenFut.negocio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.istack.logging.Logger;

import br.com.gerenFut.DTO.JogadorInfoDTO;
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
	
	public List<JogadorInfoDTO> obterJogadoresPorTime(String timeNome){
		LOGGER.info("JogadoresNegocio - obterJogadoresPorTime");
		
		Times time = timesDAO.obterTimeNome(timeNome.toLowerCase());
		
		List<Jogadores> jogadores =  jogadoresDAO.obterJogadoresPorTime(time);
		
		List<JogadorInfoDTO> jogadoresInfo = new ArrayList<>();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		for(Jogadores jogador : jogadores) {
			
			String dataNascimento = jogador.getDataNascimento() != null ? 
					formato.format(jogador.getDataNascimento()) : "sem data";
			
			JogadorInfoDTO jogadorInfoTemp = new JogadorInfoDTO(jogador.getNome(), 
											dataNascimento,
											jogador.getAltura(),
											jogador.getPosicao(),
											jogador.getValorMercado(),
											jogador.getNacionalidade());
			
			jogadoresInfo.add(jogadorInfoTemp);
			
		}
		
		return jogadoresInfo;
	}
	
	
	
	
}
