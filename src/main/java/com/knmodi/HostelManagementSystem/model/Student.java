package com.knmodi.HostelManagementSystem.model;


public class Student{
	//to store course id
	private int studentId;
	//to store course name
	private String studentname;
	//to store description of the course
	private String gender;
	//to store duration of the course
	private String contact;
	
	private String address;
	private int roomid;
	private String admissiondate;
	private String status;
	private int hostelid;
	
	
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Student(int studentId, String studentname, String gender, String contact, String address, int roomid,
			String admissiondate, String status, int hostelid) {
		super();
		this.studentId = studentId;
		this.studentname = studentname;
		this.gender = gender;
		this.contact = contact;
		this.address = address;
		this.roomid = roomid;
		this.admissiondate = admissiondate;
		this.status = status;
		this.hostelid = hostelid;
	}





	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getAdmissiondate() {
		return admissiondate;
	}
	public void setAdmissiondate(String admissiondate) {
		this.admissiondate = admissiondate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getHostelid() {
		return hostelid;
	}
	public void setHostelid(int hostelid) {
		this.hostelid = hostelid;
	}





	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentname=" + studentname + ", gender=" + gender + ", contact="
				+ contact + ", address=" + address + ", roomid=" + roomid + ", admissiondate=" + admissiondate
				+ ", status=" + status + ", hostelid=" + hostelid + "]";
	}
	
	
	
	
	

}