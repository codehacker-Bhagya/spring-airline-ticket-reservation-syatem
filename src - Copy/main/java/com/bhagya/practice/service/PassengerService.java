package com.bhagya.practice.service;

import com.bhagya.practice.Exception.InvalidContactNoException;
import com.bhagya.practice.Exception.InvalidUidException;
import com.bhagya.practice.model.Passenger;
import com.bhagya.practice.repository.PassengerRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassengerService {

    private final PassengerRepository passengerRepository = new PassengerRepository();

    public static final Scanner scanner = new Scanner(System.in);
    int passengerIndex = 0;

    List<Passenger> passengerList = new ArrayList<>();


    public void passengerData(Passenger passenger) {
        System.out.println(passenger);
    }

    public boolean acceptPassenger() throws NumberFormatException , SQLException {



        System.out.println("Enter Your full Name");
        String Name = scanner.nextLine();

        System.out.println("Enter Your Contact No");
        long MoNo = 0;
        try {
            MoNo = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("contact No must be in ten digit. Pls Enter Valid contact no");
        }
        if (MoNo != 10) {
            // System.out.println("Enter valid input");
        } else {
            throw new InvalidContactNoException("Ennter correct contact no");
        }

        System.out.println("Enter Your Uid No");
        long UIDno =0L;
        try{
            UIDno = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e){
            throw new NumberFormatException("Please enter valid no");
        }
        if(UIDno != 12){

        }else{
            throw new InvalidUidException("Pls Enter 12 digit uid no");
        }
        Passenger passenger = new Passenger();
        //  passenger.setfullName(fullName);


        return passengerRepository.acceptPassenger(passenger);
    }

    public List<Passenger>  displayPassenger() {
        Passenger passenger = new Passenger();
        List<Passenger> passengerList1 = passengerRepository.displayPassenger(passenger);

        System.out.println("passenger : " +passengerList1);

        return passengerList1;

        // if we want to give some discount or filter records by using stream()
        // we need to convert class to record

//        List<Person> people = personList.stream() //streaming object
//                .parallel() // parallel processing
//                .filter(person -> person.setGender("female"))  // if-else condition
//                .map(person -> person)
//                .toList();  // creating list of filtered data


    }

    public void deletePassenger() throws SQLException{
        Passenger passenger = new Passenger();
        try{
            if(passengerRepository.deletePassenger(passenger.getUIDno())){
                System.out.println("Passenger deleted successfully");
            }else {
                System.out.println("Passenger not deleted");
            }
        }catch (SQLException e){
            throw new SQLException(e);
        }
    }
}
