package br.com.linceit.stella.servlets.aluno;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.servlets.Logica;

@WebServlet("/aluno")
public class SistemaAlunoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8264610048293614477L;

	private Class<?> controllerClass;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String controllerClassName = "br.com.linceit.stella.servlets.aluno.logica." + action;
		
		try {
			controllerClass = Class.forName(controllerClassName);
			Logica controller = (Logica) controllerClass.newInstance();
			String next = controller.execute(request, response);
			request.getRequestDispatcher(next).forward(request, response);
		} catch (Exception e) {
			throw new ServletException("Logica exception", e);
		}
	}
}
