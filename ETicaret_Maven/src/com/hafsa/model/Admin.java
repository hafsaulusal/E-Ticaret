package com.hafsa.model;

public class Admin {
	private int adminid;
	private String adminad;
	private String adminsoyad;
	private String tcno;
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	private String eposta;
	private String parola;
	private Yetki yetkino;
	
	public Admin() {
		super();
	}
	public Admin(int adminid, String adminad, String adminsoyad, String eposta, String parola, Yetki yetkino) {
		super();
		this.adminid = adminid;
		this.adminad = adminad;
		this.adminsoyad = adminsoyad;
		this.eposta = eposta;
		this.parola = parola;
		this.yetkino = yetkino;
	}
	public Admin(int adminid, String adminad, String adminsoyad) {
		super();
		this.adminid = adminid;
		this.adminad = adminad;
		this.adminsoyad = adminsoyad;
	}
	public Admin(String eposta, String parola, Yetki yetkino) {
		super();
		this.eposta = eposta;
		this.parola = parola;
		this.yetkino = yetkino;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminad() {
		return adminad;
	}
	public void setAdminad(String adminad) {
		this.adminad = adminad;
	}
	public String getAdminsoyad() {
		return adminsoyad;
	}
	public void setAdminsoyad(String adminsoyad) {
		this.adminsoyad = adminsoyad;
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
	public Yetki getYetkino() {
		return yetkino;
	}
	public void setYetkino(Yetki yetkino) {
		this.yetkino = yetkino;
	}
	
	
	

}
