package br.com.linceit.stella.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.linceit.stella.bean.Aluno;
import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.bean.Matricula;

public class MatriculaDAO extends DAO {
		
	public int salvarMatricula(Matricula matricula) throws Exception {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO T_SPS_MATRICULA(CD_MATRICULA,CD_RM,CD_DISCIPLINA,DT_MATRICULA,ST_SITUACAO)"
				+ " VALUES(T_SPS_MATRICULA_SEQ.NEXTVAL,?,?,?,?)");
		//ps.setInt(1, matricula.getCdMatricula());
		ps.setInt(1, matricula.getAluno().getRm());
		ps.setInt(2, matricula.getDisciplina().getCdDisciplina());
		ps.setDate(3, new java.sql.Date(matricula.getDtMatricula().getTime()));
		ps.setBoolean(4, matricula.isAberta());
		return ps.executeUpdate();
	}
	
	public int atualizarStatusMatricula(int codigoMatricula, boolean statusAberta) throws Exception {
		PreparedStatement ps = conn.prepareStatement("UPDATE T_SPS_MATRICULA SET "
				+ "ST_SITUACAO=? where CD_MATRICULA=?");
		ps.setBoolean(1, statusAberta);
		ps.setInt(2, codigoMatricula);
		return ps.executeUpdate();
	}
	
	public List<Matricula> buscaMatriculas(Aluno aluno) throws Exception {
		PreparedStatement ps 
		= conn.prepareStatement("SELECT M.CD_MATRICULA,M.DT_MATRICULA,M.ST_SITUACAO,D.CD_DISCIPLINA"
				+ " FROM T_SPS_MATRICULA M"
				+ " INNER JOIN T_SPS_DISCIPLINA D ON M.CD_DISCIPLINA = D.CD_DISCIPLINA"
				+ " WHERE M.CD_RM = ?");
		ps.setInt(1, aluno.getRm());
		ResultSet rs = ps.executeQuery();
		List<Matricula> matriculas = new ArrayList<Matricula>();
		while(rs.next()) {
			//Preenche aluno carregado na matricula
			Matricula matricula = new Matricula();
			matricula.setAluno(aluno);
			matricula.setDisciplina(new Disciplina(rs.getInt(4)));
			matricula.setCdMatricula(rs.getInt(1));
			matricula.setDtMatricula(rs.getDate(2));
			matricula.setAberta(rs.getBoolean(3));
			matriculas.add(matricula);
		}
		
		return matriculas;
	}

	public Matricula buscaMatricula(int rmAluno, int cdDisciplina) throws Exception {
		
		PreparedStatement ps 
		= conn.prepareStatement("SELECT M.CD_MATRICULA FROM T_SPS_MATRICULA M"
				+ " WHERE M.CD_RM = ? AND M.CD_DISCIPLINA = ?");
		ps.setInt(1, rmAluno);
		ps.setInt(2, cdDisciplina);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return new Matricula(rs.getInt(1));
		}
		
		return null;
	}
}
