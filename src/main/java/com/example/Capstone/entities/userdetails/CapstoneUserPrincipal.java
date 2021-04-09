package com.example.Capstone.entities.userdetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Capstone.entities.User;

public class CapstoneUserPrincipal implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private User user;
	
	public CapstoneUserPrincipal(User user) {
		this.user = user;
	}
		
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		if (user.isAdmin())
			return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		
		return AuthorityUtils.createAuthorityList("ROLE_USER");
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
