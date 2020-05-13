package br.ibm.com.treinamento.demo.configuration.service;

import org.springframework.stereotype.Component;

@Component
public interface GreetingService {
	
	String sayHello(String name);

}
