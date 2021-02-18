
	package com.service;

import com.CosmeticsDao.CosmaticsDao;
import com.CosmeticsDaoImpl.CosmaticsDaoImpl;
import com.Dto.Cosmatics;

public class CosmaticsTester {
	public static void main(String[] args) {
	CosmaticsDao CosmaticsDaoImpl=new CosmaticsDaoImpl();
	
	Cosmatics cosmatics=new Cosmatics(5,"maskara",500.0,"sugar");
	
	{
		System.out.println("saving the record to database:" +cosmatics);
		
	boolean result=CosmaticsDaoImpl.save(cosmatics);
	if(result) {
		System.out.println("records successfully inserted");
	}
	else
	{
		System.out.println("there was some problem while recording inserting");
	}
	

}
}
}
