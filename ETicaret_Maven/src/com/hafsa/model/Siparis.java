package com.hafsa.model;
import java.sql.Timestamp;

public class Siparis {

	private int siparisid;
	private int adet;
	private Timestamp verilistarih;
	private Timestamp teslimtarih;
	private String adres;
	private double fiyat;
	private Kullanici kullaniciid;
	private Urun urunid;
	private SiparisDurum siparisdurumid;
	private Kargo kargoid;
	private Odeme odemeid;
	
	public Siparis() {
		super();
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	public Siparis(int siparisid) {
		super();
		this.siparisid = siparisid;
	}
	public int getSiparisid() {
		return siparisid;
	}
	
	public Timestamp getTeslimtarih() {
		return teslimtarih;
	}
	public void setTeslimtarih(Timestamp teslimtarih) {
		this.teslimtarih = teslimtarih;
	}
	public Timestamp getVerilistarih() {
		return verilistarih;
	}
	public void setVerilistarih(Timestamp verilistarih) {
		this.verilistarih =verilistarih;
	}
	public void setSiparisid(int siparisid) {
		this.siparisid = siparisid;
	}
	public int getAdet() {
		return adet;
	}
	public void setAdet(int adet) {
		this.adet = adet;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public Kullanici getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(Kullanici kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	public Urun getUrunid() {
		return urunid;
	}
	public void setUrunid(Urun urunid) {
		this.urunid = urunid;
	}
	public SiparisDurum getSiparisdurumid() {
		return siparisdurumid;
	}
	public void setSiparisdurumid(SiparisDurum siparisdurumid) {
		this.siparisdurumid = siparisdurumid;
	}
	public Kargo getKargoid() {
		return kargoid;
	}
	public void setKargoid(Kargo kargoid) {
		this.kargoid = kargoid;
	}
	public Odeme getOdemeid() {
		return odemeid;
	}
	public void setOdemeid(Odeme odemeid) {
		this.odemeid = odemeid;
	}
	
	
}
