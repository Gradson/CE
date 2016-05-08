package br.org.gradson.ce.model;

public enum TipoNotaEnum {
 CEM(100, 0), CINQUENTA(50,1), VINTE(20,2), DEZ(10,3), ZERO(0,4);
	
	final Integer valor;
	final Integer posicao;

	private TipoNotaEnum(Integer valor, Integer posicao) {
		this.valor = valor;
		this.posicao = posicao;
	}
	
	public Integer getValor() {
		return this.valor;
	}
	
	public Integer getPosicao() {
		return this.posicao;
	}
}
