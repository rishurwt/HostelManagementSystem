package com.knmodi.HostelManagementSystem.dao.impl;

import com.knmodi.HostelManagementSystem.dao.RoomDAO;
import com.knmodi.HostelManagementSystem.model.Room;
import com.knmodi.HostelManagementSystem.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public int save(Room roomdata) {
        int insertedRows = 0;
        String sql = "INSERT INTO room (room_id, room_no, capacity, occupied) VALUES (?,?,?,?)";

        try (Connection con = DataBaseUtil.establishConnection()) {
            if (con != null) {
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, roomdata.getRoom_id());
                    ps.setString(2, roomdata.getRoom_no());
                    ps.setInt(3, roomdata.getCapacity());
                    ps.setInt(4, roomdata.getOccupied());

                    insertedRows = ps.executeUpdate();
                }
            }
        } catch (SQLException sqe) {
            System.out.println("Error saving room: " + sqe.getMessage());
        }
        return insertedRows;
    }

    @Override
    public void delete(int room_id) {
        String sql = "DELETE FROM room WHERE room_id = ?";
        try (Connection con = DataBaseUtil.establishConnection()) {
            if (con != null) {
                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                    stmt.setInt(1, room_id);
                    stmt.executeUpdate();
                }
            }
        } catch (SQLException sqe) {
            System.out.println("Error deleting room: " + sqe.getMessage());
        }
    }

    @Override
    public ArrayList<Room> findAll() {
        ArrayList<Room> RoomList = new ArrayList<>();
        String sqlQuery = "SELECT room_id, room_no, capacity, occupied FROM room";

        try (Connection con = DataBaseUtil.establishConnection()) {
            if (con != null) {
                try (Statement stmt = con.createStatement();
                     ResultSet result = stmt.executeQuery(sqlQuery)) {
                     
                    while (result.next()) {
                        Room room = new Room();
                        room.setRoom_id(result.getInt(1));
                        room.setRoom_no(result.getString(2));
                        room.setCapacity(result.getInt(3));
                        room.setOccupied(result.getInt(4));
                        RoomList.add(room);
                    }
                }
            }
        } catch (SQLException sqe) {
            System.out.println("Error finding all rooms: " + sqe.getMessage());
        }
        return RoomList;
    }

    @Override
    public ArrayList<Room> findOne(int room_id) {
        ArrayList<Room> RoomList = new ArrayList<>();
        String sqlQuery = "SELECT room_id, room_no, capacity, occupied FROM room WHERE room_id=?";

        try (Connection con = DataBaseUtil.establishConnection()) {
            if (con != null) {
                try (PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
                    pstmt.setInt(1, room_id);
                    try (ResultSet result1 = pstmt.executeQuery()) {
                        while (result1.next()) {
                            Room room = new Room();
                            room.setRoom_id(result1.getInt(1));
                            room.setRoom_no(result1.getString(2));
                            room.setCapacity(result1.getInt(3));
                            room.setOccupied(result1.getInt(4));
                            RoomList.add(room);
                        }
                    }
                }
            }
        } catch (SQLException sqe) {
            System.out.println("Error finding room: " + sqe.getMessage());
        }
        return RoomList;
    }
}