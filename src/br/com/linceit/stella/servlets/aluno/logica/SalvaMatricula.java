package br.com.linceit.stella.servlets.aluno.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Aluno;
import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.bean.Matricula;
import br.com.linceit.stella.bo.ConteudoBO;
import br.com.linceit.stella.bo.MatriculaBO;
import br.com.linceit.stella.dao.DisciplinaDAO;
import br.com.linceit.stella.dto.ConteudoProgressao;
import br.com.linceit.stella.dto.DisciplinaComStatusMatricula;
import br.com.linceit.stella.dto.UsuarioLogado;
import br.com.linceit.stella.exception.BOException;
import br.com.linceit.stella.exception.EntidadeNaoEncontradaException;
import br.com.linceit.stella.servlets.Logica;

public class SalvaMatricula implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		UsuarioLogado aluno = (UsuarioLogado) req.getSession().getAttribute("usuario");
		int cdMatricula = Integer.valueOf(req.getParameter("cdMatricula"));
		int cdDisciplina = Integer.valueOf(req.getParameter("cdDisciplina"));
		boolean ativar = Boolean.parseBoolean(req.getParameter("ativa"));
		
		System.out.println("RM ALUNO:"+aluno.getIdentificador());
		System.out.println("CD DISC:"+ req.getParameter("cdDisciplina"));
		System.out.println("CD MATRIC:"+ req.getParameter("cdMatricula"));
		System.out.println("ATIVA:"+req.getParameter("ativa"));
		
		MatriculaBO matriculaBO = MatriculaBO.getInstance();
		
		if(ativar) {
			if(cdMatricula == 0) {
				Matricula matricula = new Matricula(new Aluno(aluno.getIdentificador()), new Disciplina(cdDisciplina));
				try {
					matriculaBO.registrarMatricula(matricula);
				} catch (EntidadeNaoEncontradaException e) {
					System.out.println(e.getLocalizedMessage());
				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
			} else {
				try {
					matriculaBO.abrirMatricula(cdMatricula);
				} catch (BOException e) {
					System.out.println(e.getLocalizedMessage());
				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
			}
		} else {
			try {
				matriculaBO.trancarMatricula(cdMatricula);
			} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			}
		}
		
		return "/aluno?action=GerenciarDisciplinas";
	}
	
}
