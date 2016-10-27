package com.hafsa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hafsa.model.Kullanici;
import com.hafsa.model.Yetki;

public class KullaniciDao {
	
	private static Connection con=null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Kullanici> tumkullanicilar(){
		ArrayList<Kullanici> tumkullanicilar=new ArrayList<Kullanici>();
		String sql="SELECT k.kullaniciid,k.kullaniciad,k.kullanicisoyad,k.tcno, k.eposta, k.parola,k.cepno,k.adres,y.yetkiad"+
"FROM tbl_kullanici AS k INNER JOIN tbl_yetki AS y ON (k.yetkino = y.yetkino)";
	try {
	
		con=ConDatabase.getConnection();
		psmt=con.prepareStatement(sql);
		rs=psmt.executeQuery();
		
		while(rs.next()){
			Kullanici kullanici=new Kullanici();
			kullanici.setKullaniciid(rs.getInt(1));
			kullanici.setKullaniciad(rs.getString(2));
			kullanici.setKullanicisoyad(rs.getString(3));
			kullanici.setTcno(rs.getString(4));
			kullanici.setEposta(rs.getString(5));
			kullanici.setParola(rs.getString(6));
			kullanici.setCepno(rs.getString(7));
			kullanici.setAdres(rs.getString(8));
			kullanici.setYetkino(new Yetki(rs.getString(9)));
			tumkullanicilar.add(kullanici);
			
		}
		con.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ConDatabase.kapat(con,psmt,rs);
	}
		return tumkullanicilar;
	}
	
	public static boolean kullanicisil(Kullanici kullanici){
		boolean state=false;
		String sql="delete from tbl_kullanici where kullaniciid = ?";
		try {
			
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, kullanici.getKullaniciid());
			
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
	
	public static boolean kullaniciekle(Kullanici kullanici){
		boolean state=false;
		String sql="insert into tbl_kullanici(kullaniciad,kullanicisoyad,tcno,eposta,parola,cepno,adres,yetkino) "
				+ "values (?,?,?,?,?,?,?,?)";
		try {
		con=ConDatabase.getConnection();
		psmt=con.prepareStatement(sql);
		psmt.setString(1,kullanici.getKullaniciad());
		psmt.setString(2,kullanici.getKullanicisoyad());
		psmt.setString(3,kullanici.getTcno());
		psmt.setString(4,kullanici.getEposta());
		psmt.setString(5,kullanici.getParola());
		psmt.setString(6,kullanici.getCepno());
		psmt.setString(7,kullanici.getAdres());
		psmt.setInt(8,kullanici.getYetkino().getYetkino());
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
	
	public static boolean kullaniciguncelle(Kullanici kullanici){
		boolean state=false;
		String sql="update tbl_kullanici set kullaniciad=?,kullanicisoyad=?,tcno=?,eposta=?,parola=?,cepno=?,adres=? where kullaniciid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,kullanici.getKullaniciad());
			psmt.setString(2,kullanici.getKullanicisoyad());
			psmt.setString(3,kullanici.getTcno());
			psmt.setString(4,kullanici.getEposta());
			psmt.setString(5,kullanici.getParola());
			psmt.setString(6,kullanici.getCepno());
			psmt.setString(7,kullanici.getAdres());
			psmt.setInt(8,kullanici.getKullaniciid());
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
	
	public static Kullanici login(Kullanici _kullanici){
		Kullanici kullanici=null;
		String sql="select * from tbl_kullanici where eposta = ? and parola = ?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,_kullanici.getEposta());
			psmt.setString(2,_kullanici.getParola());
			rs=psmt.executeQuery();
			if(rs.next()){
				kullanici=new Kullanici();
				kullanici.setKullaniciid(rs.getInt(1));
				kullanici.setKullaniciad(rs.getString(2));
				kullanici.setTcno(rs.getString(3));
				kullanici.setKullanicisoyad(rs.getString(4));
				kullanici.setEposta(rs.getString(5));
				kullanici.setParola(rs.getString(6));	
				kullanici.setCepno(rs.getString(7));
				kullanici.setAdres(rs.getString(8));
				kullanici.setYetkino(new Yetki(rs.getString(9)));
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDatabase.kapat(con, psmt, rs);
		}
		
		return kullanici;
	}
	

}
