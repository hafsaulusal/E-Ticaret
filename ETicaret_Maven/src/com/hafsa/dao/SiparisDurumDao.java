package com.hafsa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hafsa.model.SiparisDurum;

public class SiparisDurumDao {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<SiparisDurum> tumsiparisdurum() throws SQLException {
		ArrayList<SiparisDurum> tumsiparisdurum = new ArrayList<SiparisDurum>();
		String sql = "Select * from tbl_siparisdurum order by siparisdurumid asc";
		try {
			con = ConDatabase.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				SiparisDurum siparisdurum=new SiparisDurum();
				siparisdurum.setSiparisdurumid(rs.getInt(1));
				siparisdurum.setDurum(rs.getString(2));
				tumsiparisdurum.add(siparisdurum);
			}
			con.close();
		} catch (final SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConDatabase.kapat(con, psmt, rs);
		}
		return tumsiparisdurum;
	}
	
	public static boolean siparisdurumekle(SiparisDurum siparisdurum) throws SQLException{
		boolean state=false;
		String sql="insert into tbl_siparisdurum(durum) values (?)";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,siparisdurum.getDurum());
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
	
	
	
	public static boolean siparisdurumsil(SiparisDurum siparisdurum) throws Exception{
		boolean state=false;
		String sql="delete from tbl_siparisdurum where siparisdurumid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,siparisdurum.getSiparisdurumid());
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
	
	public static boolean siparisdurumguncelle(SiparisDurum siparisdurum) throws Exception{
		boolean state=false;
		String sql="update tbl_siparisdurum set durum=? where siparisdurumid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,siparisdurum.getDurum());
			psmt.setInt(2,siparisdurum.getSiparisdurumid());
			if(psmt.executeUpdate()>0){
				state=true;
			}
			
		} catch (SQLException e) {
		e.printStackTrace();
		}finally{
			ConDatabase.kapat(con, psmt);
		}
		return state;
	}
	

}
