package br.com.linceit.stella.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.linceit.stella.bean.Aluno;

public class AlunoDAO extends DAO {
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public int salvarAluno(Aluno aluno) throws Exception {
		stmt = conn.prepareStatement("INSERT INTO T_SPS_ALUNO "
				+ "(CD_RM,NM_ALUNO,DS_SENHA,DS_EMAIL,DT_NASC,DS_ENDERECO,NR_TELEFONE,CD_RECUPERACAO,DT_CRIACAO,VL_UTILIZADO)"
				+ " VALUES (T_SPS_ALUNO_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)");
		//stmt.setInt(1, aluno.getRm());
		stmt.setString(1, aluno.getNome());
		stmt.setString(2, aluno.getSenha());
		stmt.setString(3, aluno.getEmail());
		stmt.setDate(4, new java.sql.Date(aluno.getDtNascimento().getTime()));
		stmt.setString(5, aluno.getEndereco());
		stmt.setInt(6, aluno.getTelefone());
		stmt.setString(7, aluno.getCdRecuperacao());
		stmt.setDate(8, new java.sql.Date(System.currentTimeMillis()));
		stmt.setBoolean(9, false);
		return stmt.executeUpdate();
	}
	
	public int excluirAluno(int codigo) throws Exception  {
		stmt = conn.prepareStatement("DELETE FROM T_SPS_ALUNO WHERE CD_RM = ?");
		stmt.setInt(1, codigo);
		return stmt.executeUpdate();
	}
	
	public Aluno buscarAluno(int rm) throws Exception  {
		stmt = conn.prepareStatement("SELECT * FROM T_SPS_ALUNO WHERE CD_RM = ? ");
		stmt.setInt(1, rm);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Aluno aluno = new Aluno();
			aluno.setRm(rs.getInt("CD_RM"));
			aluno.setNome(rs.getString("NM_ALUNO"));
			aluno.setSenha(rs.getString("DS_SENHA"));
			aluno.setEmail(rs.getString("DS_EMAIL"));
			aluno.setDtNascimento(rs.getDate("DT_NASC"));
			aluno.setEndereco(rs.getString("DS_ENDERECO"));
			aluno.setTelefone(rs.getInt("NR_TELEFONE"));
			aluno.setCdRecuperacao(rs.getString("CD_RECUPERACAO"));
			aluno.setDtCriacao(rs.getDate("DT_CRIACAO"));
			aluno.setCdRecuperacaoUtilizado(rs.getBoolean("VL_UTILIZADO"));
			return aluno;
		}else {
			return null;
		}
	}
	
	public Boolean existeAluno(String email) throws Exception {
		PreparedStatement ps = conn.prepareStatement("select CD_RM from T_SPS_ALUNO where LOWER(DS_EMAIL)=?");
		ps.setString(1, email.toLowerCase());
		return ps.executeQuery().next();
	}
	
	public Aluno buscaAluno(String email, String senha) throws Exception {
		PreparedStatement ps = conn.prepareStatement("select CD_RM,NM_ALUNO from T_SPS_ALUNO"
				+ " where LOWER(DS_EMAIL)=? AND DS_SENHA=?");
		ps.setString(1, email.toLowerCase());
		ps.setString(2, senha);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Aluno aluno = new Aluno(rs.getInt("CD_RM"), rs.getString("NM_ALUNO"));
			return aluno;
		} else {
			return null;
		}
	}

	public int atualizarAluno(Aluno aluno) throws Exception {
		stmt = conn.prepareStatement("UPDATE T_SPS_ALUNO SET "
				+ "DS_SENHA=?,"
				+ "DS_EMAIL=?,"
				+ "DT_NASC=?,"
				+ "DS_ENDERECO=?,"
				+ "NR_TELEFONE=?,"
				+ "CD_RECUPERACAO=?,"
				+ "DT_CRIACAO=?,"
				+ "VL_UTILIZADO=? where CD_RM=?");
		
		stmt.setString(1, aluno.getSenha());
		stmt.setString(2, aluno.getEmail());
		stmt.setDate(3, new java.sql.Date(aluno.getDtNascimento().getTime()));
		stmt.setString(4, aluno.getEndereco());
		stmt.setInt(5, aluno.getTelefone());
		stmt.setString(6, aluno.getCdRecuperacao());
		stmt.setDate(7, new java.sql.Date(aluno.getDtCriacao().getTime()));
		stmt.setBoolean(8, aluno.isCdRecuperacaoUtilizado());
		stmt.setInt(9, aluno.getRm());
		return stmt.executeUpdate();
	}
}