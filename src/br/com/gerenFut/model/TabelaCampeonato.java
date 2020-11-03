package br.com.gerenFut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_campeonato")
public class TabelaCampeonato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdTabela")
	@SequenceGenerator(name="seqIdTabela",sequenceName="tabela_campeonato_id_seq", initialValue = 1, allocationSize = 1)
	private int id;
	
	@Column(name = "posicao")
	private int posicao;
	
	@Column(name = "pontos")
	private int pontos;
	
	@OneToOne
	@JoinColumn(name = "time_id")
	private Times time;
	
	@Column(name = "quant_jogos")
	private int quantJogos;
	
	@Column(name = "quant_vitorias")
	private int quantVitorias;
	
	@Column(name = "quant_empates")
	private int quantEmpates;
	
	@Column(name = "quant_derrotas")
	private int quantDerrotas;
	
	@Column(name = "gols_pro")
	private int golsPro;
	
	@Column(name = "gols_contra")
	private int golsContra;
	
	@Column(name = "saldo_gols")
	private int saldoGols;
	
	@Column(name = "aproveitamento")
	private double aproveitamento;
	
	@Column(name = "variacao_posicao")
	private int variacaoPosicao;
	
	@Column(name = "ultimos_jogos")
	private String ultimosJogos;
	
	
	public TabelaCampeonato() {
		
	}
	

	public int getId() {
		return id;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public Times getTime() {
		return time;
	}
	public void setTime(Times time) {
		this.time = time;
	}
	public int getQuantJogos() {
		return quantJogos;
	}
	public void setQuantJogos(int quantJogos) {
		this.quantJogos = quantJogos;
	}
	public int getQuantVitorias() {
		return quantVitorias;
	}
	public void setQuantVitorias(int quantVitorias) {
		this.quantVitorias = quantVitorias;
	}
	public int getQuantEmpates() {
		return quantEmpates;
	}
	public void setQuantEmpates(int quantEmpates) {
		this.quantEmpates = quantEmpates;
	}
	public int getQuantDerrotas() {
		return quantDerrotas;
	}
	public void setQuantDerrotas(int quantDerrotas) {
		this.quantDerrotas = quantDerrotas;
	}
	public int getGolsPro() {
		return golsPro;
	}
	public void setGolsPro(int golsPro) {
		this.golsPro = golsPro;
	}
	public int getGolsContra() {
		return golsContra;
	}
	public void setGolsContra(int golsContra) {
		this.golsContra = golsContra;
	}
	public int getSaldoGols() {
		return saldoGols;
	}
	public void setSaldoGols(int saldoGols) {
		this.saldoGols = saldoGols;
	}
	public double getAproveitamento() {
		return aproveitamento;
	}
	public void setAproveitamento(double aproveitamento) {
		this.aproveitamento = aproveitamento;
	}
	public int getVariacaoPosicao() {
		return variacaoPosicao;
	}
	public void setVariacaoPosicao(int variacaoPosicao) {
		this.variacaoPosicao = variacaoPosicao;
	}
	public String getUltimosJogos() {
		return ultimosJogos;
	}
	public void setUltimosJogos(String ultimosJogos) {
		this.ultimosJogos = ultimosJogos;
	}
	
	
}
