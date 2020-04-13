package br.com.linceit.stella.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import br.com.linceit.stella.bean.Administrador;
import br.com.linceit.stella.dao.AdministradorDAO;

public class StartupCheckAdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(StartupCheckAdminServlet.class.getName());
	
	@Override
	public void init() throws ServletException {
		AdministradorDAO adminDao = new AdministradorDAO();
		
		try {
			if(!adminDao.existeAdmin()) {
				Administrador admin = new Administrador();
				admin.setCdAdmin(1);
				admin.setNome("admin");
				admin.setEmail("linceit2019@gmail.com");
				admin.setSenha("lince");
				adminDao.salvarAdmin(admin);
				logger.log(Level.INFO, "Usuário administrador criado.");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
	}
}
