package br.com.linceit.stella.servlets.aluno.logica;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.dao.DisciplinaDAO;
import br.com.linceit.stella.dto.DisciplinaComStatusMatricula;
import br.com.linceit.stella.dto.UsuarioLogado;
import br.com.linceit.stella.servlets.Logica;

public class GerenciarDisciplinas implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		UsuarioLogado aluno = (UsuarioLogado) req.getSession().getAttribute("usuario");
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		try {
			List<DisciplinaComStatusMatricula> listaDisciplinaComStatusMatricula = disciplinaDAO.listaDisciplinaComStatusMatricula(aluno.getIdentificador());
			req.setAttribute("disciplinas", listaDisciplinaComStatusMatricula);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return "/aluno/gerenciamentoDisciplina.jsp";
	}
	
}
