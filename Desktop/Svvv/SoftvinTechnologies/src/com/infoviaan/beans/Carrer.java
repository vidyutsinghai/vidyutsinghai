package com.infoviaan.beans;

public class Carrer {
	private String cName;
	private String cEmail;
	private String cResume;

	public Carrer() {
	}

	public Carrer(String cName, String cEmail, String cResume) {
		this.cName = cName;
		this.cEmail = cEmail;
		this.cResume = cResume;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcResume() {
		return cResume;
	}

	public void setcResume(String cResume) {
		this.cResume = cResume;
	}
}
