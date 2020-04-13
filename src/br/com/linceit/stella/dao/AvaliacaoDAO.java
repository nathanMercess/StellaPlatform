package br.com.linceit.stella.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.linceit.stella.bean.Avaliacao;
import br.com.linceit.stella.bean.Disciplina;

public class AvaliacaoDAO extends DAO {

	private PreparedStatement stmt;
	
	public int cadastrarAvaliacao(Avaliacao ava) throws Exception {
		stmt = conn.prepareStatement(
				"INSERT INTO T_SPS_AVALIACAO(cd_avaliacao, ds_titulo, nr_qtde_questao, cd_disciplina)"
				+ " VALUES (t_sps_avaliacao_seq.nextval, ?, ?, ?)", new String[] {"cd_avaliacao"});
		//stmt.setInt(1, ava.getCdAvaliacao());
		stmt.setString(1, ava.getTitulo());
		stmt.setInt(2, ava.getQtdeQuestao());
		stmt.setInt(3, ava.getDisciplina().getCdDisciplina());
		
		if(stmt.executeUpdate() == 0) {
			throw new SQLException("Creating failed, no rows affected.");
		}
		
		ResultSet generatedKeys = stmt.getGeneratedKeys();
		if(generatedKeys.next()) {
			return (int) generatedKeys.getLong(1);
		}
		
		return 0;
	}
	
	
	public int deleteAvaliacao(int codigo) throws Exception {
		stmt = conn.prepareStatement("Delete from T_SPS_AVALIACAO WHERE cd_avaliacao = ?");
		stmt.setInt(1, codigo);
		return stmt.executeUpdate();
	}
	
	public int updateAvalicao(Avaliacao avaliacao) throws Exception {
		stmt = conn.prepareStatement(
				"UPDATE T_SPS_AVALIACAO SET nr_qtde_questao = ?, ds_titulo =? WHERE cd_avaliacao = ?");
		stmt.setInt(1, avaliacao.getQtdeQuestao());
		stmt.setString(2, avaliacao.getTitulo());
		stmt.setInt(3, avaliacao.getDisciplina().getCdDisciplina());
		stmt.setInt(4, avaliacao.getCdAvaliacao());
		return stmt.executeUpdate();
	}
	
	public Avaliacao buscaAvaliacao(int cdAvaliacao) throws Exception {
		stmt = conn.prepareStatement("SELECT * FROM T_SPS_AVALIACAO WHERE CD_AVALIACAO=?");
		stmt.setInt(1, cdAvaliacao);
		ResultSet resultSet = stmt.executeQuery();
		if (resultSet.next()) {
			Avaliacao av = new Avaliacao();
			av.setCdAvaliacao(resultSet.getInt(1));
			av.setTitulo(resultSet.getString(2));
			av.setQtdeQuestao(resultSet.getInt(3));
			av.setDisciplina(new Disciplina(resultSet.getInt(4)));
			return av;
		}
		
		return null;
	}
	
	public List<Avaliacao> buscaAvaliacoes(int cdDisciplina) throws Exception {
		stmt = conn.prepareStatement("SELECT * FROM T_SPS_AVALIACAO WHERE CD_DISCIPLINA=?");
		stmt.setInt(1, cdDisciplina);
		return cursorParaListaAvaliacao(stmt.executeQuery());
	}

	public List<Avaliacao> buscaAvaliacoes() throws Exception {
		stmt = conn.prepareStatement("SELECT * FROM T_SPS_AVALIACAO");
		return cursorParaListaAvaliacao(stmt.executeQuery());
	}

	private List<Avaliacao> cursorParaListaAvaliacao(ResultSet resultSet) throws Exception {
		List<Avaliacao> avaliacoes = new ArrayList<>();
		while (resultSet.next()) {
			Avaliacao av = new Avaliacao();
			av.setCdAvaliacao(resultSet.getInt(1));
			av.setTitulo(resultSet.getString(2));
			av.setQtdeQuestao(resultSet.getInt(3));
			av.setDisciplina(new Disciplina(resultSet.getInt(4)));
			avaliacoes.add(av);
		}

		return avaliacoes;
	}
}
