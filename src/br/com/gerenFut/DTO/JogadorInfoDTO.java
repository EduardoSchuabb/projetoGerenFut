package br.com.gerenFut.DTO;

public class JogadorInfoDTO {

	private String nome;
	private String dataNascimento;
	private double altura;
	private String posicao;
	private double valorMercado;
	private String nacionalidade;
	
	public JogadorInfoDTO() {
		
	}
	
	public JogadorInfoDTO(String nome, String dataNascimento, double altura, String posicao, double valorMercado,
			String nacionalidade) {
		
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.altura = altura;
		this.posicao = posicao;
		this.valorMercado = valorMercado;
		this.nacionalidade = nacionalidade;
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
	
	
}
