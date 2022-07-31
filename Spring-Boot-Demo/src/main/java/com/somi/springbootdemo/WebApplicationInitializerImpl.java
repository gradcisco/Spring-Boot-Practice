package com.somi.springbootdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class WebApplicationInitializerImpl implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        WebApplicationContext context = getContext();

        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(context));
        registration.setLoadOnStartup(1);
        registration.addMapping("/*");
    }

    private WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(SpringBootDemoApplication.class.getName());
        return context;
    }

}
