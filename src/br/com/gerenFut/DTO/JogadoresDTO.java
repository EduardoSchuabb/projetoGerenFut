package br.com.gerenFut.DTO;

public class JogadoresDTO {

	private String nome;
	private String dataNascimento;
	private double altura;
	private String posicao;
	private double valorMercado;
	private String nacionalidade;
	private int idTime;
	
	
	public JogadoresDTO() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
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
	public int getIdTime() {
		return idTime;
	}
	public void setIdTime(int idTime) {
		this.idTime = idTime;
	}
	
	
}
