package br.com.linceit.stella.teste;

import java.util.Date;

import br.com.linceit.stella.bean.Administrador;
import br.com.linceit.stella.bean.Aluno;
import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.bean.Matricula;
import br.com.linceit.stella.bo.AdministradorBO;
import br.com.linceit.stella.bo.AlunoBO;
import br.com.linceit.stella.bo.CadastroBO;
import br.com.linceit.stella.bo.DisciplinaBO;
import br.com.linceit.stella.bo.MatriculaBO;
import br.com.linceit.stella.dao.CleanerDAO;
import br.com.linceit.stella.database.DBFactory;
import br.com.linceit.stella.database.DBType;

public class TesteMatricula {
	
	public static void main(String[] args) throws Exception {
		DBFactory.setupConfig(DBType.NON_DS);
		// limpando tabelas para testes
		new CleanerDAO().clearAllTables();
		// tabelas limpas com sucesso
		
		Administrador novoAdmin = new Administrador();
		//novoAdmin.setCdAdmin(1);
		novoAdmin.setNome("admin");
		novoAdmin.setSenha("churros");
		novoAdmin.setEmail("linceit2019@gmail.com");
		
		// Criando administrador
		AdministradorBO administradorBO = new AdministradorBO();
		administradorBO.salvarAdministrador(novoAdmin);
		
		CadastroBO cadastroBO = new CadastroBO();
		Administrador administrador = cadastroBO.buscaAdministrador(novoAdmin.getEmail(), novoAdmin.getSenha());
		Disciplina disciplina = new Disciplina();
		//disciplina.setCdDisciplina(1);
		disciplina.setAdministrador(administrador);
		disciplina.setAtiva(true);
		disciplina.setDtAbertura(new Date(System.currentTimeMillis()));
		disciplina.setDtEncerramento(new Date(0l));
		disciplina.setNome("PORTUGUES");
		// Salvando disciplina de portugues
		new DisciplinaBO().salvarDisciplina(disciplina, null);
		
		// Criando aluno
		Aluno novoAluno = new Aluno();
		//novoAluno.setRm(1);
		novoAluno.setNome("guilherme");
		novoAluno.setSenha("1234");
		novoAluno.setEmail("guilherme@gmail.com");
		novoAluno.setEndereco("Rua Guilherme, 22");
		novoAluno.setTelefone(1133434455);
		novoAluno.setDtNascimento(new Date(System.currentTimeMillis()-1000*60*60*24*30*360*22));
		new AlunoBO().salvarAluno(novoAluno);
		
		Aluno aluno = cadastroBO.buscaAluno(novoAluno.getEmail(), novoAluno.getSenha());
		
		// Salvando matricula
		Matricula novaMatricula = new Matricula(aluno, new DisciplinaBO().listaDisciplina().get(0));
		novaMatricula.setCdMatricula(1);
		novaMatricula.setAberta(true);
		
		MatriculaBO.getInstance().registrarMatricula(novaMatricula);
	}
	
}
