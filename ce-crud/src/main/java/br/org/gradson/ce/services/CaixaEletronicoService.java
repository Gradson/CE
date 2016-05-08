package br.org.gradson.ce.services;

import java.util.List;

import br.org.gradson.ce.model.CaixaEletronico;
import br.org.gradson.ce.model.Nota;
import br.org.gradson.ce.model.Saque;

public interface CaixaEletronicoService {

	CaixaEletronico cadastrar(CaixaEletronico caixaEletronico) throws Exception;

	CaixaEletronico editar(CaixaEletronico caixaEletronico);

	CaixaEletronico buscar(Long caixaEletronicoId);

	void deletar(Long caixaEletronicoId);

	List<CaixaEletronico> buscarTodos();

	List<Nota> sacar(Saque saque) throws Exception;

}
