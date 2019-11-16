package com.ts.dto;
public class doctorregisterDTO {
	private String dname;
	private String qual;
	private String start;
	private String end;
	private String hosp;
	private String email;
	
	public doctorregisterDTO(String dname, String qual,String start, String end, String hosp,String email) {
		super();
		this.dname = dname;
		this.qual = qual;
		this.start = start;
		this.end=end;
		this.hosp = hosp;
		this.email = email;
	}
	public doctorregisterDTO(){}
	public String getdname() {
		return dname;
	}
	public void setdname(String dname) {
		this.dname = dname;
	}
	
	public String getqual() {
		return qual;
	}
	public void setqual(String qual) {
		this.qual = qual;
	}
	public String getstart() {
		return start;
	}
	public void setstart(String start) {
		this.start = start;
	}
	public String getend() {
		return end;
	}
	public void setend(String end) {
		this.end = end;
	}
	public String gethosp() {
		return hosp;
	}
	public void sethosp(String hosp) {
		this.hosp = hosp;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "doctorRegisterDTO [ doctorName=" + dname + ",start time =" + start + ",end time =" + end + ",Qualification =" + qual + ", Hospital =" + hosp + ",email =" + email + "]";
	}
}