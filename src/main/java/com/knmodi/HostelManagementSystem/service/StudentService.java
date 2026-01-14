package com.knmodi.HostelManagementSystem.service;
import  com.knmodi.HostelManagementSystem.model.*;
public interface StudentService 
{
	//method to register new course
	void registerStudent(Student studentxx);
	
	void deleteStudent (int stud_iid);
	
	void showStud();
	
	void showByStuId(int stud_id);
	//method to update course duration
//	void updateCourseDuration(String courseId,int duration);
//	//method to fetch all courses
//	void getCourseList();
//	//method to fetch course details of a particular course
//	void getCourseDetails(String courseId);
	//
	
}
