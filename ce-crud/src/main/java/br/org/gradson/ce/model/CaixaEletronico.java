package br.org.gradson.ce.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class CaixaEletronico extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Nome do caixa eletrônico não pode ser vazio!")
	@Column(unique = true, nullable = false)
	private String nome;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Nota> notas;
	
	@NotNull(message = "Saldo não pode ser vazio!")
	@Min(value = 0, message = "Saldo deve ser no mínio de 0,00 reais")
	private BigDecimal saldo;

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Nota> getNotas() {
		ordenaNotas();
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public void atualizaSaldo() {
		BigDecimal saldoAtualizado = BigDecimal.ZERO;
		for (Nota nota : notas) {
			saldoAtualizado = saldoAtualizado.add(nota.getNota().multiply(new BigDecimal(nota.getQuantidade()))); 
		}
		this.saldo = saldoAtualizado;
	}
	
	
	private void ordenaNotas() {
		Collections.sort(this.notas,new Comparator<Nota>() {

			@Override
			public int compare(Nota o1, Nota o2) {
				return o2.getNota().compareTo(o1.getNota());
			}
		});
	}
}
