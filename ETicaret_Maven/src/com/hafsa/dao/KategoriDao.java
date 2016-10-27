package com.hafsa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hafsa.model.Kategori;

public class KategoriDao {
	private static Connection con=null;
	private static PreparedStatement psmt=null;
	private static ResultSet rs=null;
	
	public static ArrayList<Kategori> tumkategoriler(){
		ArrayList<Kategori> tumkategoriler=new ArrayList<Kategori>();
		String sql="select * from tbl_kategori order by kategoriid asc";
		try {
			con = ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
					while(rs.next()){
						Kategori kategori=new Kategori();
						kategori.setKategoriid(rs.getInt(1));
						kategori.setKategoriad(rs.getString(2));
						tumkategoriler.add(kategori);
					}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDatabase.kapat(con, psmt, rs);
		}
		
		return tumkategoriler;
	}	
	
	public static boolean kategorisil(Kategori kategori){
		boolean state=false;
		String sql="delete from tbl_kategori where kategoriid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,kategori.getKategoriid());
			
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
	
	public static boolean kategoriekle(Kategori kategori){
		boolean state=false;
		String sql="insert into tbl_kategori(kategoriad) values (?)";
		try {
		con=ConDatabase.getConnection();
		psmt=con.prepareStatement(sql);
		psmt.setString(1,kategori.getKategoriad());
		
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
	
	public static boolean kategoriguncelle(Kategori kategori){
		boolean state=false;
		String sql="update tbl_kategori set kategoriad=? where kategoriid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,kategori.getKategoriad());
			psmt.setInt(2,kategori.getKategoriid());
			
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
	
	

}
