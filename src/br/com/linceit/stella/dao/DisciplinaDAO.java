package br.com.linceit.stella.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.dto.DisciplinaComStatusMatricula;

public class DisciplinaDAO extends DAO {

	public Disciplina buscarDisciplina(int cdDisciplina) throws Exception {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM T_SPS_DISCIPLINA where cd_disciplina=?");
		ps.setInt(1, cdDisciplina);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Disciplina disciplina = new Disciplina();
			disciplina.setCdDisciplina(rs.getInt("CD_DISCIPLINA"));
			disciplina.setNome(rs.getString("NM_DISCIPLINA"));
			disciplina.setDtAbertura(rs.getDate("DT_ABERTURA"));
			disciplina.setDtEncerramento(rs.getDate("DT_ENCERRAMENTO"));
			disciplina.setAtiva(rs.getBoolean("VL_STATUS_ATIVA"));
			return disciplina;
		} else {
			return null;
		}
	}
	
	public int salvarDisciplina(Disciplina disciplina) throws Exception {
//		PreparedStatement psSeq = conn.prepareStatement("SELECT T_SPS_DISCIPLINA_SEQ.NEXTVAL");
		//ResultSet rsSeq = psSeq.executeQuery();
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO T_SPS_DISCIPLINA"
				+ "(CD_DISCIPLINA,CD_ADM,NM_DISCIPLINA,DT_ABERTURA,DT_ENCERRAMENTO,VL_STATUS_ATIVA) VALUES "
				+ "(T_SPS_DISCIPLINA_SEQ.NEXTVAL,?,?,?,?,?)", new String[] {"CD_DISCIPLINA"});
		//ps.setInt(1, disciplina.getCdDisciplina());
		ps.setInt(1, disciplina.getAdministrador().getCdAdmin());
		ps.setString(2, disciplina.getNome());
		ps.setDate(3, new java.sql.Date(disciplina.getDtAbertura().getTime()));
		ps.setDate(4, new java.sql.Date(disciplina.getDtEncerramento().getTime()));
		ps.setBoolean(5, disciplina.isAtiva());
		
		if(ps.executeUpdate() == 0) {
			throw new SQLException("Creating failed, no rows affected.");
		}
		
		ResultSet generatedKeys = ps.getGeneratedKeys();
		if(generatedKeys.next()) {
			return (int) generatedKeys.getLong(1);
		}
		
		return 0;
	}
	
	public List<Disciplina> listaDisciplinas() throws Exception {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM T_SPS_DISCIPLINA WHERE VL_STATUS_ATIVA = 1");
		ResultSet rs = ps.executeQuery();
		List<Disciplina> disciplinas = new ArrayList<>();
		while(rs.next()) {
			Disciplina disciplina = new Disciplina();
			disciplina.setCdDisciplina(rs.getInt("CD_DISCIPLINA"));
			disciplina.setNome(rs.getString("NM_DISCIPLINA"));
			disciplina.setDtAbertura(rs.getDate("DT_ABERTURA"));
			disciplina.setDtEncerramento(rs.getDate("DT_ENCERRAMENTO"));
			disciplina.setAtiva(rs.getBoolean("VL_STATUS_ATIVA"));
			disciplinas.add(disciplina);
		}
		
		return disciplinas;
	}
	
	public List<Disciplina> listaDisciplinasAluno(Integer rm) throws Exception {
		PreparedStatement ps = conn.prepareStatement("SELECT D.*"
				+ " FROM T_SPS_DISCIPLINA D"
				+ " INNER JOIN T_SPS_MATRICULA M ON D.CD_DISCIPLINA = M.CD_DISCIPLINA"
				+ " WHERE M.CD_RM=? AND M.ST_SITUACAO=1");
		ps.setInt(1, rm);
		
		ResultSet rs = ps.executeQuery();
		List<Disciplina> disciplinas = new ArrayList<>();
		while(rs.next()) {
			Disciplina disciplina = new Disciplina();
			disciplina.setCdDisciplina(rs.getInt("CD_DISCIPLINA"));
			disciplina.setNome(rs.getString("NM_DISCIPLINA"));
			disciplina.setDtAbertura(rs.getDate("DT_ABERTURA"));
			disciplina.setDtEncerramento(rs.getDate("DT_ENCERRAMENTO"));
			disciplina.setAtiva(rs.getBoolean("VL_STATUS_ATIVA"));
			disciplinas.add(disciplina);
		}
		
		return disciplinas;
	}
	
	public int deletarDisciplina(int id) throws Exception {
		PreparedStatement ps = conn.prepareStatement("UPDATE T_SPS_DISCIPLINA SET VL_STATUS_ATIVA = 0 WHERE CD_DISCIPLINA=?");
		ps.setInt(1, id);
		return ps.executeUpdate();
	}
	
	public List<DisciplinaComStatusMatricula> listaDisciplinaComStatusMatricula(int cdAluno) throws Exception {
		PreparedStatement ps = conn.prepareStatement("SELECT D.NM_DISCIPLINA,D.CD_DISCIPLINA,M.CD_MATRICULA,M.ST_SITUACAO"
				+ " FROM T_SPS_DISCIPLINA D"
				+ " LEFT JOIN T_SPS_MATRICULA M ON D.CD_DISCIPLINA = M.CD_DISCIPLINA AND M.CD_RM=?");
		
		ps.setInt(1, cdAluno);
		ResultSet rs = ps.executeQuery();
		
		List<DisciplinaComStatusMatricula> disciplinas = new ArrayList<>();
		while(rs.next()) {
			DisciplinaComStatusMatricula disciplinaComStatusMatricula = new DisciplinaComStatusMatricula();
			disciplinaComStatusMatricula.setNomeDisciplina(rs.getString(1));
			disciplinaComStatusMatricula.setCdDisciplina(rs.getInt(2));
			disciplinaComStatusMatricula.setCdMatricula(rs.getInt(3));
			disciplinaComStatusMatricula.setAtiva(rs.getBoolean(4));
			disciplinas.add(disciplinaComStatusMatricula);
		}
		
		return disciplinas;
	}
}
