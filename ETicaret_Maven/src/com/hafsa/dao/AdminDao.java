package com.hafsa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.hafsa.model.Admin;
import com.hafsa.model.Yetki;

public class AdminDao {
	private static Connection con=null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Admin> tumAdminler() throws SQLException {
		ArrayList<Admin> adminler = new ArrayList<Admin>();
		String sql = "SELECT A.adminid, A.adminad , A.adminsoyad,A.tcno, A.eposta , A.parola, Y.yetkiad "
				+ "FROM tbl_admin AS A INNER JOIN tbl_yetki AS Y ON A.yetkino = Y.yetkino;";
		try {
			con = ConDatabase.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminid(rs.getInt("adminid"));
				admin.setAdminad(rs.getString("adminad"));
				admin.setAdminsoyad(rs.getString("adminsoyad"));
				admin.setTcno(rs.getString("tcno"));
				admin.setEposta(rs.getString("eposta"));
				admin.setParola(rs.getString("parola"));
				admin.setYetkino(new Yetki(rs.getString("yetkiad")));
				adminler.add(admin);
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConDatabase.kapat(con, psmt, rs);
		}
		return adminler;
	}
	
	
	public static boolean adminEkle(Admin admin) throws SQLException {
		boolean state=false;
		String sql = "INSERT INTO tbl_admin ( adminad, adminsoyad, tcno,eposta, parola, yetkino) VALUES (?,?, ?, ?, ?, ?)";
		try {
			con = ConDatabase.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1,admin.getAdminad());
			psmt.setString(2,admin.getAdminsoyad());
			psmt.setString(3,admin.getTcno());
			psmt.setString(4,admin.getEposta());
			psmt.setString(5,admin.getParola());
			psmt.setInt(6,admin.getYetkino().getYetkino());
			
			if(psmt.executeUpdate()>0){
				state=true;
			}
			
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConDatabase.kapat(con, psmt);
		}
		return state;
	}
	
	
	public static boolean adminsil(Admin admin){
		boolean state=false;
		String sql="delete from tbl_admin where adminid = ?";
		try {
			
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,admin.getAdminid());
			
			if(psmt.executeUpdate()>0){
				state=true;
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDatabase.kapat(con, psmt);
		}	
		return state;
	}
	
	public static boolean adminSifreGuncelle(Admin admin) throws SQLException {
		boolean state = false;
		String sql = "UPDATE tbl_admin Set parola =? WHERE adminid = ?";
		try {
			con = ConDatabase.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, admin.getParola());
			psmt.setInt(2, admin.getAdminid());
			
			if(psmt.executeUpdate()>0){
				state=true;
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConDatabase.kapat(con, psmt);
		}
		return state;
	}
	
	public static boolean adminEpostaGuncelle(Admin admin) throws SQLException {
		boolean state=false;
		String sql = "UPDATE tbl_admin Set eposta = ? WHERE (adminid = ?)";
		try {
			con = ConDatabase.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, admin.getEposta());
			psmt.setInt(2, admin.getAdminid());
			if(psmt.executeUpdate()>0){
				state=true;
			}
			
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConDatabase.kapat(con, psmt);
		}
		return state;
	}
	

	public static Admin admincontrol(Admin _admin){
		Admin admin=null;
		String sql="select * from tbl_admin where tcno=? and parola=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,_admin.getTcno());
			psmt.setString(2,_admin.getParola());
			rs=psmt.executeQuery();
			if(rs.next()){
				admin=new Admin();
				admin.setAdminid(rs.getInt(1));
				admin.setAdminad(rs.getString(2));
				admin.setAdminsoyad(rs.getString(3));
				admin.setTcno(rs.getString(4));
				admin.setEposta(rs.getString(5));
				admin.setParola(rs.getString(6));
				admin.setYetkino(new Yetki(rs.getString(7)));
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDatabase.kapat(con, psmt, rs);
		}
		return admin;
				
	}
	
	public static boolean siparisBeklemeVarMi() throws SQLException{
		boolean bekleyen = false;
		String sql = "SELECT * FROM tbl_siparis where teslimtarih is null;";
		try {
			con = ConDatabase.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next())
				bekleyen = true;
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConDatabase.kapat(con, psmt);
		}
		return bekleyen;
	}
	
	
	
	
}
