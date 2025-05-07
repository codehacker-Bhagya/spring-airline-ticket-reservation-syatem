package com.bhagya.practice.controller;

import com.bhagya.practice.Exception.InvalidUidException;
import com.bhagya.practice.service.FlightService;

import java.sql.SQLException;
import java.util.Scanner;

public class FlightController {

    private Scanner scanner = new Scanner(System.in);

    public void run() throws NumberFormatException, SQLException {

        int option = 0;

        FlightService flightService = new FlightService();
        do {
            System.out.println("Enter Your Option");
            System.out.println("1. Flight Information");
            System.out.println("2. Display Flight");
            System.out.println("3. Delete Flight");
            System.out.println("0. Back to main menu");

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    try {
                        flightService.flightData();
                    } catch (NumberFormatException | InvalidUidException | SQLException e) {
                        System.err.println(e.getMessage());
                    }

                    break;

                case 2:
                    flightService.displayFlight();

                    break;

                case 3:
                    flightService.deleteFlight();



            }
        }while(option != 0);
        {
            System.out.println("THANK YOU!!!");
        }
    }
}
