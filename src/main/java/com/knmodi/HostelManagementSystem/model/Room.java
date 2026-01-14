package com.knmodi.HostelManagementSystem.model;

public class Room
{
	private int room_id;
	private String room_no;
	private int capacity;
	private int occupied;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(int room_id, String room_no, int capacity, int occupied) {
		super();
		this.room_id = room_id;
		this.room_no = room_no;
		this.capacity = capacity;
		this.occupied = occupied;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getOccupied() {
		return occupied;
	}
	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}
	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", room_no=" + room_no + ", capacity=" + capacity + ", occupied=" + occupied
				+ "]";
	}
	
	
}