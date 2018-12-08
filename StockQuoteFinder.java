package com.example.demo1;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class StockQuoteFinder {
	
	@Autowired
	private StockRepository stockRepository;
	
	@JmsListener(destination="StockQueue",containerFactory="stockFactory")
	public void receiveMessage(String symbol) {
		Stock_Details sd= new Stock_Details();
		double price = Math.random() * 1000;
		System.out.println("Price of " + symbol + ": " + price);
		sd.setCompanyName(symbol);
		sd.setStcokVlaue(price);
		stockRepository.save(sd);
	}
	
	@Bean
	  public JmsListenerContainerFactory<?> stockFactory(
	      ConnectionFactory connectionFactory,
	      DefaultJmsListenerContainerFactoryConfigurer configurer) {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

	    configurer.configure(factory, connectionFactory);
	    return factory;
	  }

}
