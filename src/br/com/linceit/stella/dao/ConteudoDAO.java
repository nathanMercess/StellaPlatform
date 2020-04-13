package br.com.linceit.stella.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.linceit.stella.bean.Conteudo;
import br.com.linceit.stella.bean.Matricula;
import br.com.linceit.stella.dto.ConteudoProgressao;

public class ConteudoDAO extends DAO{
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public void close() throws Exception {
		conn.close();
	}
	
	public int salvarConteudo (Conteudo conteudo) throws Exception{
		stmt = conn.prepareStatement("INSERT INTO T_SPS_CONTEUDO VALUES(T_SPS_CONTEUDO_SEQ.NEXTVAL,?,?,?)");
	
		//stmt.setInt(1, conteudo.getCdConteudo());
		stmt.setInt(1, conteudo.getDisciplina().getCdDisciplina());
		stmt.setString(2, conteudo.getNome());
		stmt.setString(3, conteudo.getLocalDoc());
		
		return stmt.executeUpdate();
	}
	public int  exluirConteudo(Conteudo conteudo) throws Exception{
		stmt = conn.prepareStatement("DELETE FROM T_SPS_CONTEUDO WHERE CD_CONTEUDO = ?");
		
		stmt.setInt(1, conteudo.getCdConteudo()); 
		return stmt.executeUpdate();
	}
	
	public int editarConteudo(Conteudo conteudo) throws Exception{
		stmt = conn.prepareStatement("UPDATE T_SPS_CONTEUDO WHERE CD_CONTEUDO =?, CD_DISCIPLINA = ?, NM_CONTEUDO=?, DS_LOCAL_DOC = ? ");
		stmt.setInt(1, conteudo.getCdConteudo());
		stmt.setInt(2, conteudo.getDisciplina().getCdDisciplina());
		stmt.setString(3, conteudo.getNome());
		stmt.setString(4, conteudo.getLocalDoc());
		return stmt.executeUpdate();
	}
	
	public Conteudo buscarConteudo(int codigo) throws Exception{
		stmt = conn.prepareStatement("SELECT * FROM T_SPS_CONTEUDO WHERE CD_CONTEUDO = ?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			Conteudo conteudo = new Conteudo();
			conteudo.setCdConteudo(rs.getInt("CD_CONTEUDO"));
			conteudo.setNome(rs.getString("NM_CONTEUDO"));
			conteudo.setLocalDoc(rs.getString("DS_LOCAL_DOC"));
			return conteudo;
		
		} else {
			return new Conteudo();
		}
	}
	
	public List<ConteudoProgressao> listaConteudoComProgressao(int cdMatricula, int cdDisciplina) throws Exception {
		stmt = conn.prepareStatement("SELECT C.NM_CONTEUDO,C.CD_CONTEUDO,P.ST_CONCLUIDO FROM T_SPS_CONTEUDO C"
				+ " LEFT JOIN T_SPS_PROGRESSAO P ON C.CD_CONTEUDO=P.CD_CONTEUDO AND P.CD_MATRICULA = ?"
				+ " WHERE C.CD_DISCIPLINA=?");
		
		stmt.setInt(1, cdMatricula);
		stmt.setInt(2, cdDisciplina);
		
		rs = stmt.executeQuery();
		List<ConteudoProgressao> lista = new ArrayList<>();
		while(rs.next()) {
			lista.add(new ConteudoProgressao(rs.getString(1), rs.getInt(2), rs.getBoolean(3)));
		}
		
		return lista;
	}
	
	public List<Conteudo> listaConteudo(int codigoDisciplina) throws Exception {
		stmt = conn.prepareStatement("SELECT C.CD_CONTEUDO,C.NM_CONTEUDO,C.DS_LOCAL_DOC FROM T_SPS_CONTEUDO C WHERE C.CD_DISCIPLINA=?");
		stmt.setInt(1, codigoDisciplina);
		
		rs = stmt.executeQuery();
		List<Conteudo> conteudos = new ArrayList<>();
		while(rs.next()) {
			Conteudo conteudo = new Conteudo();
			conteudo.setCdConteudo(rs.getInt(1));
			conteudo.setNome(rs.getString(2));
			conteudo.setLocalDoc(rs.getString(3));
			conteudos.add(conteudo);
		}
		
		return conteudos;
	}
	
}
