package com.bhagya.practice.controller;

import com.bhagya.practice.Exception.InvalidUidException;
import com.bhagya.practice.service.PassengerService;

import java.sql.SQLException;
import java.util.Scanner;

public class PassengerController {

    // private final PassengerService passengerService = new PassengerService();
    private final Scanner sc = new Scanner(System.in);

    public void run() throws NumberFormatException, SQLException {

        int option = 0;

        PassengerService passengerService = new PassengerService();
        do {
            System.out.println("......Passenger Management......");
            System.out.println("1...Add Passenger");
            System.out.println("2...View Passenger");
            System.out.println("0...Back To Main Menu");

            System.out.println("Please Enter Your Option");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    try {
                        passengerService.acceptPassenger();
                    } catch (NumberFormatException | InvalidUidException | SQLException e) {
                        System.err.println(e.getMessage());
                    }

                    break;

                case 2:
                    passengerService.displayPassenger();
                    break;

                case 3:
                    passengerService.deletePassenger();
            }

        } while (option != 0);
        {
            System.out.println("THANK YOU");
        }
    }
}
