package com.davidcortijo.persistencia.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class LibrosDAO extends JdbcDaoSupport {
	
	private ConnectionMgr connectionMgr;

	public ConnectionMgr getConnectionMgr() {
		return connectionMgr;
	}

	public void setConnectionMgr(ConnectionMgr connectionMgr) {
		this.connectionMgr = connectionMgr;
	}
}
