package com.bhagya.practice.repository;

import com.bhagya.practice.model.Flight;
import com.bhagya.practice.service.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {

    private static Connection connection = null;

    private void initConection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = (Connection) new ConnectionService().getConnection();
        }
    }

    List<Flight> flightList = new ArrayList<>();

    public boolean flightData(Flight flight){
        try{
            this.initConection();
            Statement statement = connection.createStatement();
            return statement.execute("insert into flight(flightNo , Name ," +
                    "destination ) values " + "("+flight.getflightNo()+", '"+flight.getName()+" ' ," +
                    " ' "+flight.getdestination()+" ' )");
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


    public List<Flight> displayflight(Flight flight){
        List<Flight> people = new ArrayList<>();

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery("select * from flight");
            while(resultSet.next()){
                String flightName = resultSet.getString("flightName");
                int flightNo = resultSet.getInt("flightNo");
                int flightTime = resultSet.getInt("flightTime");
                people.add(flight);
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

        return people;
    }

    private void initConnection() {
    }

    public boolean deleteflight(int flightNo) throws SQLException {

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            return statement.execute("delete from flight where flightNo= "+flightNo);
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
