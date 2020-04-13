package br.com.linceit.stella.teste;

import java.util.Date;
import java.util.List;

import br.com.linceit.stella.bean.Administrador;
import br.com.linceit.stella.bean.Aluno;
import br.com.linceit.stella.bean.Conteudo;
import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.bean.Matricula;
import br.com.linceit.stella.bo.AdministradorBO;
import br.com.linceit.stella.bo.AlunoBO;
import br.com.linceit.stella.bo.CadastroBO;
import br.com.linceit.stella.bo.DisciplinaBO;
import br.com.linceit.stella.bo.MatriculaBO;
import br.com.linceit.stella.dao.CleanerDAO;
import br.com.linceit.stella.dao.ConteudoDAO;
import br.com.linceit.stella.dao.DisciplinaDAO;
import br.com.linceit.stella.database.DBFactory;
import br.com.linceit.stella.database.DBType;

public class TesteDisciplinas {
	
	public static void main(String[] args) throws Exception {
		DBFactory.setupConfig(DBType.NON_DS);
		// limpando tabelas para testes
		new CleanerDAO().clearAllTables();
		// tabelas limpas com sucesso
		/*ConteudoDAO conteudoDAO = new ConteudoDAO();
		List<Conteudo> listaConteudo = conteudoDAO.listaConteudo(72);
		for(Conteudo c : listaConteudo) {
			System.out.println(c.getLocalDoc());
		}*/
	}
	
}
