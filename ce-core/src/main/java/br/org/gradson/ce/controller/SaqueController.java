package br.org.gradson.ce.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.gradson.ce.model.Nota;
import br.org.gradson.ce.model.Saque;
import br.org.gradson.ce.services.SaqueService;

@RestController
public class SaqueController {
	
	@Autowired
	private SaqueService service;

	@RequestMapping(value=ApiUrl.SAQUE, consumes=APPLICATION_JSON_VALUE, produces=APPLICATION_JSON_VALUE, method=POST)
	public @ResponseBody List<Nota> realizarSaque(@Valid @RequestBody Saque saque) throws Exception {
		return service.realizarSaque(saque);
	}
}
