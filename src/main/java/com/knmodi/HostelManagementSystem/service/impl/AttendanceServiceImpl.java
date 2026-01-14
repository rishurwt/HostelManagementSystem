package com.knmodi.HostelManagementSystem.service.impl;

import com.knmodi.HostelManagementSystem.dao.AttendanceDAO;         
import com.knmodi.HostelManagementSystem.dao.impl.AttendanceDAOImpl;
import com.knmodi.HostelManagementSystem.model.Attendance;
//import com.knmodi.HostelManagementSystem.model.Room;
//import com.knmodi.HostelManagementSystem.model.Student;
import com.knmodi.HostelManagementSystem.service.AttendanceService;
import java.util.ArrayList;

//import java.util.*;

public class AttendanceServiceImpl implements AttendanceService
{
	private AttendanceDAO AttendanceDAO;
	
	//constructor 

	public AttendanceServiceImpl() {
		//to initialize DAO reference
		AttendanceDAO = new AttendanceDAOImpl();
	}
	
	
	public void registerAttendance(Attendance attendance)
	{
		if(attendance== null) //verifying course object null
		{
			System.out.println("Attendance data is empty");
		}

		else
		{
			//calling save method()of dao to insert the course data into the table
			int rows = AttendanceDAO.save(attendance);
			if(rows > 0) // number of rows greater than 0 indicates successful insert operation
			{
				System.out.println("Attendance Successfully Registered");
			}
			else
			{
				System.out.println("Unable to register the Attendance");
			}
		}
		
	}
	
	public void showAttendance() {
		ArrayList<Attendance> FeesList = AttendanceDAO.findAll();
		if(FeesList.size() > 0)
		{
			System.out.println(FeesList);
		}
		else
		{
			System.out.println("No student data found");
		}
	}
	
	public void showAttendanceOne(int attendance_id)
	{
		ArrayList<Attendance> AttendanceList = AttendanceDAO.findOne(attendance_id);
		if(AttendanceList.size() > 0)
		{
			System.out.println(AttendanceList);
		}
		else
		{
			System.out.println("No student data found");
		}
	}
}