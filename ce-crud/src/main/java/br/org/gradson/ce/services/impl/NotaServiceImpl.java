package br.org.gradson.ce.services.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.gradson.ce.model.Nota;
import br.org.gradson.ce.repository.NotaRepository;
import br.org.gradson.ce.services.NotaService;

@Service
public class NotaServiceImpl implements NotaService {
	
	@Autowired
	private NotaRepository notaRepository;

	@Override
	public Nota cadastrar(Nota nota) {
		return notaRepository.save(nota);
	}

	@Override
	public Nota editar(Nota nota) {
		return notaRepository.save(nota);
	}

	@Override
	public Nota buscar(Long notaId) {
		return notaRepository.findOne(notaId);
	}
	
	@Override
	public Collection<Nota> buscarTodas() {
		return (Collection<Nota>) notaRepository.findAll();
	}

	@Override
	public void deletar(Long notaId) {
		notaRepository.delete(notaId);
	}

}
