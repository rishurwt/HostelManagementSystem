package com.knmodi.HostelManagementSystem.model;

public class Fees
{
	private int fees_id;
	private int student_id;
	private int amount_paid;
	private int amount_left;
	private String amount_status;
	private String date_paid;
	private String receipt_no;
	public Fees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fees(int fees_id, int student_id, int amount_paid, int amount_left, String amount_status, String date_paid,
			String receipt_no) {
		super();
		this.fees_id = fees_id;
		this.student_id = student_id;
		this.amount_paid = amount_paid;
		this.amount_left = amount_left;
		this.amount_status = amount_status;
		this.date_paid = date_paid;
		this.receipt_no = receipt_no;
	}
	public int getFees_id() {
		return fees_id;
	}
	public void setFees_id(int fees_id) {
		this.fees_id = fees_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(int amount_paid) {
		this.amount_paid = amount_paid;
	}
	public int getAmount_left() {
		return amount_left;
	}
	public void setAmount_left(int amount_left) {
		this.amount_left = amount_left;
	}
	public String getAmount_status() {
		return amount_status;
	}
	public void setAmount_status(String amount_status) {
		this.amount_status = amount_status;
	}
	public String getDate_paid() {
		return date_paid;
	}
	public void setDate_paid(String date_paid) {
		this.date_paid = date_paid;
	}
	public String getReceipt_no() {
		return receipt_no;
	}
	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}
	@Override
	public String toString() {
		return "Fees [fees_id=" + fees_id + ", student_id=" + student_id + ", amount_paid=" + amount_paid
				+ ", amount_left=" + amount_left + ", amount_status=" + amount_status + ", date_paid=" + date_paid
				+ ", receipt_no=" + receipt_no + "]";
	}
	
	
}