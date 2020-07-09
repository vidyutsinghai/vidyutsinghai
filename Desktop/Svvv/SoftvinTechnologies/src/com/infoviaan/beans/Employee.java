package com.infoviaan.beans;

public class Employee {	//Bean Class --> DTO -- Data Transferring Object
	private String ename;
	private String edesignation;
	private String emobile;
	private String equalification;
	private String egender;
	private float esalary;
	private String eaddress;

	public Employee() {
	}

	public Employee(String ename, String edesignation, String emobile, String equalification, String egender,
			float esalary, String eaddress) {
		this.ename = ename;
		this.edesignation = edesignation;
		this.emobile = emobile;
		this.equalification = equalification;
		this.egender = egender;
		this.esalary = esalary;
		this.eaddress = eaddress;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEdesignation() {
		return edesignation;
	}

	public void setEdesignation(String edesignation) {
		this.edesignation = edesignation;
	}

	public String getEmobile() {
		return emobile;
	}

	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}

	public String getEqualification() {
		return equalification;
	}

	public void setEqualification(String equalification) {
		this.equalification = equalification;
	}

	public String getEgender() {
		return egender;
	}

	public void setEgender(String egender) {
		this.egender = egender;
	}

	public float getEsalary() {
		return esalary;
	}

	public void setEsalary(float esalary) {
		this.esalary = esalary;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

}
