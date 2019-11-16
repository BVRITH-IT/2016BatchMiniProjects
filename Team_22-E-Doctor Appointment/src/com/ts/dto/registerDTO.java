package com.ts.dto;
public class registerDTO {
	private String uname;
	private String pwd;
	private String utype;
	public registerDTO(String uname, String pwd, String utype) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.utype=utype;
	}
	public registerDTO(){}
	public String getuname() {
		return uname;
	}
	public void setuname(String uname) {
		this.uname = uname;
	}
	public String getpwd() {
		return pwd;
	}
	public void setpwd(String pwd) {
		this.pwd = pwd;
	}
	public String getutype() {
		return utype;
	}
	public void setutype(String utype) {
		this.utype = utype;
	}
	@Override
	public String toString() {
		return "userRegisterDTO [ userName=" + uname + ", userPassword=" + pwd + ", userType =" + utype + "]";
	}
}
