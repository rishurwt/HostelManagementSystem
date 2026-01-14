package com.knmodi.HostelManagementSystem.dao;
import com.knmodi.HostelManagementSystem.model.Room; 
import java.util.ArrayList;
public interface RoomDAO 
{
	//method for inserting new course data
	int save(Room roomdata);
	void delete(int room_id);
	
	
	ArrayList<Room> findAll();
	
	ArrayList<Room> findOne(int r_id);

	
}
