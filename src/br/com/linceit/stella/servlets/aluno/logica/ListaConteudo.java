package br.com.linceit.stella.servlets.aluno.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Avaliacao;
import br.com.linceit.stella.bo.AvaliacaoBO;
import br.com.linceit.stella.bo.ConteudoBO;
import br.com.linceit.stella.dto.ConteudoProgressao;
import br.com.linceit.stella.dto.UsuarioLogado;
import br.com.linceit.stella.servlets.Logica;

public class ListaConteudo implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		UsuarioLogado aluno = (UsuarioLogado) req.getSession().getAttribute("usuario");
		ConteudoBO conteudoBO = ConteudoBO.getInstance();
		AvaliacaoBO avaliacaoBO = AvaliacaoBO.getInstance();
		
		List<ConteudoProgressao> conteudoProgressao = new ArrayList<>();
		conteudoProgressao = conteudoBO.listaConteudoComProgressaoAluno(aluno.getIdentificador(), Integer.valueOf(req.getParameter("cdDisciplina")));
		
		List<Avaliacao> listaAvaliacao = avaliacaoBO.listaAvaliacao(Integer.valueOf(req.getParameter("cdDisciplina")));
		req.setAttribute("avaliacoes", listaAvaliacao);
		
		req.setAttribute("disciplina", req.getParameter("disciplina"));
		req.setAttribute("conteudosComProgressao", conteudoProgressao);
		return "/aluno/verConteudos.jsp";
	}
}
