package org.example;

import com.bhagya.practice.controller.BillingController;
import com.bhagya.practice.controller.FlightController;
import com.bhagya.practice.controller.PassengerController;
import com.bhagya.practice.controller.TicketController;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        final Scanner scanner = new Scanner(System.in);

        int option = 0;
        do  {

            System.out.println("Welcome to Airline booking System");
            System.out.println("Enter your option");
            System.out.println("1. Passenger Registration");
            System.out.println("2. information About Flight");
            System.out.println("3. book your Ticket here");
            System.out.println("4. For Concession Ticket");
            System.out.println("5. for booking History");
            System.out.println("6. for BillingAndCancellation");
            System.out.println("7. for Notification");
            System.out.println("0. Exit ");


            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    PassengerController passengerController = new PassengerController();
                    passengerController.run();
                    break;
                case 2:
                    FlightController flightController = new FlightController();
                    flightController.run();
                    break;
                case 3:
                    TicketController ticketController = new TicketController();
                    ticketController.run();
                    break;

                case 4:
                    BillingController billingController = new BillingController();
                    billingController.run();
                    break;

                case 0:
                    System.out.println("Back To Main Menu");
                    System.out.println("Enter your option");
                    System.out.println("1. Passenger Registration");
                    System.out.println("2. information About Flight");
                    System.out.println("3. book your Ticket here");
                    System.out.println("4. For Concession Ticket");
                    System.out.println("5. for booking History");
                    System.out.println("6. for BillingAndCancellation");
                    System.out.println("7. for Notification");
                    System.out.println("0. Exit ");
                default:
                    System.out.println("Invalid Otion");


            }



        }while (option != 0);

        System.out.println("Tnank You");

    }


    }

