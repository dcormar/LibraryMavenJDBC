package com.davidcortijo.persistencia.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.davidcortijo.modelo.Editorial;


public class EditorialesDAO extends JdbcDaoSupport {
	
	/*private ConnectionMgr connectionMgr;

	public ConnectionMgr getConnectionMgr() {
		return connectionMgr;
	}

	public void setConnectionMgr(ConnectionMgr connectionMgr) {
		this.connectionMgr = connectionMgr;
	}*/
	
	//private JdbcTemplate plantilla;
    private RowMapper<Editorial> editorialMapper;

    public List<Editorial> mostrarTodos(){
        return getJdbcTemplate().query("select * from EDITORIALES", editorialMapper);
    }

	/*public JdbcTemplate getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(JdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}*/

	public RowMapper<Editorial> getEditorialMapper() {
		return editorialMapper;
	}

	public void setEditorialMapper(RowMapper<Editorial> editorialMapper) {
		this.editorialMapper = editorialMapper;
	}

	public Editorial consultarEditorial(String nif) {
		return getJdbcTemplate().queryForObject("select * from EDITORIALES where NIF = ?",new Object[] {nif}, editorialMapper);
	}

	public void altaEditorial(Editorial editorial) {
		String sql = "insert into EDITORIALES values (?,?,?)";
		getJdbcTemplate().update(sql, editorial.getNif(), editorial.getNombre(), editorial.getDireccion().getCalle());
	}
}
