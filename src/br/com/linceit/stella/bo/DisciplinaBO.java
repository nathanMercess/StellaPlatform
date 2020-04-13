package br.com.linceit.stella.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.linceit.stella.bean.Conteudo;
import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.dao.AdministradorDAO;
import br.com.linceit.stella.dao.ConteudoDAO;
import br.com.linceit.stella.dao.DisciplinaDAO;
import br.com.linceit.stella.exception.BOException;
import br.com.linceit.stella.exception.DadosInsuficientesException;
import br.com.linceit.stella.exception.EntidadeNaoEncontradaException;
import br.com.linceit.stella.exception.ExceptionMessage;
import br.com.linceit.stella.exception.ProblemaInternoException;

public class DisciplinaBO {
	private Logger logger = Logger.getLogger(DisciplinaBO.class.getName());

	private DisciplinaDAO disciplinaDAO;
	private AdministradorDAO adminDAO;
	private ConteudoDAO conteudoDAO;
	
	public DisciplinaBO() {
		this.disciplinaDAO = new DisciplinaDAO();
		this.adminDAO = new AdministradorDAO();
		this.conteudoDAO = new ConteudoDAO();
	}
	
	public void salvarDisciplina(Disciplina disciplina, Conteudo primeiroCapitulo) throws Exception {
		try {
			if (disciplina.getNome() != null && disciplina.getDtAbertura() != null) {
				if (disciplina.getAdministrador() != null
						&& adminDAO.existeAdmin(disciplina.getAdministrador().getCdAdmin())) {
					int novaDisciplinaID = disciplinaDAO.salvarDisciplina(disciplina);
					if(novaDisciplinaID > 0) {
						disciplina.setCdDisciplina(novaDisciplinaID);
						primeiroCapitulo.setDisciplina(disciplina);
						conteudoDAO.salvarConteudo(primeiroCapitulo);
					} else {
						throw new Exception(ExceptionMessage.PROBLEMA_INTERNO.toString());
					}
				} else {
					throw new EntidadeNaoEncontradaException(EntidadeNaoEncontradaException.ADMINISTRADOR);
				}
			} else {
				throw new DadosInsuficientesException("Nome e data de abertura são obrigatorios");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getLocalizedMessage());
			throw new Exception(ExceptionMessage.PROBLEMA_INTERNO.toString());
		}
	}
	
	public List<Disciplina> listaDisciplina() throws BOException {
		try {
			return disciplinaDAO.listaDisciplinas();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Ocorreu um imprevisto");
		}
	}
	
	public List<Disciplina> listaDisciplinaAluno(int rm) throws BOException {
		try {
			return disciplinaDAO.listaDisciplinasAluno(rm);
		} catch (Exception e) {
			throw new BOException("Ocorreu um imprevisto");
		}
	}
	
	public void desativarDisciplina(int id) throws ProblemaInternoException {
		try {
			int deletarDisciplina = disciplinaDAO.deletarDisciplina(id);
		} catch (Exception e) {
			throw new ProblemaInternoException(e.getLocalizedMessage());
		}
	}
	
	
	
}
