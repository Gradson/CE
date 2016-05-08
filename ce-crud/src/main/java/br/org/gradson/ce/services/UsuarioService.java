package br.org.gradson.ce.services;

import java.math.BigDecimal;
import java.util.List;

import br.org.gradson.ce.model.Usuario;

public interface UsuarioService {

	Usuario cadastrar(Usuario usuario) throws Exception;

	Usuario buscar(Long usuarioId);

	void deletar(Long usuarioId);

	List<Usuario> buscarTodos();

	boolean consultarSaldo(String nomeUsuario, BigDecimal valor);

	void atualizarSaldo(String nomeUsuario, BigDecimal valorSacado);

	Usuario editar(Usuario usuario);
}
