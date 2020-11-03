package br.com.gerenFut.DTO;

import java.util.List;

public class RequisicaoTabelaDTO {

	private String posicao;
	private String pontos;
	private TimeTabelaRequisicaoDTO time;
	private String jogos;
	private String vitorias;
	private String empates;
	private String derrotas;
	private String gols_pro;
	private String gols_contra;
	private String saldo_gols;
	private String aproveitamento;
	private String variacao_posicao;
	private List<String> ultimos_jogos;
	
	
	public RequisicaoTabelaDTO() {
		
	}

	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public String getPontos() {
		return pontos;
	}
	public void setPontos(String pontos) {
		this.pontos = pontos;
	}
	public TimeTabelaRequisicaoDTO getTime() {
		return time;
	}
	public void setTime(TimeTabelaRequisicaoDTO time) {
		this.time = time;
	}
	public String getJogos() {
		return jogos;
	}
	public void setJogos(String jogos) {
		this.jogos = jogos;
	}
	public String getVitorias() {
		return vitorias;
	}
	public void setVitorias(String vitorias) {
		this.vitorias = vitorias;
	}
	public String getEmpates() {
		return empates;
	}
	public void setEmpates(String empates) {
		this.empates = empates;
	}
	public String getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(String derrotas) {
		this.derrotas = derrotas;
	}
	public String getGols_pro() {
		return gols_pro;
	}
	public void setGols_pro(String gols_pro) {
		this.gols_pro = gols_pro;
	}
	public String getGols_contra() {
		return gols_contra;
	}
	public void setGols_contra(String gols_contra) {
		this.gols_contra = gols_contra;
	}
	public String getSaldo_gols() {
		return saldo_gols;
	}
	public void setSaldo_gols(String saldo_gols) {
		this.saldo_gols = saldo_gols;
	}
	public String getAproveitamento() {
		return aproveitamento;
	}
	public void setAproveitamento(String aproveitamento) {
		this.aproveitamento = aproveitamento;
	}
	public String getVariacao_posicao() {
		return variacao_posicao;
	}
	public void setVariacao_posicao(String variacao_posicao) {
		this.variacao_posicao = variacao_posicao;
	}
	public List<String> getUltimos_jogos() {
		return ultimos_jogos;
	}
	public void setUltimos_jogos(List<String> ultimos_jogos) {
		this.ultimos_jogos = ultimos_jogos;
	}

	@Override
	public String toString() {
		return "RequisicaoTabelaDTO [posicao=" + posicao + ", pontos=" + pontos + ", time=" + time.toString() + ", jogos=" + jogos
				+ ", vitorias=" + vitorias + ", empates=" + empates + ", derrotas=" + derrotas + ", gols_pro="
				+ gols_pro + ", gols_contra=" + gols_contra + ", saldo_gols=" + saldo_gols + ", aproveitamento="
				+ aproveitamento + ", variacao_posicao=" + variacao_posicao + ", ultimos_jogos=" + ultimos_jogos + "]";
	}
	
	
	// Verificar se esse metodo funciona
	public String retornarUltimosJogosString() {
		
		String delim = "-";
        String resp = String.join(delim, this.ultimos_jogos);
        return resp;
	}
	
	
}
