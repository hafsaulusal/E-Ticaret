package com.hafsa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hafsa.model.Kargo;

public class KargoDao {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Kargo> tumkargolar() throws SQLException {
		ArrayList<Kargo> tumkargolar = new ArrayList<Kargo>();
		String sql = "Select * from tbl_kargo order by kargoid asc";
		try {
			con = ConDatabase.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Kargo kargo=new Kargo();
				kargo.setKargoid(rs.getInt(1));
				kargo.setKargoad(rs.getString(2));
				kargo.setAciklama(rs.getString(3));
				tumkargolar.add(kargo);
			}
			con.close();
		} catch (final SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConDatabase.kapat(con, psmt, rs);
		}
		return tumkargolar;
	}
	
	public static boolean kargoekle(Kargo kargo) throws SQLException{
		boolean state=false;
		String sql="insert into tbl_kargo(kargoad,aciklama) values (?,?)";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,kargo.getKargoad());
			psmt.setString(2,kargo.getAciklama());
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
	
	public static boolean kargosil(Kargo kargo) throws Exception{
		boolean state=false;
		String sql="delete from tbl_kargo where kargoid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,kargo.getKargoid());
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
	
	public static boolean kargoguncelle(Kargo kargo) throws Exception{
		boolean state=false;
		String sql="update tbl_kargo set kargoad=?,aciklama=? where kargoid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,kargo.getKargoad());
			psmt.setString(2,kargo.getAciklama());
			psmt.setInt(3,kargo.getKargoid());
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
