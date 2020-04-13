package br.com.linceit.stella.bo;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.linceit.stella.bean.Administrador;
import br.com.linceit.stella.dao.AdministradorDAO;
import br.com.linceit.stella.exception.DadosInsuficientesException;
import br.com.linceit.stella.exception.ExceptionMessage;

public class AdministradorBO {
	private Logger logger = Logger.getLogger(AdministradorBO.class.getName());
	private AdministradorDAO adminDAO;
	private CadastroBO cadastroBO;

	public AdministradorBO() {
		this.adminDAO = new AdministradorDAO();
		this.cadastroBO = new CadastroBO();
	}

	public void salvarAdministrador(Administrador admin) throws Exception {
		try {
			if (admin.getNome() != null && admin.getSenha() != null) {
				if (cadastroBO.emailValido(admin.getEmail())) {
					adminDAO.salvarAdmin(admin);
				}
			} else {
				throw new DadosInsuficientesException("Nome e senha sao obrigatorios");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getLocalizedMessage());
			throw new Exception(ExceptionMessage.PROBLEMA_INTERNO.toString());
		}
	}

}
