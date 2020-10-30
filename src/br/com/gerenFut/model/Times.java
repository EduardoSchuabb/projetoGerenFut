package br.com.gerenFut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name = "times")
public class Times implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdTimes")
	@SequenceGenerator(name="seqIdTimes",sequenceName="times_id_seq", initialValue = 1, allocationSize = 1)
	private int id;
	
	@Column(name = "nome_time")
	private String nome;
	
	@Column(name = "estado")
	private String estado;

	@Column(name = "qtd_jogadores")
	private int qtdJogadores;
	
	
	public Times() {
	  
	  // Construtor padrao
	}
	 
	public Times(String nome, String estado, int qtdJogadores) {
		super();
		
		this.nome = nome;
		this.estado = estado;
		this.qtdJogadores = qtdJogadores;
	}
	
	
	

	public int getId() {
		return id;
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
