package com.davidcortijo.configuracion;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.davidcortijo.modelo.Autor;
import com.davidcortijo.modelo.Direccion;
import com.davidcortijo.modelo.Editorial;
import com.davidcortijo.modelo.Libro;
import com.davidcortijo.negocio.impl.AutoresDTO;
import com.davidcortijo.negocio.impl.EditorialesDTO;
import com.davidcortijo.persistencia.impl.AutorMapper;
import com.davidcortijo.persistencia.impl.AutoresDAO;
import com.davidcortijo.persistencia.impl.DireccionMapper;
import com.davidcortijo.persistencia.impl.DireccionesDAO;
import com.davidcortijo.persistencia.impl.EditorialMapper;
import com.davidcortijo.persistencia.impl.EditorialesDAO;

@Configuration
@ComponentScan(basePackages="com.davidcortijo.negocio.impl,com.davidcortijo.persistencia.impl")
public class SpringConfigurationInyec_EmbeddedDB {
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.DERBY) 
			.addScript("db/sql/create-db.sql")
			.addScript("db/sql/insert-data.sql")
			.build();
		return db;
	}
	
	@Bean
	public AutorMapper mapperAutor () {
		return new AutorMapper();
	}
	@Bean
	public DireccionMapper mapperDireccion () {
		return new DireccionMapper();
	}
	@Bean
	public EditorialMapper mapperEditorial () {
		EditorialMapper editorial = new EditorialMapper();
		editorial.setDao(direccionDAO());
		return editorial;
	}
	
	@Bean
	public DireccionesDAO direccionDAO () {
		DireccionesDAO dirDAO = new DireccionesDAO();
		dirDAO.setDataSource(dataSource());
		dirDAO.setDireccionMapper(mapperDireccion());
		return dirDAO;
	}
	
	@Bean
	public EditorialesDAO editorialDAO () {
		EditorialesDAO editDAO = new EditorialesDAO();
		editDAO.setDataSource(dataSource());
		editDAO.setEditorialMapper(mapperEditorial());
		return editDAO;
	}
	
	@Bean
	public AutoresDAO autorDAO () {
		AutoresDAO autDAO = new AutoresDAO();
		autDAO.setDataSource(dataSource());
		autDAO.setAutorMapper(mapperAutor());
		return autDAO;
	}
	
	@Bean
	public EditorialesDTO editorialesDTO () {
		EditorialesDTO editDTO = new EditorialesDTO();
		editDTO.setDao(editorialDAO());
		return editDTO;
	}
	
	@Bean
	public AutoresDTO autoresDTO () {
		AutoresDTO autDTO = new AutoresDTO();
		autDTO.setDao(autorDAO());
		return autDTO;
	}
	
	/*@Bean
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
	}*/
}
