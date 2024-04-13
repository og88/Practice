package com.og.videogamebacklog.main;

import javax.servlet.ServletContextListener;

import com.og.videogamebacklog.URLS.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

	// Register Servlet
	@Bean
	public ServletRegistrationBean gamesAPI() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new getGames(), "/games");
		return bean;
	}

	// Register Filter
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new filter());
		// Mapping filter to a Servlet
		bean.addServletRegistrationBeans(new ServletRegistrationBean[] { gamesAPI() });
		return bean;
	}

	// Register ServletContextListener
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean() {
		ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<>();
		bean.setListener(new listener());
		return bean;

	}

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
