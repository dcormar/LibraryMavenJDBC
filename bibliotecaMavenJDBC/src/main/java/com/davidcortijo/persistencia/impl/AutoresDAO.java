package com.davidcortijo.persistencia.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.davidcortijo.modelo.Autor;

public class AutoresDAO {
		
	/*private ConnectionMgr connectionMgr;

	public ConnectionMgr getConnectionMgr() {
		return connectionMgr;
	}

	public void setConnectionMgr(ConnectionMgr connectionMgr) {
		this.connectionMgr = connectionMgr;
	}*/
	
	private JdbcTemplate plantilla;
    private RowMapper<Autor> autorMapper;

    public List<Autor> mostrarTodos(){
        return plantilla.query("select * from AUTORES", autorMapper);
    }

	public JdbcTemplate getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(JdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}

	public RowMapper<Autor> getAutorMapper() {
		return autorMapper;
	}

	public void setAutorMapper(RowMapper<Autor> autorMapper) {
		this.autorMapper = autorMapper;
	}

	public Autor consultarAutor(String nombre) {
		return plantilla.queryForObject("select * from AUTORES where NOMBRE = ?",new Object[] {nombre}, autorMapper);
	}

	public void altaAutor(Autor autor) {
		String sql = "insert into AUTORES values (?,?,?)";
		plantilla.update(sql, autor.getNombre(), autor.getNacionalidad(), autor.getComentarios());
	}
}
