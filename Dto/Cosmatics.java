package com.Dto;

public class Cosmatics {
private  int cosmaticsId;
private String name;
private double price;
private String brand;
public Cosmatics(int cosmaticsId, String name, double price, String brand) {
	super();
	this.cosmaticsId = cosmaticsId;
	this.name = name;
	this.price = price;
	this.brand = brand;
}
public Cosmatics() {
	// TODO Auto-generated constructor stub
}
public   int getCosmaticsId() {
	return cosmaticsId;
}
public void setCosmaticsId(int cosmaticsId) {
	this.cosmaticsId = cosmaticsId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
@Override
public String toString() {
	return "Cosmatics [cosmaticsId=" + cosmaticsId + ", name=" + name + ", price=" + price + ", brand=" + brand
			+ ", getCosmaticsId()=" + getCosmaticsId() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
			+ ", getBrand()=" + getBrand() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}

}
