package br.com.linceit.stella.servlets.admin.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Conteudo;
import br.com.linceit.stella.bo.ConteudoBO;
import br.com.linceit.stella.exception.ProblemaInternoException;
import br.com.linceit.stella.servlets.Logica;

public class ListaConteudo implements Logica {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		ConteudoBO conteudoBO = ConteudoBO.getInstance();
		List<Conteudo> conteudos = new ArrayList<>();
		try {
			conteudos = conteudoBO.listaConteudo(Integer.valueOf(req.getParameter("cdDisciplina")));
		} catch (NumberFormatException | ProblemaInternoException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		req.setAttribute("conteudos", conteudos);
		req.setAttribute("disciplina", req.getParameter("disciplina"));
		return "/admin/verConteudos.jsp";
	}
	
}
