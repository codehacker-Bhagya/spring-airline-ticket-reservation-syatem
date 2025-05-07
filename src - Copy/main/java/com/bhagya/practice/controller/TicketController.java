package com.bhagya.practice.controller;

import com.bhagya.practice.Exception.InvalidUidException;
import com.bhagya.practice.service.TicketService;

import java.sql.SQLException;
import java.util.Scanner;

public class TicketController {

    private final Scanner sc = new Scanner(System.in);

    public void run() throws NumberFormatException, SQLException {

        int option = 0;

        TicketService ticketService = new TicketService();
        do {
            System.out.println("Pls Select Your Option");
            System.out.println("......Ticket Managemant...........");
            System.out.println("1. Book ticket...");
            System.out.println("2. View Ticket");
            System.out.println("3. View Flight");
            System.out.println("0. Back to main menu");

            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    try {
                        ticketService.ticketInfo();
                    } catch (NumberFormatException | InvalidUidException | SQLException e) {
                        System.err.println(e.getMessage());
                    }

                    break;

                case 2:
                    ticketService.displayTicket();

                    break;

                case 3:
                    ticketService.deleteTicket();


            }

        } while (option != 0);

        {
            System.out.println("THANK YOU !!!");
        }
    }
}
