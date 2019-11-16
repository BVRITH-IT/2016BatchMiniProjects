package bvrit;

import java.math.BigInteger;

public class Land {
private int plotNo;
private int surveyNo;
private int area;
private String category;
private String criteria;
private int price;
private String place;
private String district;
private String city;
private String state;
private int ownerId;
private String ownerName;
private Long ownerPhone;




public Land(int plotNo, int surveyNo, int area, String category, String criteria, int price, String place, String district, String city, String state, int ownerId, String ownerName, Long ownerPhone){
}
public Land() {
	this.plotNo = plotNo;
	this.surveyNo = surveyNo;
	this.area = area;
	this.category = category;
	this.criteria = criteria;	
	this.price = price;
	this.place = place;
	this.district = district;
	this.city = city;
	this.state = state;
	this.ownerId = ownerId;
	this.ownerName = ownerName;
	this.ownerPhone = ownerPhone;
}

@Override
public String toString() {
	return "Land [plotNo=" + plotNo + ", surveyNo=" + surveyNo + ", area=" + area + ", category=" + category + ", criteria=" + criteria + ", price=" + price + ",  place=" + place + ",  district=" + district + ", city=" + city + ", state=" + state + ", ownerId=" + ownerId + ", ownerName=" + ownerName + ",  ownerPhone=" + ownerPhone + "]";
}
public int getPlotNo() {
	return plotNo;
}
public void setPlotNo(int sno) {
	this.plotNo = plotNo;
}
public int getSurveyNo() {
	return surveyNo;
}
public void setSurveyNo(int surveyNo) {
	this.surveyNo = surveyNo;
}
public double getArea() {
	return area;
}
public void setArea(int area) {
	this.area = area;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getCriteria() {
	return criteria;
}
public void setCriteria(String criteria) {
	this.criteria = criteria;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}

public int getOwnerId() {
	return ownerId;
}
public void setOwnerId(int ownerId) {
	this.ownerId = ownerId;
}
public String getOwnerName() {
	return ownerName;
}
public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}
public Long getOwnerPhone() {
	return ownerPhone;
}
public void setOwnerPhone(Long ownerPhone) {
	this.ownerPhone = ownerPhone;
}

}

