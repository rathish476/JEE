package com.service;

import com.CosmeticsDaoImpl.CosmaticsDaoImpl;

public class CosmaticsUpdateTester {

		public static void main(String[] args){
			CosmaticsDaoImpl cosmaticsdao=new CosmaticsDaoImpl();
			boolean result=cosmaticsdao.updateRecordBasedonBrand(600, "wow");
			System.out.println("was table updated"+ result);
			

		}

	}


