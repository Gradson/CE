package br.org.gradson.ce.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.gradson.ce.model.CaixaEletronico;
import br.org.gradson.ce.model.Nota;
import br.org.gradson.ce.model.Saque;
import br.org.gradson.ce.services.CaixaEletronicoService;

@RestController
public class CaixaEletronicoController {
	
	@Autowired
	private CaixaEletronicoService service;

	@RequestMapping(value=ApiUrl.CAIXAELETRONICO, consumes=APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE, method=POST)
	public CaixaEletronico cadastrarCaixaEletronico(@Valid @RequestBody CaixaEletronico caixaEletronico) throws Exception {
		return service.cadastrar(caixaEletronico);
	}
	
	@RequestMapping(value=ApiUrl.CAIXAELETRONICO_ID, produces=APPLICATION_JSON_VALUE, method=GET)
	public CaixaEletronico buscarCaixaEletronico(@PathVariable("caixaEletronicoId") Long caixaEletronicoId) {
		return service.buscar(caixaEletronicoId);
	}
	
	@RequestMapping(value=ApiUrl.CAIXAELETRONICO, produces=APPLICATION_JSON_VALUE, method=GET)
	public List<CaixaEletronico> buscarTodosCaixaEletronico() {
		return service.buscarTodos();
	}
	
	@RequestMapping(value=ApiUrl.CAIXAELETRONICO, consumes=APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE, method=PUT)
	public @ResponseBody List<Nota> sacar(@RequestBody Saque saque) throws Exception {
		return service.sacar(saque);
	}
	
	@RequestMapping(value=ApiUrl.CAIXAELETRONICO_ID, consumes=APPLICATION_JSON_VALUE, method=DELETE)
	public void deletarCaixaEletronico(@PathVariable("caixaEletronicoId") Long caixaEletronicoId) {
		service.deletar(caixaEletronicoId);
	}
}
