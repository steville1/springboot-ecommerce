package com.tastefultreasure.ecommerce.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 @Column(nullable = false, unique = true)
	 private String username;
	 @Column(nullable = false, unique = true)
	 private String email;
	 @Column(nullable = false)
	 private String password;

	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinTable(name = "users_roles",
	            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
	    )
	 private Set<Role> roles;
	 
	// Getter and Setter for id
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    // Getter and Setter for name
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    // Getter and Setter for username
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    // Getter and Setter for email
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    // Getter and Setter for password
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    // Getter and Setter for roles
	    public Set<Role> getRoles() {
	        return roles;
	    }

	    public void setRoles(Set<Role> roles) {
	        this.roles = roles;
	    }
}
