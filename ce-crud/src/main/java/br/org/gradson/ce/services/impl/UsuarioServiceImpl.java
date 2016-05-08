package br.org.gradson.ce.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.gradson.ce.model.Usuario;
import br.org.gradson.ce.repository.UsuarioRepository;
import br.org.gradson.ce.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario cadastrar(Usuario usuario) throws Exception {
		if(usuario.getId() != null) {
			return editar(usuario);
		}
		
		Usuario usuarioCadastrado = usuarioRepository.findByNome(usuario.getNome());
		if(usuarioCadastrado != null) {
			throw new Exception("Cadastro não efetuado! Usuario ja cadastrado");
		}
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario editar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscar(Long usuarioId) {
		return usuarioRepository.findOne(usuarioId);
	}

	@Override
	public void deletar(Long usuarioId) {
		usuarioRepository.delete(usuarioId);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public boolean consultarSaldo(String nomeUsuario, BigDecimal valor) {
		Usuario usuario = usuarioRepository.findByNome(nomeUsuario);
		return usuario.getSaldo().compareTo(valor) >= 0;
	}
	
	@Override
	public void atualizarSaldo(String nomeUsuario, BigDecimal valorSacado) {
		Usuario usuario = usuarioRepository.findByNome(nomeUsuario);
		usuario.setSaldo(usuario.getSaldo().subtract(valorSacado));
		editar(usuario);
	}

}
