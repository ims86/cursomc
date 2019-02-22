package com.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursomc.services.DBService;

@Configuration
@Profile("dev")
public class ConfigDev {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String opcBaseConfig;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		if(!"create".equals(opcBaseConfig)) {
			return false;
		}
		dbService.instantiateH2Database();
		return true;
	}

}
