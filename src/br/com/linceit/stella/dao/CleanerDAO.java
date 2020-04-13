package br.com.linceit.stella.dao;

import java.sql.PreparedStatement;

// Somenta para testes inicias, remover futuramente
public class CleanerDAO extends DAO{
	
	public int clearAllTables() throws Exception {
		PreparedStatement ps;
		
		ps = conn.prepareStatement("DELETE FROM T_SPS_QUESTIONARIO_RESPONDIDO WHERE 1=1");
		ps.executeUpdate();
		
		ps = conn.prepareStatement("DELETE FROM T_SPS_QUESTAO WHERE 1=1");
		ps.executeUpdate();
		
		ps = conn.prepareStatement("DELETE FROM T_SPS_QUESTIONARIO WHERE 1=1");
		ps.executeUpdate();
		
		ps = conn.prepareStatement("DELETE FROM T_SPS_AVALIACAO WHERE 1=1");
		ps.executeUpdate();
				
		ps = conn.prepareStatement("DELETE FROM T_SPS_PROGRESSAO WHERE 1=1");
		ps.executeUpdate();
		
		
		ps = conn.prepareStatement("DELETE FROM T_SPS_MATRICULA WHERE 1=1");
		ps.executeUpdate();
		
		ps = conn.prepareStatement("DELETE FROM T_SPS_ALUNO WHERE 1=1");
		ps.executeUpdate();
		
		ps = conn.prepareStatement("DELETE FROM T_SPS_CONTEUDO WHERE 1=1");
		ps.executeUpdate();
		
		ps = conn.prepareStatement("DELETE FROM T_SPS_DISCIPLINA WHERE 1=1");
		ps.executeUpdate();
		
		ps = conn.prepareStatement("DELETE FROM T_SPS_ADMINISTRADOR WHERE 1=1");
		ps.executeUpdate();
		
		return 0;
	}

}
