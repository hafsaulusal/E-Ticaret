package com.hafsa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.hafsa.model.*;

public class YetkiDao {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Yetki> tumyetkiler() throws SQLException {
		ArrayList<Yetki> tumyetkiler = new ArrayList<Yetki>();
		String sql = "Select * from tbl_yetki order by yetkino asc";
		try {
			con = ConDatabase.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Yetki yetki =new Yetki();
				yetki.setYetkino(rs.getInt(1));
				yetki.setYetkiad(rs.getString(2));
				tumyetkiler.add(yetki);
			}
			con.close();
		} catch (final SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConDatabase.kapat(con, psmt, rs);
		}
		return tumyetkiler;
	}
	
	
	public static boolean yetkiekle(Yetki yetki) throws SQLException{
		boolean state=false;
		String sql="insert into tbl_yetki(yetkiad) values (?)";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,yetki.getYetkiad());
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
	
	public static boolean yetkisil(Yetki yetki) throws Exception{
		boolean state=false;
		String sql="delete from tbl_yetki where yetkino=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,yetki.getYetkino());
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
	
	public static boolean yetkiguncelle(Yetki yetki) throws Exception{
		boolean state=false;
		String sql="update tbl_yetki set yetkiad=? where yetkino=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,yetki.getYetkiad());
			psmt.setInt(2,yetki.getYetkino());
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
