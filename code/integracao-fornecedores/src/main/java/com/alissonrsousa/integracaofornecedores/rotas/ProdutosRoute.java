package com.alissonrsousa.integracaofornecedores.rotas;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alissonrsousa.integracaofornecedores.processor.ProdutoProcessor;

@Component
public class ProdutosRoute extends RouteBuilder {
	
	@Value( "${lojaVirtual.security.oauth2.hostname}" )
	private String lojaVirtualOauthUrl;
	
	@Value( "${lojaVirtual.security.oauth2.clientId}" )
	private String lojaVirtualOauthClientId;
	
	@Value( "${lojaVirtual.security.oauth2.clientSecret}" )
	private String lojaVirtualOauthClientSecret;

	@Override
	public void configure() throws Exception {
        
		from("timer://produtos?period=5000").routeId("produtos")
		.log("Rota produtos")
		.process(new ProdutoProcessor())
		.end();
//        .transform().method("myBean", "saySomething")
//        .filter(simple("${body} contains 'foo'"))
//            .to("log:foo")
//        .end()
//        .to("stream:out");
		
	}

}
