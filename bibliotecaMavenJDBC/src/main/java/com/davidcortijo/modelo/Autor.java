package com.davidcortijo.modelo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("autor")
public class Autor implements InitializingBean, DisposableBean{
	
	//@Value("Eleuterio Decimononico")
	String nombre;
	//@Value("Colombiana")
	String nacionalidad;
	//@Value("Premio Nobel de Literatura 2004")
	String comentarios;
	
	public Autor() {
		super();
		System.out.println("Creando bean Autor: " + Integer.toHexString(System.identityHashCode(this))+ " - " + this);
	}
	public Autor(String nombre, String nacionalidad, String comentarios) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.comentarios = comentarios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", comentarios=" + comentarios + "]";
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Propiedades inyectadas para el autor.");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Destruyendo el bean autor.");			
	}
}
