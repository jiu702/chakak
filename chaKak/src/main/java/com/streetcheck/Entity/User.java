package com.streetcheck.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String userId;
	private String password;
	private String email;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Role role = Role.USER;
	
	public enum Role {
		USER,
		ADMIN
	}
	
	private LocalDateTime cratedAt = LocalDateTime.now();
	private LocalDateTime updatedAt;
	private boolean isDeleted;
	private LocalDateTime deletedAt;

}
