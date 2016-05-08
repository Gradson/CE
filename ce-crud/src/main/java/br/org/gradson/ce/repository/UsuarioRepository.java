package br.org.gradson.ce.repository;

import org.springframework.data.repository.CrudRepository;

import br.org.gradson.ce.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Usuario findByNome(String nomeUsuario);

}
