package com.davidcortijo.modelo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("direccion")
public class Direccion {
	
	//@Value("Calle de la Tortola")
	String calle;
	//@Value("17")
	int numero;
	//@Value("Arroyo de Valdeusera")
	String poblacion;
	//@Value("33753")
	int cp;
	//@Value("La Cochabamba")
	String provincia;
	
	
	
	public Direccion() {
		super();
		System.out.println("Creando bean Direccion: " + Integer.toHexString(System.identityHashCode(this))+ " - " + this);		
	}
	
	public Direccion(String calle) {
		super();
		this.calle = calle;
	}
	
	public Direccion(String calle, int numero, String poblacion, int cp, String provincia) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.cp = cp;
		this.provincia = provincia;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + ", poblacion=" + poblacion + ", cp=" + cp
				+ ", provincia=" + provincia + "]";
	}
	
	
}
