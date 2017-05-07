package com.davidcortijo.negocio.impl;

import com.davidcortijo.modelo.Direccion;
import com.davidcortijo.modelo.Editorial;
import com.davidcortijo.persistencia.impl.EditorialesDAO;

public class EditorialesDTO {

	private EditorialesDAO dao;

    public void consultarEditoriales(){
        for(Editorial e : dao.mostrarTodos())
            System.out.println(e.toString());
    }

    public void buscarEditorial(String nif){
        System.out.println(dao.consultarEditorial(nif).toString());
    }
    
    public void insertarEditorial(String nombre, Direccion direccion,String nif){
        dao.altaEditorial(new Editorial(nombre, direccion, nif));
        System.out.println("Autor insertado");
    }

    public EditorialesDAO getDao() {
        return dao;
    }

    public void setDao(EditorialesDAO dao) {
        this.dao = dao;
    }
}
