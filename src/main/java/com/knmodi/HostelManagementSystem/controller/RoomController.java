package com.knmodi.HostelManagementSystem.controller;

import java.util.Scanner;
import com.knmodi.HostelManagementSystem.model.Room;
import com.knmodi.HostelManagementSystem.service.RoomService;
import com.knmodi.HostelManagementSystem.service.impl.RoomServiceImpl;

public class RoomController {

    private RoomService roomService;

    // Constructor
    public RoomController() {
        // Service initialize kar rahe hain
        roomService = new RoomServiceImpl();
    }

    // UI to register room
    public void registerRoomUI() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter room id: ");
        int room_id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter room number: ");
        String room_no = sc.nextLine();

        System.out.print("Enter capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter occupied count: ");
        int occupied = sc.nextInt();
        sc.nextLine(); 

        // Data service ko bhej rahe hain
        roomService.registerRoom(new Room(room_id, room_no, capacity, occupied));
    }

    public void showRoom() {
        roomService.showRoom();
    }

    public void showRo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter room id to search:");
        int r_id = sc.nextInt();
        roomService.showRoomId(r_id);
    }
}