package br.com.gerenFut.DTO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class TimesDTO {

	
	private String nome;
	private String estado;
	private int qtdJogadores;
	
	public TimesDTO() {
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getQtdJogadores() {
		return qtdJogadores;
	}
	
	public void setQtdJogadores(int qtdJogadores) {
		this.qtdJogadores = qtdJogadores;
	}

	
	
	
}
