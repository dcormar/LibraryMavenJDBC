package com.davidcortijo.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.davidcortijo.modelo.Autor;
import com.davidcortijo.modelo.Direccion;
import com.davidcortijo.modelo.Editorial;
import com.davidcortijo.modelo.Libro;

@Configuration
@ComponentScan(basePackages="com.davidcortijo.cliente, com.davidcortijo.modelo")
public class SpringConfigurationAuto {
	
	@Bean
	public Autor autor() {
		return new Autor();
	}
	@Bean
	public Direccion direccion() {
		return new Direccion();
	}
	@Bean
	public Editorial editorial() {
		return new Editorial();
	}
	@Bean
	public Libro libro() {
		return new Libro();
	}
}
