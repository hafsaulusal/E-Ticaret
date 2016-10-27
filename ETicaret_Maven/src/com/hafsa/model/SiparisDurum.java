package com.hafsa.model;

public class SiparisDurum {
	private int siparisdurumid;
	private String durum;
	
	public SiparisDurum() {
		super();
	}
	public SiparisDurum(int siparisdurumid, String durum) {
		super();
		this.siparisdurumid = siparisdurumid;
		this.durum = durum;
	}
	public SiparisDurum(int siparisdurumid) {
		super();
		this.siparisdurumid = siparisdurumid;
	}
	public SiparisDurum(String durum) {
		super();
		this.durum = durum;
	}
	public int getSiparisdurumid() {
		return siparisdurumid;
	}
	public void setSiparisdurumid(int siparisdurumid) {
		this.siparisdurumid = siparisdurumid;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	
	

}
