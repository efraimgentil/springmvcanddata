package me.efraimgentil.springmvcanddata;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import me.efraimgentil.springmvcanddata.domain.User;

@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	@PersistenceContext EntityManager em;
	
	private boolean startup = true;
	
	@Transactional
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if( startup ){
			startup = false;
			em.persist( new User( "user1" , new char[]{ 'S' ,'E' , 'C' , 'R' , 'E' , 'T' } , "ROLE2" ) );
			em.persist( new User( "user2" , new char[]{ 'S' ,'E' , 'C' , 'R' , 'E' , 'T' } , "ROLE1" ) );
			em.persist( new User( "user3" , new char[]{ 'S' ,'E' , 'C' , 'R' , 'E' , 'T' } , "ROLE1" , false ) );
			em.persist( new User( "user4" , new char[]{ 'S' ,'E' , 'C' , 'R' , 'E' , 'T' } , "ROLE2" , false) );
			em.persist( new User( "user5" , new char[]{ 'S' ,'E' , 'C' , 'R' , 'E' , 'T' } , "ROLE3"  ) );
		}
	}

}
