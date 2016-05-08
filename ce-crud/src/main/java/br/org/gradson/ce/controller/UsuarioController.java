package br.org.gradson.ce.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.gradson.ce.model.Usuario;
import br.org.gradson.ce.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value=ApiUrl.USUARIO, consumes=APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE, method=POST)
	public Usuario cadastrarUsuario(@Valid @RequestBody Usuario usuario) throws Exception {
		return service.cadastrar(usuario);
	}
	
	@RequestMapping(value=ApiUrl.USUARIO, consumes=APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE, method=PUT)
	public Usuario editarUsuario(@Valid @RequestBody Usuario usuario) throws Exception {
		return service.editar(usuario);
	}
	
	@RequestMapping(value=ApiUrl.USUARIO_ID, produces=APPLICATION_JSON_VALUE, method=GET)
	public Usuario buscarUsuario(@PathVariable("usuarioId") Long usuarioId) {
		return service.buscar(usuarioId);
	}
	
	@RequestMapping(value=ApiUrl.USUARIO, produces=APPLICATION_JSON_VALUE, method=GET)
	public List<Usuario> buscarTodosUsuarios() {
		return service.buscarTodos();
	}
	
	@RequestMapping(value=ApiUrl.USUARIO_CONSULTA, consumes=APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE, method=GET)
	public boolean consultarSaldo(@PathVariable("nomeUsuario") String nomeUsuario, @PathVariable("valor") BigDecimal valor) {
		return service.consultarSaldo(nomeUsuario, valor);
	}
	
	@RequestMapping(value=ApiUrl.USUARIO_ID, consumes=APPLICATION_JSON_VALUE, method=DELETE)
	public void deletarUsuario(@PathVariable("usuarioId") Long usuarioId) {
		service.deletar(usuarioId);
	}
}
