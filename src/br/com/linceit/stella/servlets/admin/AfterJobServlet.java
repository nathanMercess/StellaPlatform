package br.com.linceit.stella.servlets.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/afterJob")
public class AfterJobServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String attribute = (String) arg0.getAttribute("mensagem");
		if(arg0.getAttribute("mensagemErro")==null) {
			arg0.setAttribute("mensagemErro", false);
		} else {
			arg1.setStatus(500);
		}
		
		arg1.setContentType("text/plain");
		arg1.getWriter().print(attribute);
		
		
	}
}
