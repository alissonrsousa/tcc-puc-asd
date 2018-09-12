package com.alissonrsousa.integracaofornecedores.processor;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.BeanUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.alissonrsousa.integracaofornecedores.model.Fornecedor;
import com.alissonrsousa.integracaofornecedores.model.OauthToken;
import com.alissonrsousa.integracaofornecedores.model.Produto;
import com.alissonrsousa.integracaofornecedores.model.ProdutoFornecedor;
import com.alissonrsousa.integracaofornecedores.rotas.RestTokenProducerRoute;

public class FornecedorProcessor implements Processor {

	private Fornecedor fornecedor;
	
	private OauthToken tokenFornecedor;
	
	private String urlApiGatewayLoja;
	
	public FornecedorProcessor(String urlApiGateway) {
		this.urlApiGatewayLoja = urlApiGateway;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		fornecedor = (Fornecedor) exchange.getIn().getBody();
		tokenFornecedor = realizarAutenticacao();
		List<Produto> produtos = buscarProdutos();
		atualizarProdutosLoja(produtos);
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
		headers.add("Authorization", "Bearer " + tokenFornecedor.getAccess_token());
		HttpEntity<String> request = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		String param = fornecedor.getIdsProdutosFornecedor().toString().replace("[","").replace("]","").replaceAll(" ", "");
		ResponseEntity<List<Produto>> response = restTemplate.exchange(fornecedor.getUrlIntegracao() + "/produtos/idsIn/" + param, HttpMethod.GET, request, new ParameterizedTypeReference<List<Produto>>(){});
		return response.getBody();
	}
	
	private void atualizarProdutosLoja(List<Produto> produtos) {
		List<ProdutoFornecedor> produtosFornecedor = new ArrayList<>();
		for (Produto p: produtos) {
			ProdutoFornecedor pf = new ProdutoFornecedor();
			pf.setIdFornecedor(fornecedor.getId());
			BeanUtils.copyProperties(p, pf);
			pf.setIdProdutoFornecedor(p.getId());
			pf.setPreco(p.getValorUnitario());
			pf.setValorFrete(p.getValorFrete());
			produtosFornecedor.add(pf);
		}
		
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", "Bearer " + RestTokenProducerRoute.getRefreshedToken());
        requestHeaders.add("Content-Type", MediaType.APPLICATION_JSON.toString());
        HttpEntity<List<ProdutoFornecedor>> request = new HttpEntity<List<ProdutoFornecedor>>(produtosFornecedor, requestHeaders);

        Boolean responseEntity = restTemplate.postForObject(urlApiGatewayLoja + "/produto-service/produto/fornecedores/produtos", request, Boolean.class);
        System.out.println(responseEntity);
	}

}
