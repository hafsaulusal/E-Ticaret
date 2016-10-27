package com.hafsa.model;

public class Kullanici {

	private int kullaniciid;
	private String kullaniciad;
	private String kullanicisoyad;
	private String tcno;
	private String eposta;
	private String parola;
	private String cepno;
	private String adres;
	private Yetki yetkino;
	
	
	public Kullanici() {
		super();
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno =tcno;
	}

	public String getCepno() {
		return cepno;
	}

	public void setCepno(String cepno) {
		this.cepno = cepno;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public Kullanici(String kullaniciad, String kullanicisoyad, String eposta) {
		super();
		this.kullaniciad = kullaniciad;
		this.kullanicisoyad = kullanicisoyad;
		this.eposta = eposta;
	}

	public Yetki getYetkino() {
		return yetkino;
	}
	public void setYetkino(Yetki yetkino) {
		this.yetkino = yetkino;
	}
	public int getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	public String getKullaniciad() {
		return kullaniciad;
	}
	public void setKullaniciad(String kullaniciad) {
		this.kullaniciad = kullaniciad;
	}
	public String getKullanicisoyad() {
		return kullanicisoyad;
	}
	public void setKullanicisoyad(String kullanicisoyad) {
		this.kullanicisoyad = kullanicisoyad;
	}
	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
		
}
