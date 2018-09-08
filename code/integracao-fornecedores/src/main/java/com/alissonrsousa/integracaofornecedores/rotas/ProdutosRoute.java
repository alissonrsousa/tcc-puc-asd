package com.alissonrsousa.integracaofornecedores.rotas;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.alissonrsousa.integracaofornecedores.processor.ProdutoProcessor;

@Component
public class ProdutosRoute extends RouteBuilder {
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	
	@Override
	public void configure() throws Exception {
		from("timer://produtos?period=10000").routeId("produtos")
		.log("Recuperando Fornecedores")
		.setHeader(Exchange.HTTP_METHOD, constant("GET"))
        .log("Token sendo passado ==> ${bean:tokenObj?method=getRefreshedToken}")
        .setHeader(AUTHORIZATION_HEADER, simple("Bearer " + "${bean:tokenObj?method=getRefreshedToken}"))
		.to("http://localhost:8080/produto-service/produto/fornecedores")
		.process(new ProdutoProcessor())
		.end();
	}

}
