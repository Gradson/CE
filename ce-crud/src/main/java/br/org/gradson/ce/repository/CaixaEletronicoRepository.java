package br.org.gradson.ce.repository;

import org.springframework.data.repository.CrudRepository;

import br.org.gradson.ce.model.CaixaEletronico;

public interface CaixaEletronicoRepository extends CrudRepository<CaixaEletronico, Long>{

	CaixaEletronico findByNome(String nomeCaixa);

}
