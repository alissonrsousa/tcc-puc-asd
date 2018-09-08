package com.alissonrsousa.integracaofornecedores.processor;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.alissonrsousa.integracaofornecedores.model.Fornecedor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FornecedorProcessor implements Processor {

	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void process(Exchange exchange) throws Exception {
		String dadosString = exchange.getIn().getBody(String.class);
		List<Fornecedor> lista = mapper.readValue(dadosString, new TypeReference<List<Fornecedor>>(){});

		
		System.out.println("aaaaa");
		System.out.println(exchange.getIn().getBody());
	}

}
