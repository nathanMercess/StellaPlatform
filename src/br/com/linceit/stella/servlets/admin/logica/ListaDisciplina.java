package br.com.linceit.stella.servlets.admin.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.bo.DisciplinaBO;
import br.com.linceit.stella.exception.BOException;
import br.com.linceit.stella.servlets.Logica;

public class ListaDisciplina implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		DisciplinaBO disciplinaBO = new DisciplinaBO();
		List<Disciplina> listaDisciplina;
		try {
			listaDisciplina = disciplinaBO.listaDisciplina();
		} catch (BOException e) {
			listaDisciplina = new ArrayList<>();
		}
		
		req.setAttribute("disciplinas", listaDisciplina);
		return "/admin/verDisciplinas.jsp";
	}
	
}
