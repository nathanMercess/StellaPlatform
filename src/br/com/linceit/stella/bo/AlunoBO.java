package br.com.linceit.stella.bo;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.linceit.stella.bean.Aluno;
import br.com.linceit.stella.dao.AlunoDAO;
import br.com.linceit.stella.dao.MatriculaDAO;
import br.com.linceit.stella.exception.DadosInsuficientesException;
import br.com.linceit.stella.exception.ExceptionMessage;

public class AlunoBO {
	private Logger logger = Logger.getLogger(MatriculaDAO.class.getName());
	private AlunoDAO alunoDAO;
	private CadastroBO cadastroBO;

	public AlunoBO() {
		alunoDAO = new AlunoDAO();
		cadastroBO = new CadastroBO();
	}
	
	public void salvarAluno(Aluno aluno) throws Exception {
		try {
			if (aluno.getNome() != null && aluno.getEndereco() != null && aluno.getSenha() != null
					&& aluno.getEmail() != null) {
				if (cadastroBO.emailValido(aluno.getEmail())) {
					alunoDAO.salvarAluno(aluno);
				}
			} else {
				throw new DadosInsuficientesException("Campos nome, endereco, senha, email sao obrigatorios");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getLocalizedMessage());
			throw new Exception(ExceptionMessage.PROBLEMA_INTERNO.toString());
		}
	}
}
