package com.hafsa.model;

import java.io.InputStream;

public class Urun {
	
	private int urunid;
	private Kategori kategoriid;
	private String urunad;
	private int fiyat;
	private String aciklama;
	private int stok;
	private String resim;
	public String getResim() {
		return resim;
	}

	private InputStream streamImg;
	
	public InputStream getStreamImg() {
		return streamImg;
	}

	public void setStreamImg(InputStream streamImg) {
		this.streamImg = streamImg;
	}

	public void setResim(String resim) {
		this.resim = resim;
	}

	public int getFiyat() {
	return fiyat;
}

public void setFiyat(int fiyat) {
	this.fiyat = fiyat;
}

	
	public Urun() {
		super();
	}
	
	public Urun(int urunid) {
		super();
		this.urunid = urunid;
	}


	public String getUrunad() {
		return urunad;
	}

	public void setUrunad(String urunad) {
		this.urunad = urunad;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}
	
	public Urun(int urunid, String urunad) {
		super();
		this.urunid = urunid;
		this.urunad = urunad;
	}


	public Urun(String urunad) {
		super();
		this.urunad = urunad;
	}


	public Urun(Kategori kategoriid) {
		super();
		this.kategoriid = kategoriid;
	}

	public int getUrunid() {
		return urunid;
	}

	public void setUrunid(int urunid) {
		this.urunid = urunid;
	}

	public Kategori getKategoriid() {
		return kategoriid;
	}

	public void setKategoriid(Kategori kategoriid) {
		this.kategoriid = kategoriid;
	}



	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

}
