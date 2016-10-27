package com.hafsa.model;

public class Yetki {
	private int yetkino;
	private String yetkiad;
	
	public Yetki() {
		super();
	}
	public Yetki(int yetkino, String yetkiad) {
		super();
		this.yetkino = yetkino;
		this.yetkiad = yetkiad;
	}
	public Yetki(String yetkiad) {
		super();
		this.yetkiad = yetkiad;
	}
	public Yetki(int yetkino) {
		super();
		this.yetkino = yetkino;
	}
	public int getYetkino() {
		return yetkino;
	}
	public void setYetkino(int yetkino) {
		this.yetkino = yetkino;
	}
	public String getYetkiad() {
		return yetkiad;
	}
	public void setYetkiad(String yetkiad) {
		this.yetkiad = yetkiad;
	}
	
	

}
