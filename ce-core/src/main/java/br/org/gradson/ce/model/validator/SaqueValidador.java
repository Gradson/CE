package br.org.gradson.ce.model.validator;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.org.gradson.ce.model.Saque;

@Component
public class SaqueValidador {

	public boolean validar(Saque saque) throws Exception {
		return validarValoresEntrada(saque);
	}

	private boolean validarValoresEntrada(Saque saque) throws Exception {
		if(StringUtils.isEmpty(saque.getNomeUsuario())) {
			throw new Exception("Necessário definir o usuário!");
		} else if (StringUtils.isEmpty(saque.getNomeCaixa())){
			throw new Exception("Necessário definir o caixa!");
		} else if (saque.getValor() == null || saque.getValor().compareTo(BigDecimal.ZERO) <= 0) {
			throw new Exception("Valor do saque deve ser maior que zero");
		} else if(!ehMultiploDeDez(saque.getValor())) {
			throw new Exception("Valor do Saque deve ser multiplo de 10");
		}
		
		return true;
	}

	private boolean ehMultiploDeDez(BigDecimal valor) {
		return valor.remainder(BigDecimal.TEN) == BigDecimal.ZERO;
	}
}
