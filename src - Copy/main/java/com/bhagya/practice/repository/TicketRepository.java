package com.bhagya.practice.repository;

import com.bhagya.practice.model.Ticket;
import com.bhagya.practice.service.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository {

    private static Connection connection = null;

    private void initConection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection =(Connection) new ConnectionService().getConnection();
        }
    }

    List<Ticket> ticketList = new ArrayList<>();

    public boolean ticketInfo(Ticket ticket){
        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            return statement.execute("insert into ticket(seatPreference , AddMeal ," +
                    "destination , ticketAmount) values " + "("+ticket.getseatPreference()+", '"+ticket.getticketNo()+" ' ," +
                    " ' "+ticket.getTicketAmount()+" , '"+ticket.getDestination()+" ' )");
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
        finally {
            //close the connection

            if(connection!= null){
                try{
                    connection.close();;
                }catch(SQLException e){
                    System.err.println("connection is closed: "+e.getMessage());
                }
            }
        }
    }

    public List<Ticket> displayTicket(Ticket ticket){
        List<Ticket> tickets = new ArrayList<>();

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery("select * from ticket");
            while(resultSet.next()){
                String destination = resultSet.getString("destination");
                int ticketNo = resultSet.getInt("TicketNo");
                String seatPreference= resultSet.getString("seatPreference");
                tickets.add(ticket);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                try{
                    connection.close();
                }catch(SQLException e){
                    System.out.println("connection is closed: " +e.getMessage());
                }
            }
        }

        return tickets;
    }

    private void initConnection() {
    }

    public boolean deleteTicket(int ticketNo) throws SQLException {

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            return statement.execute("delete from ticket where ticketNo= "+ticketNo);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("connection is closed: "+e.getMessage());
                }
            }
        }

    }
}
