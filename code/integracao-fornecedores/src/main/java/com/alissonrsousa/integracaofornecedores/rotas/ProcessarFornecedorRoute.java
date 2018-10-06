package com.alissonrsousa.integracaofornecedores.rotas;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.alissonrsousa.integracaofornecedores.processor.FornecedorProcessor;

@Component
public class ProcessarFornecedorRoute extends RouteBuilder {
	
	@Value( "${lojaVirtual.api-gateway.url}")
	private String urlApiGateway;
	
	@Override
	public void configure() throws Exception {
		
		from("direct:processa_fornecedor").routeId("processa_fornecedor")
		.log(">>>>>>>Iniciando Processamento fornecedor: ${body.nomeFantasia}")
		.process(new FornecedorProcessor(urlApiGateway))
		.log("<<<<<<<Finalizado Processamento fornecedor: ${body.nomeFantasia}")
		.end();
	}

}
