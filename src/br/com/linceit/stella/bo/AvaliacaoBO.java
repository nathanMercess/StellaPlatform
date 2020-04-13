package br.com.linceit.stella.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.linceit.stella.bean.Avaliacao;
import br.com.linceit.stella.bean.Matricula;
import br.com.linceit.stella.bean.Questao;
import br.com.linceit.stella.bean.QuestionarioRespondido;
import br.com.linceit.stella.dao.AvaliacaoDAO;
import br.com.linceit.stella.dao.QuestaoDAO;
import br.com.linceit.stella.dao.QuestionarioDAO;
import br.com.linceit.stella.dto.AvaliacaoRespondida;
import br.com.linceit.stella.dto.QuestionarioComResposta;
import br.com.linceit.stella.dto.QuestionarioSemResposta;
import br.com.linceit.stella.exception.BOException;
import br.com.linceit.stella.exception.ProblemaInternoException;

public class AvaliacaoBO {

	private AvaliacaoDAO avaliacaoDAO;
	private QuestaoDAO questaoDAO;
	private QuestionarioDAO questionarioDAO;

	private static AvaliacaoBO avaliacaoBO = null;

	private AvaliacaoBO() {
		this.avaliacaoDAO = new AvaliacaoDAO();
		this.questaoDAO = new QuestaoDAO();
		this.questionarioDAO = new QuestionarioDAO();
	}

	public static AvaliacaoBO getInstance() {
		if (avaliacaoBO == null) {
			avaliacaoBO = new AvaliacaoBO();
		}

		return avaliacaoBO;
	}

	public void salvarAvaliacao(Avaliacao a) throws BOException, ProblemaInternoException {
		if (!(a.getQuestoes().size() == a.getQtdeQuestao())) {
			throw new BOException("Número de questões inválida");
		}

		try {
			int cdAvaliacao = avaliacaoDAO.cadastrarAvaliacao(a);
			for (int i = 0; i < a.getQuestoes().size(); i++) {
				int cdQuestao = questaoDAO.salvarQuestao(a.getQuestoes().get(i));

				questionarioDAO.salvarQuestionario(cdAvaliacao, cdQuestao);
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new ProblemaInternoException(e.getLocalizedMessage());
		}
	}

	public void removerAvaliacao(int cdAvaliacao) {

	}

	public Avaliacao buscaAvaliacao(int cdAvaliacao) {
		try {
			return avaliacaoDAO.buscaAvaliacao(cdAvaliacao);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

	public List<Avaliacao> listaAvaliacao(int cdDisciplina) {
		try {
			return avaliacaoDAO.buscaAvaliacoes(cdDisciplina);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return new ArrayList<>();
		}
	}

	public boolean alunoRealizouAvaliacao(int cdMatricula, int cdAvaliacao) throws ProblemaInternoException {
		try {
			return questionarioDAO.alunoRealizouQuestionario(cdMatricula, cdAvaliacao);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new ProblemaInternoException("Ocorreu um imprevisto");
		}
	}

	public List<QuestionarioSemResposta> listaQuestionarioSemResposta(int cdAvaliacao) throws ProblemaInternoException {
		try {
			return questionarioDAO.listaQuestionarioSemResposta(cdAvaliacao);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new ProblemaInternoException("Ocorreu um imprevisto!");
		}
	}
	
	public List<QuestionarioComResposta> listaQuestionarioComResposta(int cdAvaliacao, int cdMatricula) throws ProblemaInternoException {
		try {
			return questionarioDAO.listaQuestionarioComResposta(cdAvaliacao, cdMatricula);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new ProblemaInternoException("Ocorreu um imprevisto!");
		}
	}
	
	public void salvarAvaliacaoRespondida(AvaliacaoRespondida avaliacaoRespondida) {
		avaliacaoRespondida.getRespostas().forEach(r -> {
			try {
				QuestionarioRespondido qR = new QuestionarioRespondido();
				qR.setAvaliacao(new Avaliacao(avaliacaoRespondida.getCdAvaliacao()));
				qR.setMatricula(new Matricula(avaliacaoRespondida.getCdMatricula()));
				qR.setQuestao(new Questao(r.getCdQuestao()));
				qR.setRespostaAluno(r.getResposta());
				qR.setRespostaCorreta(questaoDAO.getRespostaCorreta(r.getCdQuestao()));
				questionarioDAO.salvarQuestionarioRespondido(qR);
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		});
	}
}
