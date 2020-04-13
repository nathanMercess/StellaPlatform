package br.com.linceit.stella.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.linceit.stella.bean.Questao;

public class QuestaoDAO extends DAO {
	
	public int salvarQuestao(Questao q) throws Exception {
		PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO T_SPS_QUESTAO(CD_QUESTAO,DS_QUESTAO,DS_A,DS_B,DS_C,DS_D,VL_ALTERNATIVA_CORRETA,VL_DIFICULDADE)"
				+ " VALUES(T_SPS_QUESTAO_SEQ.NEXTVAL,?,?,?,?,?,?,?)", new String[] {"cd_questao"});
		//ps.setInt(1, q.getCdQuestao());
		ps.setString(1, q.getDescricao());
		ps.setString(2, q.getRespostaA());
		ps.setString(3, q.getRespostaB());
		ps.setString(4, q.getRespostaC());
		ps.setString(5, q.getRespostaD());
		ps.setString(6, q.getCorreta());
		ps.setInt(7, q.getDificuldade());
		
		if(ps.executeUpdate() == 0) {
			throw new SQLException("Problema ao salvar questão");
		}
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()) {
			return (int) rs.getLong(1);
		}
		
		return 0;
	}
	
	public int removerQuestao(int codigoQuestao) throws Exception {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM T_SPS_QUESTAO WHERE CD_QUESTAO=?");
		ps.setInt(1, codigoQuestao);
		return ps.executeUpdate();
	}
	
	public int atualizarQuestao(Questao q) throws Exception {
		PreparedStatement ps = conn
				.prepareStatement("UPDATE T_SPS_QUESTAO SET " + "DS_QUESTAO=?," + "DS_A=?," + "DS_B=?," + "DS_C=?,"
						+ "DS_D=?," + "VL_ALTERNATIVA_CORRETA=?," + "VL_DIFICULDADE=? WHERE CD_QUESTAO=?");
		ps.setString(1, q.getDescricao());
		ps.setString(2, q.getRespostaA());
		ps.setString(3, q.getRespostaB());
		ps.setString(4, q.getRespostaC());
		ps.setString(5, q.getRespostaD());
		ps.setString(6, q.getCorreta());
		ps.setInt(7, q.getDificuldade());
		ps.setInt(8, q.getCdQuestao());
		return ps.executeUpdate();
	}
	
	public List<Questao> buscaQuestoes() throws Exception {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM T_SPS_QUESTAO");
		ResultSet rs = ps.executeQuery();
		
		List<Questao> questoes = new ArrayList<>();
		
		while(rs.next()) {
			Questao q = new Questao();
			q.setCdQuestao(rs.getInt(1));
			q.setDescricao(rs.getString(2));
			q.setRespostaA(rs.getString(3));
			q.setRespostaB(rs.getString(4));
			q.setRespostaC(rs.getString(5));
			q.setRespostaD(rs.getString(6));
			q.setCorreta(rs.getString(7));
			q.setDificuldade(rs.getInt(8));
			questoes.add(q);
		}
		
		return questoes;
	}
	
	public String getRespostaCorreta(int cdQuestao) throws Exception {
		PreparedStatement ps = conn.prepareStatement("SELECT VL_ALTERNATIVA_CORRETA FROM T_SPS_QUESTAO WHERE CD_QUESTAO=?");
		ps.setInt(1, cdQuestao);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getString(1);
		}
		return "";
	}
}
