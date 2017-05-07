package com.davidcortijo.persistencia.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.davidcortijo.modelo.Editorial;


public class EditorialMapper implements RowMapper<Editorial> {
	
	private DireccionesDAO dao;
	
	public Editorial mapRow(ResultSet rs, int i) throws SQLException {
		Editorial e = new Editorial();
		e.setNif(rs.getString("NIF"));
		e.setNombre(rs.getString("NOMBRE"));		
		e.setDireccion(dao.consultarDireccion(rs.getString("DIRECCION1")));
		return e;
	}

	public DireccionesDAO getDao() {
		return dao;
	}

	public void setDao(DireccionesDAO dao) {
		this.dao = dao;
	}

}
