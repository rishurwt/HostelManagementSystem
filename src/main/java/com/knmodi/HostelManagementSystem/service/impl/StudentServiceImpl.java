package com.knmodi.HostelManagementSystem.service.impl;

import com.knmodi.HostelManagementSystem.dao.StudentDAO;       
import com.knmodi.HostelManagementSystem.dao.impl.StudentDAOImpl;
import com.knmodi.HostelManagementSystem.model.Student;
import com.knmodi.HostelManagementSystem.service.StudentService;


import java.util.*;

public class StudentServiceImpl implements StudentService
{
	private StudentDAO StudentDAO;
	
	//constructor 

	public StudentServiceImpl() {
		//to initialize DAO reference
		StudentDAO = new StudentDAOImpl();
	}
	
	
	public void registerStudent(Student student)
	{
		if(student== null) //verifying course object null
		{
			System.out.println("Course data is empty");
		}

		else
		{
			//calling save method()of dao to insert the course data into the table
			int rows = StudentDAO.save(student);
			if(rows > 0) // number of rows greater than 0 indicates successful insert operation
			{
				System.out.println("Student Successfully Registered");
			}
			else
			{
				System.out.println("Unable to register the student");
			}
		}
		
	}
	
	public void deleteStudent (int stude_id)
	{
		StudentDAO.delete(stude_id);
		System.out.println("Information deleted");
	}
	
	public void showStud()
	{
		ArrayList<Student> StudentList = StudentDAO.findAll();
		if(StudentList.size() > 0)
		{
			System.out.println(StudentList);
		}
		else
		{
			System.out.println("No student data found");
		}
	}
	
	public void showByStuId(int st_id)
	
	{
		ArrayList<Student> StudentList = StudentDAO.findOne(st_id);
		if(StudentList.size() > 0)
		{
			System.out.println(StudentList);
		}
		else
		{
			System.out.println("No student data found");
		}
		
	}


	
	
	
}