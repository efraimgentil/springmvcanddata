package me.efraimgentil.springmvcanddata.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "me.efraimgentil.springmvcanddata.controller" })
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

}