package com.somi.springbootdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootDemoApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootDemoApplication.class);
    }

    public static void main(String[] args) {
       // Character.ge
        logger.info("this is a info message");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }


}
