package br.com.linceit.stella.servlets.aluno.logica;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Avaliacao;
import br.com.linceit.stella.bean.Matricula;
import br.com.linceit.stella.bo.AvaliacaoBO;
import br.com.linceit.stella.bo.MatriculaBO;
import br.com.linceit.stella.dto.QuestionarioComResposta;
import br.com.linceit.stella.dto.QuestionarioSemResposta;
import br.com.linceit.stella.dto.UsuarioLogado;
import br.com.linceit.stella.servlets.Logica;

public class VerAvaliacao implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		UsuarioLogado aluno = (UsuarioLogado) req.getSession().getAttribute("usuario");
		Integer cdAvaliacao = Integer.valueOf(req.getParameter("cdAvaliacao"));
		
		try {
			AvaliacaoBO avaliacaoBO = AvaliacaoBO.getInstance();
			Avaliacao avaliacao = avaliacaoBO.buscaAvaliacao(cdAvaliacao);
			MatriculaBO matriculaBO = MatriculaBO.getInstance();
			Matricula matricula = matriculaBO.buscaMatricula(aluno.getIdentificador(), avaliacao.getDisciplina().getCdDisciplina());
			boolean realizouAvaliacao = avaliacaoBO.alunoRealizouAvaliacao(matricula.getCdMatricula(), avaliacao.getCdAvaliacao());
			if(realizouAvaliacao) {
				// redireciona gabarito
				List<QuestionarioComResposta> listaQuestionarioComResposta = avaliacaoBO.listaQuestionarioComResposta(cdAvaliacao, matricula.getCdMatricula());
				req.setAttribute("listaQuestionario", listaQuestionarioComResposta);
				req.setAttribute("tituloAvaliacao", "Gabarito:"+avaliacao.getTitulo());
				return "aluno/gabarito.jsp";
			} else {
				// redireciona nova avaliacao
				req.setAttribute("tituloAvaliacao","Avaliação: "+avaliacao.getTitulo());
				req.setAttribute("cdAvaliacao", cdAvaliacao);
				req.setAttribute("cdMatricula", matricula.getCdMatricula());
				req.setAttribute("cdDisciplina", avaliacao.getDisciplina().getCdDisciplina());
				List<QuestionarioSemResposta> listaQuestionarioSemResposta = avaliacaoBO.listaQuestionarioSemResposta(cdAvaliacao);
				req.setAttribute("listaQuestionario", avaliacaoBO.listaQuestionarioSemResposta(cdAvaliacao));
				return "aluno/realizacaoAvaliacao.jsp";
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new ServletException(e.getLocalizedMessage());
		}
	}
}
