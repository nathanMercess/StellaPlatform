package br.com.linceit.stella.dao;

import java.sql.PreparedStatement;

import br.com.linceit.stella.bean.Progressao;

public class ProgressaoDAO extends DAO {
	
	public int salvarProgressao(Progressao progressao) throws Exception {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO T_SPS_PROGRESSAO"
				+ "(CD_MATRICULA,CD_CONTEUDO,ST_CONCLUIDO,VL_AVALIACAO) "
				+ "VALUES ?,?,?,?");
		ps.setInt(1,progressao.getCdMatricula());
		ps.setInt(2,progressao.getCdConteudo());
		ps.setBoolean(3, progressao.getConcluido());
		ps.setInt(4, progressao.getAvaliacao());
		return ps.executeUpdate();
	}
	
	public int atualizarProgressao(Progressao progressao) throws Exception {
		PreparedStatement ps = conn.prepareStatement("UPDATE T_SPS_PROGRESSAO SET "
				+ "ST_CONCLUIDO=?,VL_AVALIACAO=? WHERE CD_MATRICULA=? AND CD_CONTEUDO=?");
		ps.setBoolean(1, progressao.getConcluido());
		ps.setInt(2, progressao.getAvaliacao());
		ps.setInt(3, progressao.getCdMatricula());
		ps.setInt(4, progressao.getCdConteudo());
		return ps.executeUpdate();
	}
}
