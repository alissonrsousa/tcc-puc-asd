package com.alissonrsousa.integracaofornecedores.rotas;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import com.alissonrsousa.integracaofornecedores.processor.FornecedorProcessor;

@Component
public class ProcessarFornecedorRoute extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		from("direct:processa_fornecedor").routeId("processa_fornecedor")
		.log("Processando fornecedor")
		.process(new FornecedorProcessor())
		.end();
	}

}
