package com.hafsa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hafsa.model.Kategori;
import com.hafsa.model.Urun;

public class UrunDao {
	private static Connection con=null;
	private static PreparedStatement psmt=null;
	private static ResultSet rs=null;
	
	public static ArrayList<Urun> tumurunler(){
		ArrayList<Urun> tumurunler=new ArrayList<Urun>();
		String sql="SELECT tbl_urun.urunid,	tbl_urun.urunad,tbl_urun.fiyat,tbl_urun.aciklama,"
				+ "tbl_urun.stok,tbl_urun.resim,tbl_kategori.kategoriad FROM tbl_urun INNER JOIN tbl_kategori ON "
				+ "tbl_urun.kategoriid = tbl_kategori.kategoriid";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
			Urun urun=new Urun();
			urun.setUrunid(rs.getInt(1));
			urun.setUrunad(rs.getString(2));
			urun.setFiyat(rs.getInt(3));
			urun.setAciklama(rs.getString(4));
			urun.setStok(rs.getInt(5));
			urun.setKategoriid(new Kategori(rs.getString(6)));
			tumurunler.add(urun);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDatabase.kapat(con, psmt, rs);
		}
		
		return tumurunler;
	}
	
	public static Urun tekurungetir(int urunid) throws SQLException{
		ArrayList<Urun> urun=new ArrayList<Urun>();
		String sql="SELECT tbl_urun.urunid,	tbl_urun.urunad,tbl_urun.fiyat,tbl_urun.aciklama,"
				+ "tbl_urun.stok,tbl_urun.resim,tbl_kategori.kategoriad FROM tbl_urun INNER JOIN tbl_kategori ON "
				+ "tbl_urun.kategoriid = tbl_kategori.kategoriid where tbl_urun.urunid=?";
	try {
		con=ConDatabase.getConnection();
		psmt=con.prepareStatement(sql);
		psmt.setInt(1,urunid);
		rs=psmt.executeQuery();
		if(rs.next()){
			Urun tumurunler=new Urun();
			tumurunler.setUrunid(rs.getInt(1));
			tumurunler.setUrunad(rs.getString(2));
			tumurunler.setFiyat(rs.getInt(3));
			tumurunler.setAciklama(rs.getString(4));
			tumurunler.setStok(rs.getInt(5));
			tumurunler.setKategoriid(new Kategori(rs.getString(6)));
			urun.add(tumurunler);
		}
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ConDatabase.kapat(con, psmt, rs);
	}
	return urun.get(0);
	
	}
	
	public static ArrayList<Urun> kategoriurungetir(int kategoriid){
		ArrayList<Urun> urun=new ArrayList<Urun>();
		String sql="SELECT tbl_urun.urunid,	tbl_urun.urunad,tbl_urun.fiyat,tbl_urun.aciklama,"
				+ "tbl_urun.stok,tbl_urun.resim,tbl_kategori.kategoriad FROM tbl_urun INNER JOIN tbl_kategori ON "
				+ "tbl_urun.kategoriid = tbl_kategori.kategoriid where tbl_kategori.kategoriid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,kategoriid);
			rs=psmt.executeQuery();
			while(rs.next()){
				Urun tumurunler=new Urun();
				tumurunler.setUrunid(rs.getInt(1));
				tumurunler.setUrunad(rs.getString(2));
				tumurunler.setFiyat(rs.getInt(3));
				tumurunler.setAciklama(rs.getString(4));
				tumurunler.setStok(rs.getInt(5));
				tumurunler.setKategoriid(new Kategori(rs.getString(6)));
				urun.add(tumurunler);
				
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDatabase.kapat(con, psmt, rs);
		}
		return urun;
		
	}
	
	public static ArrayList<Urun> urunara(String urunad){
		ArrayList<Urun> tumurunler=new ArrayList<Urun>();
		String sql="SELECT tbl_urun.urunid,	tbl_urun.urunad,tbl_urun.fiyat,tbl_urun.aciklama,"
				+ "tbl_urun.stok,tbl_urun.resim,tbl_kategori.kategoriad FROM tbl_urun INNER JOIN tbl_kategori ON "
				+ "tbl_urun.kategoriid = tbl_kategori.kategoriid where tbl_urun.urunad=?";
	try {
		con=ConDatabase.getConnection();
		psmt=con.prepareStatement(sql);
		psmt.setString(1,urunad);
		rs=psmt.executeQuery();
	while(rs.next()){
		Urun urun=new Urun();
		urun.setUrunid(rs.getInt(1));
		urun.setUrunad(rs.getString(2));
		urun.setFiyat(rs.getInt(3));
		urun.setAciklama(rs.getString(4));
		urun.setStok(rs.getInt(5));
		urun.setKategoriid(new Kategori(rs.getString(6)));
		tumurunler.add(urun);
		}
	con.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		try {
			ConDatabase.kapat(con, psmt, rs);
		} catch (Exception e) {
		}
	}
		return tumurunler;
	}
	
	public static boolean yeniurunekle(Urun urun) throws Exception{
		boolean state=false;
		String sql="insert into tbl_urun(urunad,fiyat,aciklama,stok,resim,kategoriid) values (?,?,?,?,?,?);";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1,urun.getUrunad());
			psmt.setInt(2,urun.getFiyat());
			psmt.setString(3,urun.getAciklama());
			psmt.setInt(4,urun.getStok());
			psmt.setBlob(5,urun.getStreamImg());
			psmt.setInt(6,urun.getKategoriid().getKategoriid());
			if(psmt.executeUpdate()>0){
				state=true;
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDatabase.kapat(con, psmt, rs);
		}
		return state;
	}
	
	public static boolean urunsil(Urun urun)throws Exception{
		boolean state=false;
		String sql="delete from tbl_urun where urunid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,urun.getUrunid());
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
	
	public static boolean urunguncelle(Urun urun) throws Exception{
		boolean state=false;
		String sql="update tbl_urun set urunad=?,fiyat=?,aciklama=?,stok=?,resim=?,kategoriid=? where urunid=?";
		try {
			con=ConDatabase.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1, urun.getUrunad());
			psmt.setInt(2,urun.getFiyat());
			psmt.setString(3,urun.getAciklama());
			psmt.setInt(4,urun.getStok());
			psmt.setBlob(5,urun.getStreamImg());
			psmt.setInt(6,urun.getKategoriid().getKategoriid());
			psmt.setInt(7, urun.getUrunid());
			if(psmt.executeUpdate()>0){
				state=true;
			}
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConDatabase.kapat(con, psmt);
		}
		return state;
	}
	
	public static byte[] getImageByUrunid(int urunid){
		String query="select resim from tbl_urun where urunid=?";
		Connection con=ConDatabase.getConnection();
		PreparedStatement psmt;
		byte[] bytesImage=null;
		
		try {
			psmt=con.prepareStatement(query);
			psmt.setInt(1,urunid);
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				bytesImage=rs.getBytes("resim");
			}
			con.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bytesImage;
	}
	

}
