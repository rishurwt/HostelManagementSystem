package com.knmodi.HostelManagementSystem.controller;

import java.util.Scanner;      
import com.knmodi.HostelManagementSystem.model.Attendance;

import com.knmodi.HostelManagementSystem.service.AttendanceService;

import com.knmodi.HostelManagementSystem.service.impl.AttendanceServiceImpl;


public class AttendanceController{
	
	
	private AttendanceService AttendanceService;
	
	//constructor
	public AttendanceController() 
	{
		//to initialize service
		AttendanceService = new AttendanceServiceImpl();
	}
	//user interface for registration of new course
	public void registerAttendanceUI()
	{
		Scanner sc = new Scanner(System.in);
		//input of course id
		System.out.print("Enter attendance id: (e.g, 447 )");
		int attendance_id = sc.nextInt();
		sc.nextLine(); // consume newline
		
		System.out.print("Enter student id : (e.g, 123) ");
		int student_id = sc.nextInt();
		sc.nextLine();
		
	
		System.out.println("Enter date : (e.g, 11/12/2025)");
		String date_paid=sc.nextLine();
		
		System.out.println("Enter  Status: (e.g., Successful/Failed )");
		String status = sc.nextLine();
		
	
		

		
		AttendanceService.registerAttendance(new Attendance(attendance_id,student_id,date_paid,status));

	}
	public void showAttendance()
	{
		AttendanceService.showAttendance();
	}
	
	public void showAttendanceOne()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student id to get info");
		int temp = sc.nextInt();
		AttendanceService.showAttendanceOne(temp);
	}
	
	
}
