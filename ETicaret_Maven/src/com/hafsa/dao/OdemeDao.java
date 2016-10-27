package com.hafsa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hafsa.model.Odeme;

public class OdemeDao {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;

	
	public static ArrayList<Odeme> tumodemeler() throws SQLException {
		ArrayList<Odeme> tumodemeler = new ArrayList<Odeme>();
		String sql = "Select * from tbl_odeme order by odemeid asc";
		try {
			con = ConDatabase.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Odeme odeme=new Odeme();
				odeme.setOdemeid(rs.getInt(1));
				odeme.setOdemetip(rs.getString(2));
				tumodemeler.add(odeme);
			}
			con.close();
		} catch (final SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConDatabase.kapat(con, psmt, rs);
		}
		return tumodemeler;
	}
	
	public static boolean odemeekle(Odeme odeme) throws SQLException{
		boolean state=false;
		String sql="insert into tbl_odeme (odemetip) values (?)";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,odeme.getOdemetip());
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
	
	public static boolean odemesil(Odeme odeme) throws Exception{
		boolean state=false;
		String sql="delete from tbl_odeme where odemeid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,odeme.getOdemeid());
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
	
	public static boolean odemeguncelle(Odeme odeme) throws Exception{
		boolean state=false;
		String sql="update tbl_odeme set odemetip=? where odemeid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,odeme.getOdemetip());
			psmt.setInt(2,odeme.getOdemeid());
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
