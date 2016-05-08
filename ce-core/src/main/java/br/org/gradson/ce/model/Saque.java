package br.org.gradson.ce.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class Saque extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@NotNull
	private String nomeUsuario;
	@NotNull
	private String nomeCaixa;
	@NotNull
	private BigDecimal valor;
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeCaixa() {
		return nomeCaixa;
	}
	public void setNomeCaixa(String nomeCaixa) {
		this.nomeCaixa = nomeCaixa;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
