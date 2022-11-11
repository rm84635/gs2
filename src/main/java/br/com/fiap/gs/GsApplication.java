package br.com.fiap.gs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.fiap.gs.controllers, br.com.fiap.gs.config"})
public class GsApplication {
	public static void main(String[] args) {
		SpringApplication.run(GsApplication.class, args);
	}
}
