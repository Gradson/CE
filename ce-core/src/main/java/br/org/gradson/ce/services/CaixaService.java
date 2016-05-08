package br.org.gradson.ce.services;

import java.util.List;

import br.org.gradson.ce.model.Nota;
import br.org.gradson.ce.model.Saque;

public interface CaixaService {

	List<Nota> sacar(Saque saque);

}
