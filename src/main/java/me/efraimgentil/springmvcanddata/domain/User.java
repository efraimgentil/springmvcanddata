package me.efraimgentil.springmvcanddata.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User implements Serializable {
	
	private static final long serialVersionUID = -5613292949395788401L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@JsonIgnore
	private char[] password;
	
	private String role;
	
	private Date createdAt;
	
	private boolean active = true;

	public User() {	}
	
	public User(String name, char[] password) {
		super();
		this.name = name;
		this.password = password;
		this.createdAt = new Date();
	}
	
	public User(String name, char[] password , String role ) {
		this( name , password );
		this.role = role;
	}
	
	public User(String name, char[] password , String role , boolean active ) {
		this( name , password , role);
		this.active = active;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", name=").append(name).append(", password=")
				.append(Arrays.toString(password)).append(", role=").append(role).append(", createdAt=")
				.append(createdAt).append("]");
		return builder.toString();
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

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
