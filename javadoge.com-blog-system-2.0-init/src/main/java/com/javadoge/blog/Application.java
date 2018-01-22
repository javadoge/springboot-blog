package com.javadoge.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

/**
 * @title: application start
 * @author: libinghui  
 * @date: Jan 19, 2018 
 * @version: V2.0
 */
@SpringBootApplication
public class Application {
	
	/**
	 * config error page
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	   return (container -> {
	        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401");
	        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
	        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
	        container.addErrorPages(error401Page, error404Page, error500Page);
	        //session time out , unit:s
			//container.setSessionTimeout(3600);
	   }); 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
