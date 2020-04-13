package br.com.linceit.stella.servlets.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/redirect")
public class RedirectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String attribute = (String) arg0.getAttribute("redirect");
		
		if(arg0.getAttribute("mensagemErro")==null) {
			arg0.setAttribute("mensagemErro", false);
		}
		arg0.getRequestDispatcher(attribute).forward(arg0, arg1);
	}
}
