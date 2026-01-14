package com.knmodi.HostelManagementSystem.service.impl;

import com.knmodi.HostelManagementSystem.dao.FeesDAO;         
import com.knmodi.HostelManagementSystem.dao.impl.FeesDAOImpl;
import com.knmodi.HostelManagementSystem.model.Fees;
//import com.knmodi.HostelManagementSystem.model.Room;
//import com.knmodi.HostelManagementSystem.model.Student;
import com.knmodi.HostelManagementSystem.service.FeesService;
import java.util.ArrayList;

//import java.util.*;

public class FeesServiceImpl implements FeesService
{
	private FeesDAO FeesDAO;
	
	//constructor 

	public FeesServiceImpl() {
		//to initialize DAO reference
		FeesDAO = new FeesDAOImpl();
	}
	
	
	public void registerFees(Fees fees)
	{
		if(fees== null) //verifying course object null
		{
			System.out.println("Fees data is empty");
		}

		else
		{
			//calling save method()of dao to insert the course data into the table
			int rows = FeesDAO.save(fees);
			if(rows > 0) // number of rows greater than 0 indicates successful insert operation
			{
				System.out.println("Fees Successfully Registered");
			}
			else
			{
				System.out.println("Unable to register the Fees");
			}
		}
		
	}
	
	public void showFees() {
		ArrayList<Fees> FeesList = FeesDAO.findAll();
		if(FeesList.size() > 0)
		{
			System.out.println(FeesList);
		}
		else
		{
			System.out.println("No student data found");
		}
	}
	
	public void showFeesOne(int fees_id)
	{
		ArrayList<Fees> FeesList = FeesDAO.findOne(fees_id);
		if(FeesList.size() > 0)
		{
			System.out.println(FeesList);
		}
		else
		{
			System.out.println("No student data found");
		}
	}
}