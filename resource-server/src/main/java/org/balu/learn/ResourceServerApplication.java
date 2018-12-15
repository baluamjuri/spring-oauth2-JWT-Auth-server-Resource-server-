package org.balu.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@RestController
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ResourceServerApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String hasRoleAdmin() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();						
		return "Hi "+name+", you have Admin Role";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public String message() {
		return "You have User Role" ;
	}
	
	@GetMapping("/")
	public String welcome() {
		return "This is Resource server...";
	}
}
