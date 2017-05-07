package com.davidcortijo.persistencia.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.davidcortijo.modelo.Direccion;


public class DireccionMapper implements RowMapper<Direccion> {

		public Direccion mapRow(ResultSet rs, int i) throws SQLException {
			Direccion d = new Direccion();
			d.setCalle(rs.getString("CALLE"));
			d.setCp(rs.getInt("CP"));
			d.setNumero(rs.getInt("NUMERO"));
			d.setPoblacion(rs.getString("POBLACION"));
			d.setProvincia(rs.getString("PROVINCIA"));
			return d;
		}
}
