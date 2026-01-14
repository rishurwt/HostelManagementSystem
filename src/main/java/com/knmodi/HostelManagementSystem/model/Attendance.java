package com.knmodi.HostelManagementSystem.model;

public class Attendance
{
	private int attendance_id;
	private int student_id;
	private String date;
	private String status;
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attendance(int attendance_id, int student_id, String date, String status) {
		super();
		this.attendance_id = attendance_id;
		this.student_id = student_id;
		this.date = date;
		this.status = status;
	}
	public int getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Attendance [attendance_id=" + attendance_id + ", student_id=" + student_id + ", date=" + date
				+ ", status=" + status + "]";
	}
	
	
}