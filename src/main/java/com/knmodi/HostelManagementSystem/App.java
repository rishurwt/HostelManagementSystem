package com.knmodi.HostelManagementSystem;

import java.util.Scanner;
import com.knmodi.HostelManagementSystem.util.DataBaseUtil;
import com.knmodi.HostelManagementSystem.controller.StudentController;
import com.knmodi.HostelManagementSystem.controller.RoomController;
import com.knmodi.HostelManagementSystem.controller.FeesController;
import com.knmodi.HostelManagementSystem.controller.AttendanceController;

public class App {
    public static void main(String[] args) {
        System.out.println("Hostel Management System Started...");

        // Ensure tables exist
        DataBaseUtil.createTables();

        // Poore application ke liye ek hi Scanner use karna chahiye
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose one of the following role\n"
                + "1. Student \n"
                + "2. Warden");
        
        int choice = sc.nextInt();

        switch (choice) {
            case 1: // Student Role
                int studentChoice;
                do {
                    System.out.println("\n---------------- STUDENT MODULE ----------------");
                    System.out.println("1. Your Information");
                    System.out.println("2. Your Room");
                    System.out.println("3. Your Fees");
                    System.out.println("4. Your Attendance");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");

                    studentChoice = sc.nextInt();

                    switch (studentChoice) {
                        case 1:
                            new StudentController().showByStudId();
                            break;
                        case 2:
                            new RoomController().showRo();
                            break;
                        case 3:
                            new FeesController().showFeesOne();
                            break;
                        case 4:
                            new AttendanceController().showAttendanceOne();
                            break;
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            System.out.println("This feature is coming soon...");
                            break;
                        case 0:
                            System.out.println("Exiting Student Module...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } while (studentChoice != 0);
                break;

            case 2: // Warden Role
                int wardenChoice;
                do {
                    System.out.println("\n---------------- WARDEN MODULE ----------------");
                    System.out.println("--- Room Methods ---");
                    System.out.println("1. Insert Room Information");
                    System.out.println("2. Read all Room Information");
                    System.out.println("3. Read by Room ID");
                    System.out.println("--- Student Methods ---");
                    System.out.println("4. Insert Student Information");
                    System.out.println("5. Delete Student Information");
                    System.out.println("6. Access all Student Information");
                    System.out.println("7. Read by Student ID");
                    System.out.println("--- Fees Methods ---");
                    System.out.println("8. Insert Fees Information");
                    System.out.println("9. Access all Fees Information");
                    System.out.println("10. About Student's Fees");
                    System.out.println("--- Attendance Methods ---");
                    System.out.println("11. Insert Attendance Information");
                    System.out.println("12. Access All Attendance Information");
                    System.out.println("13. Access Student's Attendance");
                    System.out.println("--- Other ---");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");

                    wardenChoice = sc.nextInt();

                    switch (wardenChoice) {
                        case 1:
                            new RoomController().registerRoomUI();
                            break;
                        case 2:
                            new RoomController().showRoom();
                            break;
                        case 3:
                            new RoomController().showRo();
                            break;
                        case 4:
                            new StudentController().registerStudentUI();
                            break;
                        case 5:
                            new StudentController().deleteStudentUI();
                            break;
                        case 6:
                            new StudentController().showStudent();
                            break;
                        case 7:
                            new StudentController().showByStudId();
                            break;
                        case 8:
                            new FeesController().registerFeesUI();
                            break;
                        case 9:
                            new FeesController().showFees();
                            break;
                        case 10:
                            new FeesController().showFeesOne();
                            break;
                        case 11:
                            new AttendanceController().registerAttendanceUI();
                            break;
                        case 12:
                            new AttendanceController().showAttendance();
                            break;
                        case 13:
                            new AttendanceController().showAttendanceOne();
                            break;
                        case 14: // Visitors
                        case 15:
                        case 16: // Complaints
                        case 17:
                            System.out.println("Feature not implemented yet.");
                            break;
                        case 0:
                            System.out.println("System Closed");
                            break;
                        default:
                            System.out.println("Invalid choice. Enter a valid number.");
                    }
                } while (wardenChoice != 0);
                break;

            default:
                System.out.println("Invalid Role Selected.");
        }
        
        // Closing scanner is good practice
        sc.close();
    }
}