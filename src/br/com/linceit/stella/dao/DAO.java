package br.com.linceit.stella.dao;

import java.sql.Connection;

import br.com.linceit.stella.database.DBFactory;

public class DAO {
	
	protected Connection conn;
	
	public DAO() {
		conn = DBFactory.getConnection();
	}
	
}
