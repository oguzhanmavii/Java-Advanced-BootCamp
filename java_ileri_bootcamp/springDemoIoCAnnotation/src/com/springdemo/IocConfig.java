package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.springdemo")
@PropertySource("classpath:values.properties")
public class IocConfig {
	@Bean
	ICustomerDal database() {
		return new MsSqlCustomerDal();
	}
	
	@Bean
	ICustomerService service() {
		return new CustomerManager(database());
	}
}
