package com.dejavu.user.security;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dejavu.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrincipal implements UserDetails{
	private static final long serialVersionUID = 1285884341734005699L;

	private Integer id;

    private String name;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;
    
    private Timestamp lastAccessTime;
    
    private UserPrincipal(Integer id, String name, String email, String password, Collection<? extends GrantedAuthority> authorities) {
    	this.id = id;
    	this.name = name;
    	this.email = email;
    	this.password = password;
    	this.authorities = authorities;
    }
    
    public static UserPrincipal create(User user) {
    	return new UserPrincipal(user.getUserId(), user.getName(), user.getEmail(), user.getPassoword(),user.getRoles());
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Timestamp lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
