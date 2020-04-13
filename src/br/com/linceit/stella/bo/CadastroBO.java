package br.com.linceit.stella.bo;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.linceit.stella.bean.Administrador;
import br.com.linceit.stella.bean.Aluno;
import br.com.linceit.stella.bean.TipoCadastro;
import br.com.linceit.stella.dao.AdministradorDAO;
import br.com.linceit.stella.dao.AlunoDAO;
import br.com.linceit.stella.dao.MatriculaDAO;
import br.com.linceit.stella.exception.BOException;
import br.com.linceit.stella.exception.ExceptionMessage;

public class CadastroBO {
	
	private Logger logger = Logger.getLogger(MatriculaDAO.class.getName());
	
	private AlunoDAO alunoDAO;
	private AdministradorDAO adminDAO;
	
	public CadastroBO() {
		this.alunoDAO = new AlunoDAO();
		this.adminDAO = new AdministradorDAO();
	}
	
	public boolean emailValido(String email) throws Exception {
		try {
			return email != null && !alunoDAO.existeAluno(email) && !adminDAO.existeAdmin(email);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getLocalizedMessage());
			throw new Exception(ExceptionMessage.PROBLEMA_INTERNO.toString());
		}
	}
	
	public TipoCadastro verificaTipoCadastro(String email) throws BOException {
		try {
			if(alunoDAO.existeAluno(email)) {
				return TipoCadastro.ALUNO;
			} else if(adminDAO.existeAdmin(email)) {
				return TipoCadastro.ADMIN;
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage());
			throw new BOException("Ocorreu um imprevisto");			
		}
		
		return null;
	}
	
	public Aluno buscaAluno(String email, String senha) throws BOException {
		try {
			return alunoDAO.buscaAluno(email, senha);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Ocorreu um imprevisto");
		}
	}
	
	public Administrador buscaAdministrador(String email, String senha) throws BOException {
		try {
			return adminDAO.buscaAdministrador(email, senha);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Ocorreu um imprevisto");
		}
	}
	
}
