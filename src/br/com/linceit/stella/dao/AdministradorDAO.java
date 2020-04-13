package br.com.linceit.stella.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import br.com.linceit.stella.bean.Administrador;

public class AdministradorDAO extends DAO {
	
	public int salvarAdmin(Administrador admin) throws Exception {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO T_SPS_ADMINISTRADOR"
				+ "(CD_ADM,"
				+ "NM_ADMINISTRADOR,"
				+ "DS_EMAIL,"
				+ "DS_SENHA,"
				+ "CD_RECUPERACAO,"
				+ "DT_RECUPERACAO,"
				+ "VL_UTILIZADO) VALUES(T_SPS_ADMINISTRADOR_SEQ.NEXTVAL,?,?,?,?,?,?)");
		//ps.setInt(1, admin.getCdAdmin());
		ps.setString(1, admin.getNome());
		ps.setString(2, admin.getEmail());
		ps.setString(3, admin.getSenha());
		ps.setString(4, "SEM_CODIGO");
		ps.setDate(5, new java.sql.Date(new Date(0L).getTime()));
		ps.setBoolean(6, false);
		
		return ps.executeUpdate();
	}
	
	public Boolean existeAdmin() throws Exception {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM T_SPS_ADMINISTRADOR");
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	public Boolean existeAdmin(Integer cdAdmin) throws Exception {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM T_SPS_ADMINISTRADOR WHERE CD_ADM = ?");
		ps.setInt(1, cdAdmin);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	public Boolean existeAdmin(String email) throws Exception {
		PreparedStatement ps = conn.prepareStatement("select CD_ADM from T_SPS_ADMINISTRADOR where DS_EMAIL=?");
		ps.setString(1, email);
		return ps.executeQuery().next();
	}

	public Administrador buscaAdministrador(String email, String senha) throws Exception {
		PreparedStatement ps = conn.prepareStatement("select CD_ADM,NM_ADMINISTRADOR from T_SPS_ADMINISTRADOR"
				+ " where LOWER(DS_EMAIL)=? AND DS_SENHA=?");
		ps.setString(1, email.toLowerCase());
		ps.setString(2, senha);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Administrador admin = new Administrador(rs.getInt("CD_ADM"), rs.getString("NM_ADMINISTRADOR"));
			return admin;
		} else {
			return null;
		}
	}
}
