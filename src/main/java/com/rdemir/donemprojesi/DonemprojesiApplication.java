package com.rdemir.donemprojesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
public class DonemprojesiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DonemprojesiApplication.class, args);
	}

}
