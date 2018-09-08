package com.alissonrsousa.integracaofornecedores.processor;

import java.util.Base64;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alissonrsousa.integracaofornecedores.model.Fornecedor;
import com.alissonrsousa.integracaofornecedores.model.OauthToken;
import com.alissonrsousa.integracaofornecedores.model.Produto;

public class FornecedorProcessor implements Processor {

	private Fornecedor fornecedor;
	private OauthToken token;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		fornecedor = (Fornecedor) exchange.getIn().getBody();
		token = realizarAutenticacao();
		List<Produto> produtos = buscarProdutos();
	}

	private OauthToken realizarAutenticacao() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString((fornecedor.getUsuarioIntegracao() + ":" + fornecedor.getSenhaIntegracao()).getBytes()));
		HttpEntity<String> request = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<OauthToken> response = restTemplate.exchange(fornecedor.getUrlOauthIntegracao(), HttpMethod.POST, request, OauthToken.class);
		return response.getBody();
	}
	
	private List<Produto> buscarProdutos() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token.getAccess_token());
		HttpEntity<String> request = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Produto>> response = restTemplate.exchange(fornecedor.getUrlIntegracao() + "/produtos", HttpMethod.GET, request, new ParameterizedTypeReference<List<Produto>>(){});
		return response.getBody();
	}

}
