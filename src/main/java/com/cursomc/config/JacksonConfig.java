package com.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.cursomc.domain.PagamentoBoleto;
import com.cursomc.domain.PagamentoCartao;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {
// https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
// Estrutura padrão do pacote Jackson
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				//Alterar para as subclasses que serão trabalhadas
				objectMapper.registerSubtypes(PagamentoCartao.class);
				objectMapper.registerSubtypes(PagamentoBoleto.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}

