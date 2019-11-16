package com.ts.dto;
public class hospitalregisterDTO {
	private String hname;
	private String address;
	private String state;
	private String country;
	private String phone;
	private String email;
	public hospitalregisterDTO(String hname, String address, String state,String country, String phone,String email) {
		super();
		this.hname = hname;
		this.address = address;
		this.state = state;
		this.country = country;
		this.phone = phone;
		this.email = email;
	}
	public hospitalregisterDTO(){}
	public String gethname() {
		return hname;
	}
	public void sethname(String hname) {
		this.hname = hname;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getstate() {
		return state;
	}
	public void setstate(String state) {
		this.state = state;
	}
	public String getcountry() {
		return country;
	}
	public void setcountry(String country) {
		this.country = country;
	}
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "hospitalRegisterDTO [ hospitalName=" + hname + ", address=" + address +  ",state =" + state + ",country =" + country + ",phone =" + phone + ",email =" + email + "]";
	}
}
