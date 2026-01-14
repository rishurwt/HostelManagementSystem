package com.knmodi.HostelManagementSystem.dao.impl;

//import java.util.ArrayList; 

import com.knmodi.HostelManagementSystem.dao.FeesDAO;     
import com.knmodi.HostelManagementSystem.model.Fees;
//import com.knmodi.HostelManagementSystem.model.StudFees
//import com.knmodi.HostelManagementSystem.model.Room;

import java.sql.*;
import java.util.ArrayList;

import com.knmodi.HostelManagementSystem.util.*;

public class FeesDAOImpl implements FeesDAO
{

	@Override
	public int save(Fees feesdata) 
	{
		int insertedRows = 0;
		try(Connection con =DataBaseUtil.establishConnection())
		{
	
			String sql =
					"INSERT INTO fees (fees_id,student_id,amount_paid,amount_left,amount_status,date_paid,receipt_no) "
					+ "VALUES (?,?,?,?,?,?,?)";

					PreparedStatement ps = con.prepareStatement(sql);

					ps.setInt(1, feesdata.getFees_id());
					ps.setInt (2, feesdata.getStudent_id());
					ps.setInt(3, feesdata.getAmount_paid());
					ps.setInt(4, feesdata.getAmount_left());
					ps.setString(5 , feesdata.getAmount_status());
					ps.setString(6, feesdata.getDate_paid());
					ps.setString(7, feesdata.getReceipt_no());
		

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
	
	public ArrayList<Fees> findAll() {
		//defining an arraylist
		ArrayList<Fees> FeesList = new ArrayList<>();
		try(Connection con = DataBaseUtil.establishConnection())
		{
			//create statement
			Statement stmt = con.createStatement();
			//query to select data from table
			String sqlQuery = "Select fees_id,student_id,amount_paid,"
					+"amount_left,amount_status,date_paid,"
					+"receipt_no from fees";
			//to execute the select query
			ResultSet result = stmt.executeQuery(sqlQuery);
			//Creating object of Course
			Fees fees;
			//fetching data
			while(result.next())
			{
				fees = new Fees();
				//setting course data
				fees.setFees_id(result.getInt(1));
				fees.setStudent_id(result.getInt(2));
	
				fees.setAmount_paid(result.getInt(3));

				fees.setAmount_left(result.getInt(4));
				fees.setAmount_status(result.getString(5));
				fees.setDate_paid(result.getString(6));
				fees.setReceipt_no(result.getString(7));
				
				//inserting course into arraylist
				FeesList.add(fees);
			}				
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		
		return FeesList;
	}
	
	public ArrayList<Fees> findOne(int temp){
		//defining an arraylist
		ArrayList<Fees> FeesList = new ArrayList<>();
		try(Connection con = DataBaseUtil.establishConnection())
		{

			String sqlQuery = "Select fees_id,student_id,amount_paid,"
					+"amount_left,amount_status,date_paid,"
					+"receipt_no from fees where student_id=?";
			
			   PreparedStatement pstmt = con.prepareStatement(sqlQuery);
		        pstmt.setInt(1, temp);

			ResultSet result1 = pstmt.executeQuery();
			//Creating object of Course
			Fees fees;
			//fetching data
			while(result1.next())
			{
				fees = new Fees();
				//setting course data
				fees.setFees_id(result1.getInt(1));
				fees.setStudent_id(result1.getInt(2));
	
				fees.setAmount_paid(result1.getInt(3));

				fees.setAmount_left(result1.getInt(4));
				fees.setAmount_status(result1.getString(5));
				fees.setDate_paid(result1.getString(6));
				fees.setReceipt_no(result1.getString(7));
				
				//inserting course into arraylist
				FeesList.add(fees);
			}				
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		
		return FeesList;
	}

}