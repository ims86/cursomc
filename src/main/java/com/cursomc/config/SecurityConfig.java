package com.cursomc.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	//Cria vetor com urls permitidas
	private static final String[] PUBLIC_MATCHERS = { 
			"/h2-console/**"
	};
	
	private static final String[] PUBLIC_MATCHERS_GET = { 			
			"/produtos/**", 
			"/categorias/**" 
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		if(Arrays.asList(env.getActiveProfiles()).contains("h2")) { //Varre os profiles e verifica se é H2
			http.headers().frameOptions().disable(); //Comando para dar permissão no H2
		}
		
		http.cors().and().csrf().disable();
		http.authorizeRequests()
				.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll() //Permite os caminhos do vetor somente leitura
				.antMatchers(PUBLIC_MATCHERS).permitAll() //Permite os caminhos do vetor
				.anyRequest().authenticated(); //Exige autencitação no resto
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //Não cria sessão usuario
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

}
