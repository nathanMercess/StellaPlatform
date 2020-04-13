package br.com.linceit.stella.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.linceit.stella.bean.Conteudo;
import br.com.linceit.stella.bean.Matricula;
import br.com.linceit.stella.dao.ConteudoDAO;
import br.com.linceit.stella.dto.ConteudoProgressao;
import br.com.linceit.stella.exception.ProblemaInternoException;

public class ConteudoBO {
	
	private static ConteudoBO instance;
	private ConteudoDAO conteudoDAO;
	private MatriculaBO matriculaBO = MatriculaBO.getInstance();
	
	private ConteudoBO() {
		conteudoDAO = new ConteudoDAO();
	}
	
	public static ConteudoBO getInstance() {
		if(instance == null) {
			instance = new ConteudoBO();
		}
		
		return instance;
	}
	
	public List<ConteudoProgressao> listaConteudoComProgressaoAluno(int rmAluno, int cdDisciplina) {
		
		try {
			Matricula matricula = matriculaBO.buscaMatricula(rmAluno, cdDisciplina);
			if(matricula != null) {
				System.out.println("Carregando conteudo com progressao");
				return conteudoDAO.listaConteudoComProgressao(matricula.getCdMatricula(), cdDisciplina);
			} else {
				return new ArrayList<>();
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return new ArrayList<>();
	}
	
	public List<Conteudo> listaConteudo(int codigoDisciplina) throws ProblemaInternoException {
		List<Conteudo> conteudos;
		try {
			conteudos = conteudoDAO.listaConteudo(codigoDisciplina);
		} catch (Exception e) {
			throw new ProblemaInternoException(e.getLocalizedMessage());
		}
		
		return conteudos;
	}

	public void salvarConteudo(Conteudo conteudo) throws ProblemaInternoException {
		try {
			conteudoDAO.salvarConteudo(conteudo);
		} catch (Exception e) {
			throw new ProblemaInternoException(e.getLocalizedMessage());
		}
	}
	
	
}
