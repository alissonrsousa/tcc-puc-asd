package com.alissonrsousa.integracaofornecedores.rotas;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alissonrsousa.integracaofornecedores.model.Fornecedor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FornecedoresRoute extends RouteBuilder {
	
	@Value( "${lojaVirtual.api-gateway.url}")
	private String urlApiGateway;
	
	private static final String URL_SERVICO_LISTA_FORNECEDORES = "/produto-service/produto/fornecedores";
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	
	@Override
	public void configure() throws Exception {
		from("timer://fornecedores?period=60000&delay=5000").routeId("rota_fornecedores")
		.setHeader(Exchange.HTTP_METHOD, constant("GET"))
        .log("Token sendo passado ==> ${bean:tokenObj?method=getRefreshedToken}")
        .setHeader(AUTHORIZATION_HEADER, simple("Bearer " + "${bean:tokenObj?method=getRefreshedToken}"))
		.to(urlApiGateway + URL_SERVICO_LISTA_FORNECEDORES)
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				String dadosString = exchange.getIn().getBody(String.class);
				ObjectMapper mapper = new ObjectMapper();
				List<Fornecedor> lista = mapper.readValue(dadosString, new TypeReference<List<Fornecedor>>(){});
				exchange.getIn().setBody(lista, List.class);
			}
		})
		.split(body())
		.to("direct:processa_fornecedor")
		.end();
	}

}
