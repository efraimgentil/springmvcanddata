package me.efraimgentil.springmvcanddata.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "me.efraimgentil.springmvcanddata.repository"
, entityManagerFactoryRef="entityManagerFactory" 
, transactionManagerRef="transactionManager")
public class PersistenceConfig {

	@Bean
	public DataSource datasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName( "org.h2.Driver");
		ds.setUrl("jdbc:h2:mem:data;DB_CLOSE_DELAY=-1");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}
	
	@Bean(name= "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean  entityManagerFactoryBean(DataSource ds ) {
		LocalContainerEntityManagerFactoryBean  emfb = new LocalContainerEntityManagerFactoryBean ();
		emfb.setDataSource(ds);
		emfb.setPackagesToScan("me.efraimgentil.springmvcanddata.domain");
		emfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		Properties jpaProterties = new Properties();
		jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		jpaProterties.put("hibernate.format_sql", true );
		jpaProterties.put("hibernate.show_sql", true);
		jpaProterties.put("hibernate.hbm2ddl.auto", "update");
		emfb.setJpaProperties(jpaProterties);
		return emfb;
	}
	
	@Bean(name="transactionManager")
	public JpaTransactionManager transactionmanager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory( emf );
		return transactionManager;
	}
	
}
