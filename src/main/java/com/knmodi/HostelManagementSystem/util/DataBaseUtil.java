package com.knmodi.HostelManagementSystem.util;

import java.sql.*;

public final class DataBaseUtil {

    private static final String url = "jdbc:mysql://localhost:3306/clg";
    private static final String username = "root";
    private static final String password= "Rish@bh2006";

      
    
    public static Connection establishConnection()
	{
		Connection con=null;
		try
		{
			con = DriverManager.getConnection(url,username,password);
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		return  con;
	}
    
    public static void createTables()
	{
		try(Connection con = establishConnection())
		{
			if(con != null)
			{
				//creating statement reference
				Statement stmt = con.createStatement();
				
				
				String createStudentTable =
					    "CREATE TABLE IF NOT EXISTS student ("
					  + "student_id INT PRIMARY KEY , "
					  + "student_name VARCHAR(100) NOT NULL, "
					  + "gender VARCHAR(10) NOT NULL, "
					  + "contact varchar(15) NOT NULL , "
					  + "address varchar(200) NOT NULL , "
					  + "room_id int NOT NULL, "
					  + "foreign key(room_id) references room(room_id) , "
					  + "admission_date varchar(100) NOT NULL , "
					  + "status varchar(100) NOT NULL , "
					  + "hostel_id int"
					  + ")";
				

				String createRoomTable =
						"CREATE TABLE IF NOT EXISTS room ("
						+ "room_id INT PRIMARY KEY,"
						+ "room_no VARCHAR(10) UNIQUE, "
						+ "capacity INT NOT NULL, "
						+ "occupied INT NOT NULL "
						+	")";
				
				String createFeesTable =
						"CREATE TABLE IF NOT EXISTS fees ("
						+ "fees_id INT PRIMARY KEY, "
						+ "student_id INT, "
						+ "amount_paid INT NOT NULL, "
						+ "amount_left int not null ,"
						+ "amount_status varchar(100) ,"
						+ "date_paid varchar(100) NOT NULL, "
						+ "receipt_no VARCHAR(50) UNIQUE, "
						+ "FOREIGN KEY (student_id) REFERENCES student(student_id) "
						+	")";
				String createAttendanceTable =
						"CREATE TABLE IF NOT EXISTS attendance ( "
						+ "attendance_id INT PRIMARY KEY, "
						+ "student_id INT, "
						+ "date VARCHAR(10) NOT NULL, "
						+ "status VARCHAR(100) NOT NULL, "
						+ "FOREIGN KEY (student_id) REFERENCES student(student_id)"
						+ ")";
						
				String createVisitorsTable =
						"CREATE TABLE IF NOT EXISTS visitors ( "
						+ "visitor_id INT PRIMARY KEY, "
						+ "student_id INT, "
						+ "visitor_name VARCHAR(100) NOT NULL, "
						+ "relation VARCHAR(50) NOT NULL, "
						+ "entry_time VARCHAR(100) NOT NULL, "
						+ "exit_time VARCHAR(100) NULL, "
						+ "FOREIGN KEY (student_id) REFERENCES student(student_id) "
						+	")";
				
				String createComplaintsTable =
						"CREATE TABLE IF NOT EXISTS complaints ( "
						+ "complaint_id INT PRIMARY KEY, "
						+ "student_id INT, "
						+ "complaint_msg VARCHAR(300) NOT NULL, "
						+ "status VARCHAR(100) NOT NULL, "
						+ "FOREIGN KEY (student_id) REFERENCES student(student_id) "
						+ ")";
				
				
//				String createUserTable = 
//						"CREATE TABLE IF NOT EXISTS Users  ( "
//						+ "user_id INT PRIMARY KEY, "
//						+ "username VARCHAR(50) UNIQUE NOT NULL, "
//						+ "password VARCHAR(100) NOT NULL, "
//						+ "role ENUM('ADMIN', 'WARDEN') NOT NULL "
//						+ ")";
//				
//				
				// adding queries into batches
				stmt.addBatch(createRoomTable);
				stmt.addBatch(createStudentTable);
		
				stmt.addBatch(createFeesTable);
				stmt.addBatch(createAttendanceTable);
				stmt.addBatch(createVisitorsTable);
				stmt.addBatch(createComplaintsTable);
//				stmt.addBatch(createStudentTable);
				
				//executing batch
				stmt.executeBatch();
			}
		}catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		
	}
	
}
