package br.com.linceit.stella.bo;

import java.util.List;

import br.com.linceit.stella.bean.Questao;
import br.com.linceit.stella.dao.QuestaoDAO;
import br.com.linceit.stella.exception.ProblemaInternoException;

public class QuestaoBO {

	private QuestaoDAO questaoDAO;

	private static QuestaoBO questaoBO = null;

	private QuestaoBO() {
		this.questaoDAO = new QuestaoDAO();
	}

	public QuestaoBO getInstance() {
		if (questaoBO == null) {
			questaoBO = new QuestaoBO();
		}

		return questaoBO;
	}
	
	public void salvarQuestao(Questao q) throws ProblemaInternoException {
		try {
			if (q.getCdQuestao() > 0) {
				questaoDAO.atualizarQuestao(q);
			} else {
				questaoDAO.salvarQuestao(q);
			}
		} catch (Exception ex) {
			throw new ProblemaInternoException(ex.getLocalizedMessage());
		}
	}
	
	public void removerQuestao(int cdQuestao) throws ProblemaInternoException {
		try {
			questaoDAO.removerQuestao(cdQuestao);
		} catch (Exception ex) {
			throw new ProblemaInternoException(ex.getLocalizedMessage());
		}
	}
}
