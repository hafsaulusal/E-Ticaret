package com.hafsa.model;

public class Kategori {
	private int kategoriid;
	private String kategoriad;	

	public Kategori() {
		super();		
	}
	
	public Kategori(String kategoriad) {
		super();
		this.kategoriad = kategoriad;
	}

	public Kategori(int kategoriid) {
		super();
		this.kategoriid = kategoriid;
	}

	public Kategori(int kategoriid, String kategoriad) {
		super();
		this.kategoriid = kategoriid;
		this.kategoriad = kategoriad;
	}

	public int getKategoriid() {
		return kategoriid;
	}
	public void setKategoriid(int kategoriid) {
		this.kategoriid = kategoriid;
	}
	public String getKategoriad() {
		return kategoriad;
	}
	public void setKategoriad(String kategoriad) {
		this.kategoriad = kategoriad;
	}
	
	

}
