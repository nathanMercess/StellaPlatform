package br.com.linceit.stella.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.linceit.stella.bean.Questionario;
import br.com.linceit.stella.bean.QuestionarioRespondido;
import br.com.linceit.stella.dto.QuestionarioComResposta;
import br.com.linceit.stella.dto.QuestionarioSemResposta;

public class QuestionarioDAO extends DAO {

	private PreparedStatement stmt;
	
	public int salvarQuestionario(int cdAvaliacao, int cdQuestao) throws Exception {
		stmt = conn.prepareStatement(
				"INSERT INTO T_SPS_QUESTIONARIO(cd_avaliacao, cd_questao) VALUES (?,?)");
		stmt.setInt(1, cdAvaliacao);
		stmt.setInt(2, cdQuestao);
		
		return stmt.executeUpdate();
	}
	
	public int salvarQuestionarioRespondido(QuestionarioRespondido respondido) throws Exception {
		stmt = conn.prepareStatement("INSERT INTO T_SPS_QUESTIONARIO_RESPONDIDO(cd_matricula,cd_avaliacao,cd_questao,vl_resposta_correta,vl_resposta_aluno)"
				+ " VALUES (?,?,?,?,?)");
		stmt.setInt(1, respondido.getMatricula().getCdMatricula());
		stmt.setInt(2, respondido.getAvaliacao().getCdAvaliacao());
		stmt.setInt(3, respondido.getQuestao().getCdQuestao());
		stmt.setString(4, respondido.getRespostaCorreta());
		stmt.setString(5, respondido.getRespostaAluno());
		return stmt.executeUpdate();
	}
	
	public boolean alunoRealizouQuestionario(int cdMatricula, int cdAvaliacao) throws Exception {
		stmt = conn.prepareStatement("SELECT * FROM T_SPS_QUESTIONARIO_RESPONDIDO WHERE CD_MATRICULA=? AND CD_AVALIACAO=?");
		stmt.setInt(1, cdMatricula);
		stmt.setInt(2, cdAvaliacao);
		return stmt.executeQuery().next();
	}
	
	public List<QuestionarioSemResposta> listaQuestionarioSemResposta(int cdAvaliacao) throws Exception {
		stmt = conn.prepareStatement("SELECT QT.CD_QUESTAO,QT.CD_AVALIACAO,"
				+ "Q.DS_QUESTAO,Q.DS_A,Q.DS_B,Q.DS_C,Q.DS_D"
				+ " FROM T_SPS_QUESTIONARIO QT"
				+ " INNER JOIN T_SPS_QUESTAO Q ON QT.CD_QUESTAO = Q.CD_QUESTAO"
				+ " WHERE QT.CD_AVALIACAO=?");
		stmt.setInt(1, cdAvaliacao);
		
		ResultSet rs = stmt.executeQuery();
		
		List<QuestionarioSemResposta> lista = new ArrayList<>();
		while(rs.next()) {
			QuestionarioSemResposta q = new QuestionarioSemResposta();
			q.setCdQuestao(rs.getInt(1));
			q.setCdAvaliacao(rs.getInt(2));
			q.setPergunta(rs.getString(3));
			q.setRespostaA(rs.getString(4));
			q.setRespostaB(rs.getString(5));
			q.setRespostaC(rs.getString(6));
			q.setRespostaD(rs.getString(7));
			lista.add(q);
		}
		
		return lista;
	}
	
	public List<QuestionarioComResposta> listaQuestionarioComResposta(int cdAvaliacao, int cdMatricula) throws Exception {
		stmt = conn.prepareStatement("SELECT QT.CD_QUESTAO,QT.CD_AVALIACAO,"
				+ "Q.DS_QUESTAO,Q.DS_A,Q.DS_B,Q.DS_C,Q.DS_D,QR.VL_RESPOSTA_CORRETA, QR.VL_RESPOSTA_ALUNO"
				+ " FROM T_SPS_QUESTIONARIO QT"
				+ " INNER JOIN T_SPS_QUESTAO Q ON QT.CD_QUESTAO = Q.CD_QUESTAO"
				+ " INNER JOIN T_SPS_QUESTIONARIO_RESPONDIDO QR ON QR.CD_AVALIACAO = QT.CD_AVALIACAO AND QR.CD_QUESTAO = QT.CD_QUESTAO"
				+ " WHERE QT.CD_AVALIACAO=? AND QR.CD_MATRICULA=?");
		stmt.setInt(1, cdAvaliacao);
		stmt.setInt(2, cdMatricula);
		ResultSet rs = stmt.executeQuery();
		
		List<QuestionarioComResposta> lista = new ArrayList<>();
		while(rs.next()) {
			QuestionarioComResposta q = new QuestionarioComResposta();
			q.setCdQuestao(rs.getInt(1));
			q.setCdAvaliacao(rs.getInt(2));
			q.setPergunta(rs.getString(3));
			q.setRespostaA(rs.getString(4));
			q.setRespostaB(rs.getString(5));
			q.setRespostaC(rs.getString(6));
			q.setRespostaD(rs.getString(7));
			q.setRespostaCorreta(rs.getString(8));
			q.setRespostaAluno(rs.getString(9));
			lista.add(q);
		}
		
		return lista;
	}
}
