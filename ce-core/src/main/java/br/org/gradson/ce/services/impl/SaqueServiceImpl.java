package br.org.gradson.ce.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.gradson.ce.model.Nota;
import br.org.gradson.ce.model.Saque;
import br.org.gradson.ce.model.validator.SaqueValidador;
import br.org.gradson.ce.services.CaixaService;
import br.org.gradson.ce.services.SaqueService;
import br.org.gradson.ce.services.UsuarioService;

@Service
public class SaqueServiceImpl implements SaqueService {
	
	@Autowired
	private SaqueValidador saqueValidador;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CaixaService caixaService;

	@Override
	public List<Nota> realizarSaque(Saque saque) throws Exception {
		saqueValidador.validar(saque);
		if(usuarioService.existeSaldo(saque.getNomeUsuario(), saque.getValor())) {
			return caixaService.sacar(saque);
		}
		
		throw new Exception("Saldo do usuário menor que o valor a ser sacado!");
	}
}
