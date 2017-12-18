package com.rdemir.donemprojesi;

import org.primefaces.util.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.faces.application.ProjectStage;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

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
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.xhtml");
        return servletRegistrationBean;
    }

    @Bean
    public ServletContextInitializer initializer() {
        return servletContext -> {
            servletContext.setInitParameter(Constants.ContextParams.THEME, "bootstrap");
            servletContext.setInitParameter(Constants.ContextParams.FONT_AWESOME, "true");
            servletContext.setInitParameter(Constants.ContextParams.PFV_KEY, "true");
            servletContext.setInitParameter(ProjectStage.PROJECT_STAGE_PARAM_NAME, ProjectStage.Development.name());
            servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
        };
    }
}
