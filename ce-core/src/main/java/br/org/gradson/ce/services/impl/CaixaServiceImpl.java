package br.org.gradson.ce.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.org.gradson.ce.model.Nota;
import br.org.gradson.ce.model.Saque;
import br.org.gradson.ce.services.CaixaService;

@Service
public class CaixaServiceImpl implements CaixaService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Nota> sacar(Saque saque) {
		RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> entity = new HttpEntity<String>(convertToJson(saque), headers);
	    
		String url = "http://localhost:9001/ce-crud/api/caixa-eletronico";
		return restTemplate.exchange(url, HttpMethod.PUT, entity, List.class).getBody();
	}

	private String convertToJson(Saque saque)  {
		try {
			return new ObjectMapper().writeValueAsString(saque);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
