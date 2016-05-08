package br.org.gradson.ce.services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.org.gradson.ce.model.Nota;
import br.org.gradson.ce.services.impl.GerenciadorDeSaque;

public class GerenciadorDeSaqueTest {

	@InjectMocks
	private GerenciadorDeSaque service;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deveSacarRetornandoUmaNotaDeCemEUmaDeDez() throws Exception {
		List<Nota> notas = service.sacar(new BigDecimal(110), getNotas());
		
		assertEquals(1, notas.get(0).getQuantidade(), 0.001);
		assertEquals(0, notas.get(1).getQuantidade(), 0.001);
		assertEquals(0, notas.get(2).getQuantidade(), 0.001);
		assertEquals(1, notas.get(3).getQuantidade(), 0.001);
	}

	private Collection<Nota> getNotas() {
		return Arrays.asList(getNota(100, 2), getNota(10, 1));
	}

	private Nota getNota(Integer valor, int quantidade) {
		Nota nota = new Nota();
		nota.setNota(new BigDecimal(valor));
		nota.setQuantidade(quantidade);
		
		return nota;
	}
}
