package com.alissonrsousa.integracaofornecedores.config;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.alissonrsousa.integracaofornecedores.rotas.ProdutosRoute;
import com.alissonrsousa.integracaofornecedores.rotas.RestTokenProducerRoute;

@Configuration
public class RouteConfig extends SingleRouteCamelConfiguration {
	
	@Autowired
	public RestTokenProducerRoute serviceTokenProducerRoute;
	
	@Autowired
	private RestTokenProducerRoute tokenObj;
	
	@Autowired
	private ProdutosRoute produtosRoute;

	@Override
	public RouteBuilder route() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected CamelContext createCamelContext() throws Exception {
	    SimpleRegistry registry = new SimpleRegistry(); 
	    registry.put("tokenObj", tokenObj); //tokenObj pode ser usado em qualquer lugar no contexto camel
	    SpringCamelContext camelContext = new SpringCamelContext();
	    camelContext.setRegistry(registry); //add the registry
	    camelContext.setApplicationContext(getApplicationContext());
//	    camelContext.addRoutes(route()); //Some other route
	    camelContext.addRoutes(serviceTokenProducerRoute); //Token producer Route
	    camelContext.addRoutes(produtosRoute); //Subsequent API call route
	    camelContext.start();
	    return camelContext;
	}

}
