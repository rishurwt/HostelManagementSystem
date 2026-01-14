package com.knmodi.HostelManagementSystem.controller;

import java.util.Scanner;   
import com.knmodi.HostelManagementSystem.model.Student;   
import com.knmodi.HostelManagementSystem.service.StudentService;
import com.knmodi.HostelManagementSystem.service.impl.StudentServiceImpl;

public class StudentController{
	
	
		private StudentService StudentService;
		
		//constructor
		public StudentController()
		{
			//to initialize service
			StudentService = new StudentServiceImpl();
		}
		//user interface for registration of new course
		public void registerStudentUI()
		{
			Scanner sc = new Scanner(System.in);
			//input of course id
			System.out.print("Enter Student id: (e.g, 44567 )");
			int student_id = sc.nextInt();
			sc.nextLine(); // consume newline
			
			System.out.print("Enter Student Name : ");
			String student_name = sc.nextLine();
			
			System.out.print("Enter Gender: (M/F) ");
			String gender = sc.nextLine();
			
			System.out.print("Enter contact :(93354444XX) ");
			String contact = sc.nextLine();
//			sc.nextLine(); // consume newlin
			
			System.out.print("Enter address: ");
			String address = sc.nextLine();
			
			System.out.print("Enter room_id: (e.g, 1) ");
			int room_id = sc.nextInt();
			sc.nextLine(); // consume newlin
			
			System.out.print("Enter addmission date: (e.g, 16/12/2023 ");
			String admission_date = sc.nextLine();
			
			System.out.print("Enter status: (e.g, A/L) ");
			String status = sc.nextLine();
			
			System.out.print("Enter hostel_id: (e.g, 55) ");
			int hostel_id = sc.nextInt();
			sc.nextLine(); // consume newlin
			

			StudentService.registerStudent(new Student(student_id,student_name, gender,contact,address,room_id,admission_date,status,hostel_id));

		}
		
		public void deleteStudentUI()
		{
			Scanner sc = new Scanner (System.in);
			
			System.out.println("Enter student_id to be deleted");
			int student_id = sc.nextInt();
			
			StudentService.deleteStudent(student_id);
		}
		
		
		public void showStudent()
		{
			StudentService.showStud();
		}
		public void showByStudId()
		{
			Scanner sc = new Scanner (System.in);
			
			System.out.println("Enter student_id to be shown");
			int student_id = sc.nextInt();
			StudentService.showByStuId(student_id);
		} 
	}

