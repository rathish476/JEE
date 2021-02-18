package com.CosmeticsDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Dto.Cosmatics;

public interface CosmaticsDao {
	
	Connection getDBConnection() throws ClassNotFoundException, SQLException;
boolean save(Cosmatics cosmatics);

ArrayList <Cosmatics> readAllRecords();

boolean updateRecord(Cosmatics cosmatics);

boolean updateRecordBasedonBrand(double newPrice, String brand);

boolean deleteRecordBasedonCosmaticsId(int CosmaticsId);
}