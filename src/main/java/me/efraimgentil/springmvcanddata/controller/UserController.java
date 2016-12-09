package me.efraimgentil.springmvcanddata.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.efraimgentil.springmvcanddata.domain.User;
import me.efraimgentil.springmvcanddata.repository.UserRepository;

import static org.springframework.data.jpa.domain.Specifications.*;
import static me.efraimgentil.springmvcanddata.domain.specs.UserSpecs.*;

@Controller
@RestController
public class UserController {
	
	@Autowired UserRepository repository;
	
	@RequestMapping(value = { "/" })
	public List<User> allUsers(){
		return repository.findAll();
	}
	
	@RequestMapping(value = { "/{id}" })
	public User user( @PathVariable("id") Integer id ){
		return repository.findOne(id);
	}
	
	@RequestMapping(value = { "/active" })
	public List<User> allActiveUsers( ){
		return repository.findAll( active() );
	}
	
	@RequestMapping(value = { "/with-role/{role}" })
	public List<User> allUsersWithRole( @PathVariable("role") String role ){
		return repository.findAll( withRole( role ) );
	}
	
	@RequestMapping(value = { "/active/with-role/{role}" })
	public List<User> allActiveUsersWithRole( final @PathVariable("role") String role ){
		return repository.findAll( where( active() ).and( withRole(role) ) );
	}
	
}
