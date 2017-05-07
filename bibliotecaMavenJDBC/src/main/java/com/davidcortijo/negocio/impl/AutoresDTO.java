package com.davidcortijo.negocio.impl;

import com.davidcortijo.modelo.Autor;
import com.davidcortijo.persistencia.impl.AutoresDAO;

public class AutoresDTO {
	private AutoresDAO dao;

    public void consultarAutores(){
        for(Autor a : dao.mostrarTodos())
            System.out.println(a.toString());
    }

    public void buscarAutor(String nombre){
        System.out.println(dao.consultarAutor(nombre).toString());
    }
    
    public void insertarAutor(String nombre, String nacionalidad,String comentarios){
        dao.altaAutor(new Autor(nombre, nacionalidad,comentarios));
        System.out.println("Autor insertado");
    }

    public AutoresDAO getDao() {
        return dao;
    }

    public void setDao(AutoresDAO dao) {
        this.dao = dao;
    }
}
