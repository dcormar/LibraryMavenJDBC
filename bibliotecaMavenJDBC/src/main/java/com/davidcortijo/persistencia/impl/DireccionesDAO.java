package com.davidcortijo.persistencia.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.davidcortijo.modelo.Direccion;

public class DireccionesDAO {

	/*private ConnectionMgr connectionMgr;

	public ConnectionMgr getConnectionMgr() {
		return connectionMgr;
	}

	public void setConnectionMgr(ConnectionMgr connectionMgr) {
		this.connectionMgr = connectionMgr;
	}*/
	
	private JdbcTemplate plantilla;
    private RowMapper<Direccion> direccionMapper;

    public List<Direccion> mostrarTodos(){
        return plantilla.query("select * from DIRECCIONES", direccionMapper);
    }

	public JdbcTemplate getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(JdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}

	public RowMapper<Direccion> getDireccionMapper() {
		return direccionMapper;
	}

	public void setDireccionMapper(RowMapper<Direccion> direccionMapper) {
		this.direccionMapper = direccionMapper;
	}

	public Direccion consultarDireccion(String calle) {
		return plantilla.queryForObject("select * from DIRECCIONES where CALLE = ?",new Object[] {calle}, direccionMapper);
	}

	public void altaDireccion(Direccion direccion) {
		String sql = "insert into DIRECCIONES values (?,?,?)";
		plantilla.update(sql, direccion.getCalle(),direccion.getNumero(),direccion.getCp(),direccion.getPoblacion(),direccion.getProvincia());
	}
	
}
