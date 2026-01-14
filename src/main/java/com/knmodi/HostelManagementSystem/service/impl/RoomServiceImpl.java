package com.knmodi.HostelManagementSystem.service.impl;

import com.knmodi.HostelManagementSystem.dao.RoomDAO;
import com.knmodi.HostelManagementSystem.dao.impl.RoomDAOImpl;
import com.knmodi.HostelManagementSystem.model.Room;
import com.knmodi.HostelManagementSystem.service.RoomService;
import java.util.ArrayList;

public class RoomServiceImpl implements RoomService {
    
    private RoomDAO roomDAO;

    public RoomServiceImpl() {
        roomDAO = new RoomDAOImpl();
    }

    @Override
    public void registerRoom(Room room) {
        if (room == null) {
            System.out.println("Room data is empty");
        } else {
            int rows = roomDAO.save(room);
            if (rows > 0) {
                System.out.println("Room Successfully Registered");
            } else {
                System.out.println("Unable to register the room");
            }
        }
    }

    @Override
    public void showRoom() {
        ArrayList<Room> roomList = roomDAO.findAll();
        if (roomList.size() > 0) {
            System.out.println(roomList);
        } else {
            System.out.println("No room data found");
        }
    }

    @Override
    public void showRoomId(int r_id) {
        ArrayList<Room> roomList = roomDAO.findOne(r_id);
        if (roomList.size() > 0) {
            System.out.println(roomList);
        } else {
            System.out.println("No room data found for ID: " + r_id);
        }
    }
}