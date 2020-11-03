package br.com.gerenFut.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.istack.logging.Logger;


import br.com.gerenFut.DTO.RequisicaoTabelaDTO;
import br.com.gerenFut.DTO.TimeRequisicaoDTO;
import br.com.gerenFut.DTO.TimeTabelaRequisicaoDTO;
import br.com.gerenFut.negocio.TimesNegocio;

public class RequisicaoAPIFutebol {

	private static final Logger LOGGER = Logger.getLogger(RequisicaoAPIFutebol.class);
	private static final String TOKENAUTORIZACAO = "Bearer live_3c611cad490bd8268ddf6204883099";
	TimesNegocio timesNegocio = new TimesNegocio();
	
	
	public RequisicaoAPIFutebol() {
		
	}
	
	
	public List<RequisicaoTabelaDTO> requisicaoAPIFutebolObterTabela() {
		
		LOGGER.info("RequisicaoAPIFutebol - requisicaoAPIFutebolObterTimes");
		try {
			URL url = new URL("https://api.api-futebol.com.br/v1/campeonatos/10/tabela");
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			conexao.setRequestMethod("GET");
			conexao.setRequestProperty("Authorization", TOKENAUTORIZACAO);
			
			if (conexao.getResponseCode() != 200) {
				LOGGER.severe("Erro " + conexao.getResponseCode() + " ao obter dados da URL " + url);
			}		
			BufferedReader buffer = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String output = buffer.readLine();
	
            conexao.disconnect();
            
            Gson gson = new Gson();
            Type type = new TypeToken<List<RequisicaoTabelaDTO>>(){}.getType();
            List<RequisicaoTabelaDTO> listaRequisicaoTabelaDTO = gson.fromJson(output, type);
            
            LOGGER.info("RequisicaoAPIFutebol - requisicaoAPIFutebolObterTimes - OK");
            // Chamar o metodo para salvar as informacoes dos campeonatos.
            return listaRequisicaoTabelaDTO;
            
//            for(RequisicaoTabelaDTO testeDto : listaRequisicaoTabelaDTO)
//            	LOGGER.info(testeDto.toString());
            
		} catch (IOException e) {
			//e.printStackTrace();
			LOGGER.severe("Erro de requisicao. - ", e);
			return null;
		}
	}
	

	public void requisicaoAPIFutebolObterInfoTimes() {
		
		List<RequisicaoTabelaDTO> listaTabelaDTO = requisicaoAPIFutebolObterTabela();
		List<TimeTabelaRequisicaoDTO> timeTabelaRequisicaoDTO = new ArrayList<TimeTabelaRequisicaoDTO>();
		
		for(RequisicaoTabelaDTO linhaTabelaDto : listaTabelaDTO) {
			timeTabelaRequisicaoDTO.add(linhaTabelaDto.getTime());
			LOGGER.info(linhaTabelaDto.getTime().getTime_id());
			this.requisicaoAPIFutebolObterSiglaTimes(linhaTabelaDto.getTime().getTime_id());
			
			
		}
			
	}
	
	public void requisicaoAPIFutebolObterSiglaTimes(String apiIdTime) {
		LOGGER.info("RequisicaoAPIFutebol - requisicaoAPIFutebolObterSiglaTimes");
		try {
			URL url = new URL("https://api.api-futebol.com.br/v1/times/" + apiIdTime);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			conexao.setRequestMethod("GET");
			conexao.setRequestProperty("Authorization", TOKENAUTORIZACAO);
			
			if (conexao.getResponseCode() != 200) {
				LOGGER.severe("Erro " + conexao.getResponseCode() + " ao obter dados da URL " + url);
			}
			BufferedReader buffer = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String output = buffer.readLine();
	
            conexao.disconnect();
			
            Gson gson = new Gson();
            Type type = new TypeToken<TimeRequisicaoDTO>(){}.getType();
            TimeRequisicaoDTO timeRequisicao= gson.fromJson(output, type);
            // Criar os metodos para atualizar/criar os times. Um por um.
            timesNegocio.salvarTimeFromApiFutebol(timeRequisicao);
            
			
		} catch (IOException e) {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
}
