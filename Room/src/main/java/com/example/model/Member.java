package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

@Entity
public class Member {
@Id
int id;
@NotNull
String memName;
String company;
String city;
@Pattern(regexp = "(\\+61|0)[0-9]{9}",message = "pattern mismatch")
String contactNumber;
@OneToMany(cascade = CascadeType.ALL)
private List<Keyy> keyy;

public List<Keyy> getKeyy() {
	return keyy;
}
public void setKeyy(List<Keyy> keyy) {
	this.keyy = keyy;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMemName() {
	return memName;
}
public void setMemName(String memName) {
	this.memName = memName;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}

}
