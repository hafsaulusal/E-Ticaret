package com.hafsa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hafsa.model.Kargo;
import com.hafsa.model.Kullanici;
import com.hafsa.model.Odeme;
import com.hafsa.model.Siparis;
import com.hafsa.model.SiparisDurum;
import com.hafsa.model.Urun;


public class SiparisDao {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static CallableStatement csmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Siparis> tumSiparisleriListele() throws SQLException {
		ArrayList<Siparis> siparisler = new ArrayList<Siparis>();				
		try {
			con=ConDatabase.getConnection();
			csmt=con.prepareCall("{call tumsiparisler()}");
			rs=csmt.executeQuery();
			while(rs.next()){
				Siparis siparis=new Siparis();
				siparis.setSiparisid(rs.getInt(1));
				siparis.setAdet(rs.getInt(2));
				siparis.setVerilistarih(rs.getTimestamp(3));
				siparis.setTeslimtarih(rs.getTimestamp(4));
				siparis.setAdres(rs.getString(5));
				siparis.setFiyat(rs.getDouble(6));
				siparis.setKullaniciid(new Kullanici(rs.getString(7),rs.getString(8),rs.getString(9)));
				siparis.setUrunid(new Urun(rs.getString(10)));
				siparis.setKargoid(new Kargo(rs.getString(11),rs.getString(12)));
				siparis.setSiparisdurumid(new SiparisDurum(rs.getString(13)));
				siparis.setOdemeid(new Odeme(rs.getString(14)));
				siparisler.add(siparis);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDatabase.kapat(con, psmt,rs);
		}
		return siparisler;
	}
	
	public static boolean yenisiparis(Siparis siparis) throws Exception{
		boolean state=false;
		String sql="insert into tbl_siparis(adet,verilistarih,adres,fiyat,kullaniciid,"
				+ "urunid,siparisdurumid,kargoid,odemeid) values(?,NOW(),?,?,?,?,?,?,?)";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,siparis.getAdet());
			psmt.setString(2,siparis.getAdres());
			psmt.setDouble(3,siparis.getFiyat());
			psmt.setInt(4,siparis.getKullaniciid().getKullaniciid());
			psmt.setInt(5,siparis.getUrunid().getUrunid());
			psmt.setInt(6,siparis.getSiparisdurumid().getSiparisdurumid());
			psmt.setInt(7,siparis.getKargoid().getKargoid());
			psmt.setInt(8,siparis.getOdemeid().getOdemeid());
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
	
	public static boolean siparissil(Siparis siparis) throws Exception{
		boolean state=false;
		String sql="delete from tbl_siparis where siparisid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,siparis.getSiparisid());
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
	
	public static boolean siparisguncelle(Siparis siparis) throws Exception{
		boolean state=false;
		String sql="update tbl_siparis set siparisdurumid=?,kargoid=?,teslimtarih=? where (siparisid=?)";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,siparis.getSiparisdurumid().getSiparisdurumid());
			psmt.setInt(2,siparis.getKargoid().getKargoid());
			psmt.setTimestamp(3,siparis.getTeslimtarih());
			psmt.setInt(4,siparis.getSiparisid());
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
