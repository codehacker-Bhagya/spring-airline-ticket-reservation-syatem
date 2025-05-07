package com.bhagya.practice.service;

import com.bhagya.practice.Exception.InvalidContactNoException;
import com.bhagya.practice.model.Ticket;
import com.bhagya.practice.repository.TicketRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketService {
    private final TicketRepository ticketRepository = new TicketRepository();

    private static final Scanner scanner = new Scanner(System.in);
    int passengerIndex = 0;

    List<Ticket> ticketList = new ArrayList<>();


    public void tickeBooking(Ticket ticket) {
        System.out.println(ticket);
    }



    public boolean  ticketInfo() throws NumberFormatException, SQLException {


        Ticket ticket = new Ticket();
        System.out.println("Enter Your Seat Preference");
        String Preference = scanner.nextLine();

        System.out.println("Enter Your ticketNo");
        int ticketNo = 0;
        try {
            ticketNo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("contact No must be in 5 digit. Pls Enter Valid seat no");
        }
        if (ticketNo != 5) {
            // System.out.println("Enter valid input");
        } else {
            throw new InvalidContactNoException("Ennter correct contact no");
        }

        System.out.println("Enter Your Destionation");
        String Destination = scanner.nextLine();

        System.out.println("Do you Wnat Add meal");
        String meal = scanner.nextLine();

        System.out.println("Your Total Amount");
        System.out.println("Your Ticket Amount Is : 5000Rs." + "Meal Charge = 1000rs"  + "CGST = 400rs"  + "Total amount is:6400rs");

        ticket.setSeatPreference(Preference);
        ticket.setDestination(Destination);
        ticket.setAddMeal(meal);


        return ticketRepository.ticketInfo(ticket);

    }

    public List<Ticket>  displayTicket() {
        Ticket ticket = new Ticket();
        List<Ticket> ticketList1 = ticketRepository.displayTicket(ticket);

        System.out.println("ticket : " + ticketList1);

        return ticketList1;

    }

    public void deleteTicket() throws SQLException{
        Ticket ticket = new Ticket();
        try{
            if(ticketRepository.deleteTicket(ticket.getticketNo())){
                System.out.println("Ticket deleted successfully");
            }else {
                System.out.println("Ticket not deleted");
            }
        }catch (SQLException e){
            throw new SQLException(e);
        }
    }
}
