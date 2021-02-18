package com.service;

import com.CosmeticsDao.CosmaticsDao;
import com.CosmeticsDaoImpl.CosmaticsDaoImpl;

public class CosmaticsDeleteTester {

	public static void main(String[] args) {
		CosmaticsDao cosmeticsDao = new CosmaticsDaoImpl();
		boolean result = cosmeticsDao.deleteRecordBasedonCosmaticsId(2);
		System.out.println("Is row deleted?" + result);
	}



	}


