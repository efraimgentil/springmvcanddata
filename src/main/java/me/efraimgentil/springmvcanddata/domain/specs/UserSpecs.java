package me.efraimgentil.springmvcanddata.domain.specs;

import org.springframework.data.jpa.domain.Specification;

import me.efraimgentil.springmvcanddata.domain.User;

public class UserSpecs {
	
	public static Specification<User> active(){
		return (root , query , cb) -> {
			return cb.equal( root.get("active"), Boolean.TRUE );
		};
	}
	
	public static Specification<User> withRole(final String role){
		return (root , query , cb) -> {
			return cb.equal( cb.upper( root.get("active") ), role.toUpperCase() );
		};
	}
	
}
