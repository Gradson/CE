package br.org.gradson.ce.model.validator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.org.gradson.ce.model.Saque;

public class SaqueValidadorTest {
	
	@InjectMocks
	private SaqueValidador validador;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected=Exception.class)
	public void deveValidarSeContemNomeDoUsuarioValorECaixaERetornarException() throws Exception {
		Saque saque = getSaque();
		validador.validar(saque);
	}

	@Test
	public void deveValidarSeContemNomeDoUsuarioValorECaixaERetornarTrue() throws Exception {
		Saque saque = getSaque();
		saque.setNomeUsuario("usuario");
		boolean valido = validador.validar(saque);
		
		assertTrue(valido);
	}

	private Saque getSaque() {
		Saque saque = new Saque();
		saque.setNomeCaixa("caixa");
		saque.setValor(new BigDecimal(100));
		return saque;
	}
}
