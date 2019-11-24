package com.edugroup.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.Module;

@Configuration
public class JsonConfiguration {
	
	
	@Bean
	public Module jtsModule() {
		return new JtsModule();
	}
		

}
