package br.org.gradson.ce.services;

import java.util.Collection;

import br.org.gradson.ce.model.Nota;

public interface NotaService {

	Nota cadastrar(Nota nota);

	Nota editar(Nota nota);

	Nota buscar(Long notaId);

	void deletar(Long notaId);

	Collection<Nota> buscarTodas();
}
