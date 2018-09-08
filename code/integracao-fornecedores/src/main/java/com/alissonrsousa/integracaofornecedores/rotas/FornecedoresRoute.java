package com.alissonrsousa.integracaofornecedores.rotas;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.alissonrsousa.integracaofornecedores.processor.FornecedorProcessor;

@Component
public class FornecedoresRoute extends RouteBuilder {
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	
	@Override
	public void configure() throws Exception {
		from("timer://fornecedores?period=10000").routeId("rota_fornecedores")
		.setHeader(Exchange.HTTP_METHOD, constant("GET"))
        .log("Token sendo passado ==> ${bean:tokenObj?method=getRefreshedToken}")
        .setHeader(AUTHORIZATION_HEADER, simple("Bearer " + "${bean:tokenObj?method=getRefreshedToken}"))
		.to("http://localhost:8080/produto-service/produto/fornecedores")
		.process(new FornecedorProcessor())
		.end();
	}

}
