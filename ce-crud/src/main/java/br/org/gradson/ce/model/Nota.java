package br.org.gradson.ce.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Nota extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal nota;
	private Integer quantidade;
	
	public BigDecimal getNota() {
		return nota;
	}
	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
