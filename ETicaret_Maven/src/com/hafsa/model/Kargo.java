package com.hafsa.model;

public class Kargo {
	private int kargoid;
	private String kargoad;
	private String aciklama;

	public Kargo() {
		super();
	}
	
	public Kargo(int kargoid) {
		super();
		this.kargoid = kargoid;
	}

	public Kargo(String kargoad) {
		super();
		this.kargoad = kargoad;
	}

	public Kargo(int kargoid, String kargoad) {
		super();
		this.kargoid = kargoid;
		this.kargoad = kargoad;
	}
	public Kargo(String kargoad, String aciklama) {
		super();
		this.kargoad = kargoad;
		this.aciklama = aciklama;
	}
	public Kargo(int kargoid, String kargoad, String aciklama) {
		super();
		this.kargoid = kargoid;
		this.kargoad = kargoad;
		this.aciklama = aciklama;
	}

	public int getKargoid() {
		return kargoid;
	}
	public void setKargoid(int kargoid) {
		this.kargoid = kargoid;
	}
	public String getKargoad() {
		return kargoad;
	}
	public void setKargoad(String kargoad) {
		this.kargoad = kargoad;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	

}
