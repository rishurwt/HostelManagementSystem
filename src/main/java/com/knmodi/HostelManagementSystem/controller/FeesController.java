package com.knmodi.HostelManagementSystem.controller;

import java.util.Scanner;
import com.knmodi.HostelManagementSystem.model.Fees;
import com.knmodi.HostelManagementSystem.service.FeesService;
import com.knmodi.HostelManagementSystem.service.impl.FeesServiceImpl;

public class FeesController {

    // Variable name camelCase mein hona chahiye (best practice)
    private FeesService feesService;

    // Constructor
    public FeesController() {
        // Service initialize kar rahe hain
        feesService = new FeesServiceImpl();
    }

    // UI to register fees
    public void registerFeesUI() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter fees id: (e.g, 44567) ");
        int fees_id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter student id: ");
        int student_id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter amount paid: ");
        int amount_paid = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter amount left: ");
        int amount_left = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Status: (e.g., Successful/Failed) ");
        String status = sc.nextLine();

        System.out.print("Enter date paid: (e.g., 12/01/2024) ");
        String date_paid = sc.nextLine();

        System.out.print("Enter receipt no: ");
        String receipt = sc.nextLine();

        // Data service ko bhej rahe hain
        feesService.registerFees(new Fees(fees_id, student_id, amount_paid, amount_left, status, date_paid, receipt));
    }

    public void showFees() {
        feesService.showFees();
    }

    public void showFeesOne() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student id to get fee info: ");
        int temp = sc.nextInt();
        feesService.showFeesOne(temp);
    }
}