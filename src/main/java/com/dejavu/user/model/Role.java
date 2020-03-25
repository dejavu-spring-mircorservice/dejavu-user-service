package com.dejavu.user.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	
	private static final long serialVersionUID = 7948391391993992974L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	private String role;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
	@ManyToMany
	@JoinTable(name="role_privileges", 
			joinColumns = @JoinColumn(name="role_id"),
			inverseJoinColumns = @JoinColumn(name="privilegeId"))
	private List<Privilege> privileges;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	@Override
	public String getAuthority() {
		return role;
	}
	
	
}
