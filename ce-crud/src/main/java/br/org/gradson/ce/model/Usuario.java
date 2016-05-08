package br.org.gradson.ce.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Nome não pode ser vazio!")
	@Column(unique = true, nullable = false)
	private String nome;
	
	@NotNull(message = "O Saldo mínimo deve ser de R$0,00")
	private BigDecimal saldo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
