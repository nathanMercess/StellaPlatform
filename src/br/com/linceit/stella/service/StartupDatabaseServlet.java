package br.com.linceit.stella.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import br.com.linceit.stella.database.DBType;
import br.com.linceit.stella.database.DBFactory;

public class StartupDatabaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// Config para todos os daos operarem com DATASOURCE
		DBFactory.setupConfig(DBType.NON_DS);
	}
}
