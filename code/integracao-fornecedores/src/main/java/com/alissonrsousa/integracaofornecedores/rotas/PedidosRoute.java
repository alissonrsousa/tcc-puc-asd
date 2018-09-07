package com.alissonrsousa.integracaofornecedores.rotas;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.alissonrsousa.integracaofornecedores.processor.ProdutoProcessor;

@Component
public class PedidosRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
        
		from("timer://pedidos?period=5000").routeId("pedidos")
		.log("Rota pedidos")
		.process(new ProdutoProcessor())
		.end();
//        .transform().method("myBean", "saySomething")
//        .filter(simple("${body} contains 'foo'"))
//            .to("log:foo")
//        .end()
//        .to("stream:out");
		
	}

}
