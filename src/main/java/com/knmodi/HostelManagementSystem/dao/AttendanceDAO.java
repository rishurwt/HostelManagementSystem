package com.knmodi.HostelManagementSystem.dao;
import com.knmodi.HostelManagementSystem.model.Attendance;  
import java.util.ArrayList;
public interface AttendanceDAO 
{
	//method for inserting new course data
	int save(Attendance attendancedata);
	
	ArrayList<Attendance> findAll();
	ArrayList<Attendance> findOne(int temp);
//	void delete(int _id);
//	
//	
//	ArrayList<Fees> findAll();
//	
//	ArrayList<Fees> findOne(int r_id);

	
}
