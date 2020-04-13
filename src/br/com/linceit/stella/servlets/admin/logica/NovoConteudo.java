package br.com.linceit.stella.servlets.admin.logica;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.bo.DisciplinaBO;
import br.com.linceit.stella.servlets.Logica;

public class NovoConteudo implements Logica {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		try {
			DisciplinaBO disciplinaBO = new DisciplinaBO();
			List<Disciplina> listaDisciplina = disciplinaBO.listaDisciplina();
			req.setAttribute("disciplinas", listaDisciplina);
			return "/admin/cadastrarCapitulo.jsp";
		} catch (Exception e) {
			req.setAttribute("mensagem", "Ocorreu um imprevisto!");
			req.setAttribute("mensagemErro", true);
			req.setAttribute("redirect", "/admin/info.jsp");
			
			return "/admin/redirect";
		}
	}

}
