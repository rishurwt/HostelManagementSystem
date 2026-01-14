package com.knmodi.HostelManagementSystem.dao;
import com.knmodi.HostelManagementSystem.model.Fees;  
import java.util.ArrayList;
public interface FeesDAO 
{
	//method for inserting new course data
	int save(Fees feedata);
	
	ArrayList<Fees> findAll();
	ArrayList<Fees> findOne(int temp);
//	void delete(int _id);
//	
//	
//	ArrayList<Fees> findAll();
//	
//	ArrayList<Fees> findOne(int r_id);

	
}
