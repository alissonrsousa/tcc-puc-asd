package com.alissonrsousa.integracaofornecedores.rotas;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alissonrsousa.integracaofornecedores.model.OauthToken;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RestTokenProducerRoute extends RouteBuilder {

	@Value( "${lojaVirtual.security.oauth2.url}")
	private String lojaVirtualOauthUrl;
	
	@Value( "${lojaVirtual.security.oauth2.authorizationHeader}")
	private String lojaVirtualOauthAuthorizationHeader;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	
    private static String refreshedToken; 

    @Override
    public void configure() throws Exception {

        from("timer://test?period=1200000") //Chamado a cada 20 min
		.log("Realizando Autenticação Serviço Loja")
		.setHeader(Exchange.HTTP_METHOD, constant("POST"))
		.setHeader(AUTHORIZATION_HEADER, constant(lojaVirtualOauthAuthorizationHeader))
		.to(lojaVirtualOauthUrl)
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				String tokenString = exchange.getIn().getBody(String.class);
				OauthToken token = mapper.readValue(tokenString, OauthToken.class);
				setRefreshedToken(token.getAccess_token());
			}
		})
		.log("${body}");
        }

        public static String getRefreshedToken() {
            return RestTokenProducerRoute.refreshedToken;
        }

        private void setRefreshedToken(String refreshedToken) {
        	RestTokenProducerRoute.refreshedToken = refreshedToken;
        }
}