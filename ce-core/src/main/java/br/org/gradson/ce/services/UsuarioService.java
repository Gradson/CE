package br.org.gradson.ce.services;

import java.math.BigDecimal;

public interface UsuarioService {

	boolean existeSaldo(String nomeUsuario, BigDecimal valor);

}
