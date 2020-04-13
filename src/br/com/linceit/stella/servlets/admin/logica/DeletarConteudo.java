package br.com.linceit.stella.servlets.admin.logica;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Conteudo;
import br.com.linceit.stella.dao.ConteudoDAO;
import br.com.linceit.stella.servlets.Logica;

public class DeletarConteudo implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		ConteudoDAO conteudoDAO = new ConteudoDAO();
		try {
			conteudoDAO.exluirConteudo(new Conteudo(Integer.valueOf(req.getParameter("id"))));
			req.setAttribute("mensagem", "Conteudo removido com sucesso!");
			req.setAttribute("redirect", "/admin/info.jsp");
			return "/admin/redirect";
		} catch (Exception e) {
			req.setAttribute("mensagem", e.getLocalizedMessage());
			req.setAttribute("mensagemErro", true);
			req.setAttribute("redirect", "/admin/info.jsp");
			return "/admin/redirect";
		}
	}

}
