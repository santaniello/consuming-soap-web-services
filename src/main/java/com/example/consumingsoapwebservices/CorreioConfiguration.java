package com.example.consumingsoapwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CorreioConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("correio.wsdl");
		return marshaller;
	}

	@Bean
	public CorreioClient correioClient(Jaxb2Marshaller marshaller) {
		CorreioClient client = new CorreioClient();
		client.setDefaultUri("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}