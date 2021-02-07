package com.deneme.Run;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.deneme.Controller.MainController;

@SpringBootApplication
@ComponentScan(basePackages = { "com.deneme.Controller", "com.deneme.service", "com.deneme.Repository", "com.deneme" })
@EntityScan(basePackages = { "com.deneme.Model" })
@EnableJpaRepositories(basePackages = { "com.deneme.Repository" })
@EnableAutoConfiguration
public class AppMain extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(AppMain.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(AppMain.class);
	}

}