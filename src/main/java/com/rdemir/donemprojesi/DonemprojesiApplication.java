package com.rdemir.donemprojesi;

import com.rdemir.donemprojesi.config.ViewConfig;
import com.rdemir.donemprojesi.util.ScopeUtil;
import com.sun.faces.config.ConfigureListener;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;
import java.util.HashMap;
import java.util.Map;

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
    public ServletRegistrationBean facesServletRegistraiton() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new FacesServlet(), new String[]{"*.xhtml"});
        registration.setName("Faces Servlet");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.THEME", "bootstrap");
            servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
            servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.UPLOADER", "commons");
        };
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(
                new ConfigureListener());
    }

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        Map<String, Object> scopes = new HashMap<String, Object>();
        scopes.put(ScopeUtil.VIEW, new ViewConfig());
        scopes.put(ScopeUtil.SESSION, new ViewConfig());
        scopes.put(ScopeUtil.APPLICATION, new ViewConfig());
        configurer.setScopes(scopes);
        return configurer;
    }
}
