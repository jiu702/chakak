package com.streetcheck.Impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.streetcheck.Entity.User;

import lombok.Getter;

@Getter
public class UserDetailsImpl implements UserDetails {
	
	private final String userId;
	private final String password;
	
	public UserDetailsImpl(User user) {
		this.userId = user.getUserId();
		this.password = user.getPassword();
	
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	public String getUsername() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부
    }

    
    public boolean isAccountNonLocked() {
        return true; // 잠김 여부
    }

 
    public boolean isCredentialsNonExpired() {
        return true; // 자격 증명 만료 여부
    }

   
    public boolean isEnabled() {
        return true; // 활성화 여부
    }
}