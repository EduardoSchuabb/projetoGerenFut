package br.com.gerenFut.validacao;


import com.sun.istack.logging.Logger;

import br.com.gerenFut.DTO.TimesDTO;

public class TimesValidacao {

	private static final Logger LOGGER = Logger.getLogger(TimesValidacao.class);

	
	public TimesValidacao() {
		
	}
	
	public int validarCriacaoInfoTime(TimesDTO time) {
		
		LOGGER.info("validarCriacaoInfoTime");
		
		int retorno = 0;
		
		if(time.getNome() == null || time.getNome().isEmpty()) {
			LOGGER.severe("Validacao de criacao de time - Nome vazio.");
			retorno = -1;
		}
		if(time.getEstado() == null || time.getEstado().isEmpty()) {
			LOGGER.severe("Validacao de criacao de time - Estado vazio.");
			retorno = -2;
		}
		
		return retorno;
	}
	
	public void validarExclusaoInfoTime() {
		
		/* metodo responsavel por validar as informacoes
			para excluir alguma empresa.
			Exemplo de validacoes:
			 	- Se empresa existe;
			 	- Se a pessoa que informa querer excluir eh dono da empresa
		*/
	}
	
}
