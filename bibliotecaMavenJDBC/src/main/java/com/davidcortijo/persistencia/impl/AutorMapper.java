package com.davidcortijo.persistencia.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.davidcortijo.modelo.Autor;

public class AutorMapper  implements RowMapper<Autor>{

	    public Autor mapRow(ResultSet rs, int i) throws SQLException {
	        Autor a = new Autor();
	        a.setNombre(rs.getString("NOMBRE"));
	        a.setNacionalidad(rs.getString("NACIONALIDAD"));
	        a.setComentarios(rs.getString("COMENTARIOS"));
	        return a;
	    }	
	
}
