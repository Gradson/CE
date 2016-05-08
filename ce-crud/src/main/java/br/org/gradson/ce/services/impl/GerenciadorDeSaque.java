package br.org.gradson.ce.services.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.org.gradson.ce.model.Nota;
import br.org.gradson.ce.model.TipoNotaEnum;

@Service
public class GerenciadorDeSaque {
	
	private static TipoNotaEnum tipoNota;
	private static BigDecimal valor;

	public List<Nota> sacar(BigDecimal valor, Collection<Nota> notas) {
		GerenciadorDeSaque.valor = valor;
		GerenciadorDeSaque.tipoNota = TipoNotaEnum.CEM;
		Map<Integer, Nota> mapNotas = recuperarNotas(notas);
		BigDecimal valorSacado = BigDecimal.ZERO;
		List<Nota> notasSacadas = inicializarNotas();

		while (valorSacado.compareTo(valor) < 0) {
			switch (tipoNota.getValor()) {
			case 100:
				valorSacado = recuperarNotas(mapNotas, valorSacado, notasSacadas, TipoNotaEnum.CINQUENTA);
				break;
			case 50:
				valorSacado = recuperarNotas(mapNotas, valorSacado, notasSacadas, TipoNotaEnum.VINTE);
				break;
			case 20:
				valorSacado = recuperarNotas(mapNotas, valorSacado, notasSacadas, TipoNotaEnum.DEZ);
				break;
			case 10:
				valorSacado = recuperarNotas(mapNotas, valorSacado, notasSacadas, TipoNotaEnum.ZERO);
				break;
			default:
				return notasSacadas;
			}
		}
		
		return notasSacadas;
	}

	private List<Nota> inicializarNotas() {
		return Arrays.asList(getNota(100), getNota(50), getNota(20), getNota(10));
	}

	private BigDecimal recuperarNotas(Map<Integer, Nota> mapNotas, BigDecimal valorSacado, List<Nota> notasSacadas, TipoNotaEnum proximoTipo) {
		Nota nota = mapNotas.get(tipoNota.getValor());
		if (validarNota(nota) && valorSacado.add(nota.getNota()).compareTo(valor)<=0) {
			valorSacado = valorSacado.add(nota.getNota());
			nota.setQuantidade(nota.getQuantidade() - 1);
			
			Nota notaSacada = notasSacadas.get(tipoNota.getPosicao());
			notaSacada.setQuantidade(notaSacada.getQuantidade() + 1);
			
		} else {
			tipoNota = proximoTipo;
		}
		return valorSacado;
	}

	private boolean validarNota(Nota nota) {
		return nota != null && nota.getQuantidade() > 0;
	}

	private Map<Integer, Nota> recuperarNotas(Collection<Nota> notas) {
		Map<Integer, Nota> mapNotas = new HashMap<>();
		for (Nota nota : notas) {
			mapNotas.put(nota.getNota().intValue(), nota);
		}
		
		return mapNotas;
	}
	
	private Nota getNota(Integer valor) {
		Nota nota = new Nota();
		nota.setNota(new BigDecimal(valor));
		nota.setQuantidade(0);
		
		return nota;
	}
}
