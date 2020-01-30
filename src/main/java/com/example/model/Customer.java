package com.example.model;

import javax.persistence.*;

import com.opencsv.bean.CsvBindByName;

@Entity
public class Customer {
	
	@CsvBindByName
	@Id
	private int id;
	@CsvBindByName
	private String lastName;
	@CsvBindByName
	private String location;
	@CsvBindByName
	private String outletName;
	@CsvBindByName
	private String outletType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOutletName() {
		return outletName;
	}
	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}
	public String getOutletType() {
		return outletType;
	}
	public void setOutletType(String outletType) {
		this.outletType = outletType;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", lastName=" + lastName + ", location=" + location + ", outletName=" + outletName
				+ ", outletType=" + outletType + "]";
	}
	
	

}
