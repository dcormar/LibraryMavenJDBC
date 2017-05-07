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
public class SpringConfigurationInyec {
	
	@Bean
	public Autor autor() {
		Autor autor = new Autor();
		autor.setNombre("Francisco Capachincha");
		autor.setNacionalidad("Peruana");
		autor.setComentarios("La quintaesencia de la literatura sudamericana");
		return autor;
	}
	@Bean
	public Direccion direccion() {
		Direccion direccion = new Direccion();
		direccion.setCalle("Calle de los Últimos de Filipinas");
		direccion.setNumero(45);
		direccion.setCp(28056);
		direccion.setPoblacion("Leganés");
		direccion.setProvincia("Madrid");
		return direccion;
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
