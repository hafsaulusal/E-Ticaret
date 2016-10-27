package com.hafsa.model;

public class Odeme {
	private int odemeid;
	private String odemetip;
	
	public Odeme() {
		super();
	}
	public Odeme(int odemeid) {
		super();
		this.odemeid = odemeid;
	}
	public Odeme(String odemetip) {
		super();
		this.odemetip = odemetip;
	}
	public Odeme(int odemeid, String odemetip) {
		super();
		this.odemeid = odemeid;
		this.odemetip = odemetip;
	}
	public int getOdemeid() {
		return odemeid;
	}

	public void setOdemeid(int odemeid) {
		this.odemeid = odemeid;
	}

	public String getOdemetip() {
		return odemetip;
	}

	public void setOdemetip(String odemetip) {
		this.odemetip = odemetip;
	}
	
	
	
	
	
	
	
}
