package com.ts.dto;
public class makeappointmentDTO {
	private String name;
	private String gnd;
	private int age;
	private String date;
	private String time;
	private String dname;
	private String hname;
	public makeappointmentDTO(String name, String gnd, int age, String date,String time,String dname, String hname) {
		super();
		this.name = name;
		this.gnd = gnd;
		this.age = age;
		this.date = date;
		this.time=time;
		this.dname=dname;
		this.hname=hname;
	}
	public makeappointmentDTO(){}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getgnd() {
		return gnd;
	}
	public void setgnd(String gnd) {
		this.gnd = gnd;
	}
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age = age;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	
	public void settime(String time) {
		this.time = time;
	}
	public String gettime() {
		return time;
	}
	public String getdname() {
		return dname;
	}
	public void setdname(String dname) {
		this.dname = dname;
	}
	public String gethname() {
		return hname;
	}
	public void sethname(String hname) {
		this.hname = hname;
	}
	@Override
	public String toString() {
		return "makeappointmentDTO [ Name=" + name + ", Gender=" + gnd + ", Age =" + age + ", Date =" + date + ", Time="+ time+", Doctor =" + dname + ", Hospital =" + hname + "]";
	}
}

