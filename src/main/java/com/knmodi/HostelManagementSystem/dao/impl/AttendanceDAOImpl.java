package com.knmodi.HostelManagementSystem.dao.impl;

//import java.util.ArrayList; 

import com.knmodi.HostelManagementSystem.dao.AttendanceDAO;     
import com.knmodi.HostelManagementSystem.model.Attendance;
//import com.knmodi.HostelManagementSystem.model.StudFees
//import com.knmodi.HostelManagementSystem.model.Room;

import java.sql.*;
import java.util.ArrayList;

import com.knmodi.HostelManagementSystem.util.*;

public class AttendanceDAOImpl implements AttendanceDAO
{

	@Override
	public int save(Attendance attendancedata) 
	{
		int insertedRows = 0;
		try(Connection con =DataBaseUtil.establishConnection())
		{
	
			String sql =
					"INSERT INTO attendance (attendance_id,student_id,date,status) "
					+ "VALUES (?,?,?,?)";

					PreparedStatement ps = con.prepareStatement(sql);

					ps.setInt(1, attendancedata.getAttendance_id());
					ps.setInt (2, attendancedata.getStudent_id());
				
					ps.setString(3 , attendancedata.getDate());
					ps.setString(4, attendancedata.getStatus());

		

			//to execute the query
			insertedRows = ps.executeUpdate();
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		// TODO Auto-generated method stub
		return insertedRows;
	}
	
	public ArrayList<Attendance> findAll() {
		//defining an arraylist
		ArrayList<Attendance> AttendanceList = new ArrayList<>();
		try(Connection con = DataBaseUtil.establishConnection())
		{
			//create statement
			Statement stmt = con.createStatement();
			//query to select data from table
			String sqlQuery = "Select attendance_id,student_id,date,"
					+"status "
					+"from attendance";
			//to execute the select query
			ResultSet result = stmt.executeQuery(sqlQuery);
			//Creating object of Course
			Attendance attendance;
			//fetching data
			while(result.next())
			{
				attendance = new Attendance();
				//setting course data
				attendance.setAttendance_id(result.getInt(1));
				attendance.setStudent_id(result.getInt(2));
	
				attendance.setDate(result.getString(3));
				attendance.setStatus(result.getString(4));
				
				//inserting course into arraylist
				AttendanceList.add(attendance);
			}				
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		
		return AttendanceList;
	}
	
	public ArrayList<Attendance> findOne(int temp){
		//defining an arraylist
		ArrayList<Attendance> AttendanceList = new ArrayList<>();
		try(Connection con = DataBaseUtil.establishConnection())
		{
			String sqlQuery = "Select attendance_id,student_id,date,"
					+"status "
					+"from attendance where student_id=?";
			
			   PreparedStatement pstmt = con.prepareStatement(sqlQuery);
		        pstmt.setInt(1, temp);

			ResultSet result1 = pstmt.executeQuery();
			//Creating object of Course
			Attendance attendance;
			//fetching data
			while(result1.next())
			{
				attendance = new Attendance();
				//setting course data
				attendance.setAttendance_id(result1.getInt(1));
				attendance.setStudent_id(result1.getInt(2));
	
				attendance.setDate(result1.getString(3));
				attendance.setStatus(result1.getString(4));
				
				//inserting course into arraylist
				AttendanceList.add(attendance);
			}				
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		
		return AttendanceList;
	}

}