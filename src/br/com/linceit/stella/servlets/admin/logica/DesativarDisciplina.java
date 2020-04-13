package br.com.linceit.stella.servlets.admin.logica;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bo.DisciplinaBO;
import br.com.linceit.stella.exception.ProblemaInternoException;
import br.com.linceit.stella.servlets.Logica;

public class DesativarDisciplina implements Logica {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		DisciplinaBO disciplinaBO = new DisciplinaBO();
		try {
			disciplinaBO.desativarDisciplina(Integer.valueOf(req.getParameter("id")));
			req.setAttribute("mensagem", "Disciplina desativada!");
			req.setAttribute("redirect", "/admin/info.jsp");
		} catch (NumberFormatException | ProblemaInternoException e) {
			req.setAttribute("mensagemErro", true);
			req.setAttribute("mensagem", "Ocorreu um imprevisto");
			req.setAttribute("redirect", "/admin/info.jsp");
			System.out.println(e.getLocalizedMessage());
		}
		
		return "/admin/redirect";
	}
	
}
