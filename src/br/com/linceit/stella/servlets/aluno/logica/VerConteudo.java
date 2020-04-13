package br.com.linceit.stella.servlets.aluno.logica;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Conteudo;
import br.com.linceit.stella.dao.ConteudoDAO;
import br.com.linceit.stella.dto.UsuarioLogado;
import br.com.linceit.stella.service.bucket.StellaBucket;
import br.com.linceit.stella.servlets.Logica;

public class VerConteudo implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		UsuarioLogado aluno = (UsuarioLogado) req.getSession().getAttribute("usuario");
		
		ConteudoDAO dao = new ConteudoDAO();
		try {
			Conteudo conteudo = dao.buscarConteudo(Integer.valueOf(req.getParameter("cdConteudo")));
			String localDoc = conteudo.getLocalDoc();
			String file = new StellaBucket().readFile(localDoc);
			req.setAttribute("conteudo", file);
			req.setAttribute("tituloConteudo", req.getParameter("tituloConteudo"));
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new ServletException(e.getLocalizedMessage());
		}
		
		return "/aluno/conteudo.jsp";
	}
	
}
