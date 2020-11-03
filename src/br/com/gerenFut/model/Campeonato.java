package br.com.gerenFut.model;

import java.util.Date;
import java.util.List;


public class Campeonato {

	private String nome;
	private Date dataInicio;
	private Date dataFim;
	private TabelaCampeonato tabela;
	private List<Double> premiacao;
	private List<Jogo> jogos;
	
	
	public Campeonato() {
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public TabelaCampeonato getTabela() {
		return tabela;
	}
	public void setTabela(TabelaCampeonato tabela) {
		this.tabela = tabela;
	}
	public List<Double> getPremiacao() {
		return premiacao;
	}
	public void setPremiacao(List<Double> premiacao) {
		this.premiacao = premiacao;
	}
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	} 
	
	
	
}
