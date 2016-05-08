package br.org.gradson.ce.services.impl;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.org.gradson.ce.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Override
	public boolean existeSaldo(String nomeUsuario, BigDecimal valor) {
		RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    String url = "http://localhost:9001/ce-crud/api/usuario/{nome}/valor/{valor}";
	    return restTemplate.exchange(url, HttpMethod.GET, entity, Boolean.class, nomeUsuario, valor).getBody();
	}

}
