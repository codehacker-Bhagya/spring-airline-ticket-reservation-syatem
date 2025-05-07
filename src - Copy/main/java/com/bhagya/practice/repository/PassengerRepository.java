package com.bhagya.practice.repository;

import com.bhagya.practice.model.Passenger;
import com.bhagya.practice.service.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepository {

    private static Connection connection = null;


    private void initConection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection =  new ConnectionService().getConnection();
        }
    }

    List<Passenger> passengerList = new ArrayList<>();

    public boolean acceptPassenger(Passenger passenger){
        try{
            this.initConection();
            Statement statement = connection.createStatement();
            return statement.execute("insert into passenger(passengerUID , Name ," +
                    "contactNo , city) values " + "("+passenger.getUIDno()+", '"+passenger.getName()+" ' ," +
                    " ' "+passenger.getMoNo()+" ' )");
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
        finally {
            //close the connection

            if(connection != null){
                try{
                    connection.close();
                }catch(SQLException e){
                    System.err.println("connection is closed: "+e.getMessage());
                }
            }
        }
    }

    public List<Passenger> displayPassenger(Passenger passenger){
        List<Passenger> traveller = new ArrayList<>();

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery("select * from passenger");
            while(resultSet.next()){
                String fullName = resultSet.getString("fullName");
                long MoNo = resultSet.getLong("MoNo");
                long UIDno = resultSet.getLong("UIDno");
                traveller.add(passenger);
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

        return traveller;
    }

    private void initConnection() {
    }


    public boolean deletePassenger(long UIDno) throws SQLException {

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            return statement.execute("delete from pessenger where UIDno= "+UIDno);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("connection is closed: "+e.getMessage());
                }
            }
        }

    }
}
