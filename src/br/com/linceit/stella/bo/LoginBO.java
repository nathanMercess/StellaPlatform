package br.com.linceit.stella.bo;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.linceit.stella.bean.Administrador;
import br.com.linceit.stella.bean.Aluno;
import br.com.linceit.stella.bean.TipoCadastro;
import br.com.linceit.stella.dto.UsuarioLogado;
import br.com.linceit.stella.exception.BOException;

public class LoginBO {
	
	private Logger logger = Logger.getLogger(LoginBO.class.getName());
	
	private static LoginBO loginBo;

	private CadastroBO cadastroBO;
	
	private LoginBO() {
		cadastroBO = new CadastroBO();
	}
	
	public static LoginBO getInstance() {
		if(loginBo == null) {
			loginBo = new LoginBO();
		}
		return loginBo;
	}
	
	public UsuarioLogado logar(String email, String senha) throws BOException {
		if(email != null && senha != null && !email.isEmpty() && !senha.isEmpty()) {
			try {
				UsuarioLogado usuarioLogado = null;
				TipoCadastro tipoCadastro = cadastroBO.verificaTipoCadastro(email);
				if(tipoCadastro == TipoCadastro.ADMIN) {
					Administrador administrador = cadastroBO.buscaAdministrador(email, senha);
					if(administrador != null) {
						usuarioLogado = new UsuarioLogado(administrador.getCdAdmin(),
								administrador.getNome(), TipoCadastro.ADMIN);
						return usuarioLogado;
					}
					
					throw new BOException("Nome de usuário e/ou senha inválidos");
				} else if(tipoCadastro == TipoCadastro.ALUNO) {
					Aluno aluno = cadastroBO.buscaAluno(email, senha);
					if(aluno != null) {
						usuarioLogado = new UsuarioLogado(aluno.getRm(),
								aluno.getNome(), TipoCadastro.ALUNO);
						return usuarioLogado;
					}
					
					throw new BOException("Nome de usuário e/ou senha inválidos");
				} else {
					throw new BOException("Nome de usuário e/ou senha inválidos");
				}
			} catch (Exception e) {
				logger.log(Level.SEVERE, e.getLocalizedMessage());
				throw new BOException("Ocorreu um imprevisto");
			}
		} else {
			throw new BOException("Nome de usuário e/ou senha inválidos");
		}
	}
}
