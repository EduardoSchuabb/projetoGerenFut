package br.com.gerenFut.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "jogadores")
public class Jogadores implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdJogadores")
	@SequenceGenerator(name="seqIdJogadores",sequenceName="jogadores_id_seq", initialValue = 1, allocationSize = 1)
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column(name = "altura")
	private double altura;
	
	@Column(name = "posicao")
	private String posicao;
	
	@Column(name = "valor_de_mercado")
	private double valorMercado;
	
	@Column(name = "nacionalidade")
	private String nacionalidade;

	@ManyToOne
	@JoinColumn(name = "time_id")
	private Times time;
	
	
	public Jogadores() {
	
		//Construtor padrao
	}
	
	
	public Jogadores(int id, String nome, Date dataNascimento, double altura, String posicao, double valorMercado,
			String nacionalidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.altura = altura;
		this.posicao = posicao;
		this.valorMercado = valorMercado;
		this.nacionalidade = nacionalidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public double getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(double valorMercado) {
		this.valorMercado = valorMercado;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Times getTime() {
		return time;
	}

	public void setTime(Times time) {
		this.time = time;
	}
	
	
	
}
