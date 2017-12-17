package com.rdemir.donemprojesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
public class DonemprojesiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DonemprojesiApplication.class, args);
	}
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DonemprojesiApplication.class);
	}
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
		return servletRegistrationBean;
	}
}
