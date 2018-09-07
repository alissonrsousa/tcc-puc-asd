package com.alissonrsousa.integracaofornecedores.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PedidoProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("aaaaa");
		System.out.println(exchange.getIn().getBody());
		
	}

}
