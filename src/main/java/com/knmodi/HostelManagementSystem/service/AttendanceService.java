package com.knmodi.HostelManagementSystem.service;
import  com.knmodi.HostelManagementSystem.model.*;
//import java.util.ArrayList;
public interface AttendanceService 
{
	void registerAttendance(Attendance attendance);
	void showAttendance();
	void showAttendanceOne(int temp);
}