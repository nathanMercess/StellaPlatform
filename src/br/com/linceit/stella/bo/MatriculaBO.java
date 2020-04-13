package br.com.linceit.stella.bo;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.linceit.stella.bean.Aluno;
import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.bean.Matricula;
import br.com.linceit.stella.dao.AlunoDAO;
import br.com.linceit.stella.dao.DisciplinaDAO;
import br.com.linceit.stella.dao.MatriculaDAO;
import br.com.linceit.stella.exception.BOException;
import br.com.linceit.stella.exception.DadosInsuficientesException;
import br.com.linceit.stella.exception.EntidadeNaoEncontradaException;
import br.com.linceit.stella.exception.ExceptionMessage;
import br.com.linceit.stella.exception.MatriculaDuplicadaException;

public class MatriculaBO {
	
	private Logger logger = Logger.getLogger(MatriculaDAO.class.getName());
	
	private static MatriculaBO instance;
	
	private AlunoDAO alunoDAO;
	private MatriculaDAO matriculaDAO;
	private DisciplinaDAO disciplinaDAO; 
	
	private MatriculaBO() {
		this.alunoDAO = new AlunoDAO();
		this.matriculaDAO = new MatriculaDAO();
		this.disciplinaDAO = new DisciplinaDAO();
	}
	
	public static MatriculaBO getInstance() {
		if(instance == null) {
			instance = new MatriculaBO();
		}
		
		return instance;
	}
	
	public void registrarMatricula(Matricula matricula) throws Exception, EntidadeNaoEncontradaException {
		try {
			if(matricula.getAluno() == null || matricula.getDisciplina()==null) {
				throw new DadosInsuficientesException("Obrigatório informar o aluno e a disciplina da nova matricula");
			}
			
			// Valida existencia do aluno informado
			Aluno alunoBuscado = alunoDAO.buscarAluno(matricula.getAluno().getRm());
			if(alunoBuscado == null) {
				throw new EntidadeNaoEncontradaException(EntidadeNaoEncontradaException.ALUNO);
			}
			
			// Valida existencia da disciplina informada
			Disciplina disciplinaBuscada = disciplinaDAO.buscarDisciplina(matricula.getDisciplina().getCdDisciplina());
			if(disciplinaBuscada == null) {
				throw new EntidadeNaoEncontradaException(EntidadeNaoEncontradaException.DISCIPLINA);
			}
			
			// Verifica matricula aberta da disciplina
			List<Matricula> matriculasDoAluno = matriculaDAO.buscaMatriculas(alunoBuscado);
			for(Matricula m : matriculasDoAluno) {
				Disciplina discJaMatriculado = m.getDisciplina();
				if(discJaMatriculado.getCdDisciplina() == disciplinaBuscada.getCdDisciplina()) {
					throw new MatriculaDuplicadaException();
				}
			}
			
			// Completa dados da matricula do aluno
			matricula.setAberta(true);
			matricula.setDtMatricula(new Date(System.currentTimeMillis()));
			matriculaDAO.salvarMatricula(matricula);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getLocalizedMessage());
			throw new Exception(ExceptionMessage.PROBLEMA_INTERNO.toString());
		}
	}
	
	public void trancarMatricula(int cdMatricula) throws Exception {
		try {
			matriculaDAO.atualizarStatusMatricula(cdMatricula, false);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getLocalizedMessage());
			throw new Exception(ExceptionMessage.PROBLEMA_INTERNO.toString());
		}
	}
	
	public void abrirMatricula(int cdMatricula) throws Exception {
		try {
			matriculaDAO.atualizarStatusMatricula(cdMatricula, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getLocalizedMessage());
			throw new Exception(ExceptionMessage.PROBLEMA_INTERNO.toString());
		}
	}
	
	public Matricula buscaMatricula(int rmAluno, int cdDisciplina) throws BOException {
		try {
			return matriculaDAO.buscaMatricula(rmAluno,cdDisciplina);
		} catch (Exception e) {
			throw new BOException("Ocorreu um imprevisto");
		}
	}
}
