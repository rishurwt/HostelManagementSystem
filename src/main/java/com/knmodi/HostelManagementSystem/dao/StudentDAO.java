package com.knmodi.HostelManagementSystem.dao;
import com.knmodi.HostelManagementSystem.model.Student;
import java.util.ArrayList;
public interface StudentDAO 
{
	//method for inserting new course data
	int save(Student studentdata);
	void delete(int stud_id);
	
	ArrayList<Student> findAll();
	
	ArrayList <Student> findOne(int stu_id);
	//method for updating duration
//	int updateCourseDuration(String courseId,int duration);
//	//method to delete the course
//	int delete(String courseId);
//	
//	//method to fetch all course list
//	ArrayList<Course> findAll();
//	
//	//method to fetch a particular course
//	Course findByCourseId(String courseId);
	
}
