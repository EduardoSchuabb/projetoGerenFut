package br.com.gerenFut.DTO;

public class TimeTabelaRequisicaoDTO {

	private String time_id;
	private String nome_popular;
	private String escudo;
	
	
	public TimeTabelaRequisicaoDTO() {
		
	}
	
	public String getTime_id() {
		return time_id;
	}
	public void setTime_id(String time_id) {
		this.time_id = time_id;
	}
	public String getNome_popular() {
		return nome_popular;
	}
	public void setNome_popular(String nome_popular) {
		this.nome_popular = nome_popular;
	}
	public String getEscudo() {
		return escudo;
	}
	public void setEscudo(String escudo) {
		this.escudo = escudo;
	}

	@Override
	public String toString() {
		return "TimeTabelaRequisicaoDTO [time_id=" + time_id + ", nome_popular=" + nome_popular + ", escudo=" + escudo
				+ "]";
	}
	
}
