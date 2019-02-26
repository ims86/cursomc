package com.cursomc.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cursomc.domain.enums.Perfil;

public class UserSS implements UserDetails{		
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities; //Lista de perfis
	
	public UserSS() {		
	}	
	
	public UserSS(Integer id, String email, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}



	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Retorna os perfis
		return authorities;
	}

	@Override
	public String getPassword() {		
		return senha;
	}

	@Override
	public String getUsername() {		
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// Verifica se a conta não esta expirada
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// Verifica se a conta não esta bloqueada
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// Verifica se a credencial não esta expirada
		return true;
	}

	@Override
	public boolean isEnabled() {
		// Usuario esta ativo
		return true;
	}

}
