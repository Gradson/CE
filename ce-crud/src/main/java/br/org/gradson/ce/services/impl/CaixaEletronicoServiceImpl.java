package br.org.gradson.ce.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.gradson.ce.model.CaixaEletronico;
import br.org.gradson.ce.model.Nota;
import br.org.gradson.ce.model.Saque;
import br.org.gradson.ce.repository.CaixaEletronicoRepository;
import br.org.gradson.ce.services.CaixaEletronicoService;
import br.org.gradson.ce.services.UsuarioService;

@Service
public class CaixaEletronicoServiceImpl implements CaixaEletronicoService{
	
	@Autowired
	private CaixaEletronicoRepository caixaEletronicoRepository;
	@Autowired
	private GerenciadorDeSaque gerenciadorDeSaque;
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public CaixaEletronico cadastrar(CaixaEletronico caixaEletronico) throws Exception {
		if(caixaEletronico.getId() != null) {
			return editar(caixaEletronico);
		}
		
		CaixaEletronico caixa = caixaEletronicoRepository.findByNome(caixaEletronico.getNome());
		if(caixa != null) {
			throw new Exception("Caixa já existente com esse nome!");
		}
		
		return caixaEletronicoRepository.save(caixaEletronico);
	}
	
	@Override
	public CaixaEletronico editar(CaixaEletronico caixaEletronico) {
		return caixaEletronicoRepository.save(caixaEletronico);
	}
	
	@Override
	public CaixaEletronico buscar(Long caixaEletronicoId) {
		return caixaEletronicoRepository.findOne(caixaEletronicoId);
	}
	
	@Override
	public void deletar(Long caixaEletronicoId) {
		caixaEletronicoRepository.delete(caixaEletronicoId);
	}

	@Override
	public List<CaixaEletronico> buscarTodos() {
		return (List<CaixaEletronico>) caixaEletronicoRepository.findAll();
	}

	@Override
	public List<Nota> sacar(Saque saque) throws Exception {
		CaixaEletronico caixa = caixaEletronicoRepository.findByNome(saque.getNomeCaixa());
		if(caixa.getSaldo().compareTo(saque.getValor()) >= 0) {
			List<Nota> notasSacadas = gerenciadorDeSaque.sacar(saque.getValor(), caixa.getNotas());
			
			atualizarCaixa(caixa);
			usuarioService.atualizarSaldo(saque.getNomeUsuario(), saque.getValor());
			
			return notasSacadas;
		}
		
		throw new Exception("Caixa com valor indisponível!");
	}

	private void atualizarCaixa(CaixaEletronico caixa) {
		caixa.atualizaSaldo();
		caixaEletronicoRepository.save(caixa);
	}
}
