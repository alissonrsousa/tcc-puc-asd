package com.alissonrsousa.integracaofornecedores.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.alissonrsousa.integracaofornecedores.model.OauthToken;
import com.alissonrsousa.integracaofornecedores.rotas.ProdutosRoute;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OauthProcessor implements Processor {

	private ObjectMapper mapper = new ObjectMapper();
	@Override
	public void process(Exchange exchange) throws Exception {
		String tokenString = exchange.getIn().getBody(String.class);
		OauthToken token = mapper.readValue(tokenString, OauthToken.class);
//		ProdutosRoute.token_loja_virtual = token;
	}

}
