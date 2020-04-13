package br.com.linceit.stella.servlets.aluno.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.bo.DisciplinaBO;
import br.com.linceit.stella.dto.UsuarioLogado;
import br.com.linceit.stella.exception.BOException;
import br.com.linceit.stella.servlets.Logica;

public class Dashboard implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		UsuarioLogado aluno = (UsuarioLogado) req.getSession().getAttribute("usuario");
		DisciplinaBO disciplinaBO = new DisciplinaBO();
		
		List<Disciplina> disciplinas = new ArrayList<>();
		
		try {
			disciplinas = disciplinaBO.listaDisciplinaAluno(aluno.getIdentificador());
		} catch (BOException e) {
			
		}
		
		req.setAttribute("disciplinas", disciplinas);
		return "/aluno/index.jsp";
	}
	
}
