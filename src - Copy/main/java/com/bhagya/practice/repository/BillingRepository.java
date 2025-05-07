package com.bhagya.practice.repository;

import com.bhagya.practice.model.Billing;
import com.bhagya.practice.service.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BillingRepository {

    private static Connection connection = null;

    private void initConection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = (Connection) new ConnectionService().getConnection();
        }
    }

    List<Billing> billingList = new ArrayList<>();

    public boolean acceptBill(Billing billing){
        try{
            this.initConection();
            Statement statement = connection.createStatement();
            return statement.execute("insert into billing(paymentMethod , " +
                    "UPIid , ) values " + "("+billing.getpaymentMethod()+", '"+billing.getUPIid()+" ')");
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

    public List<Billing> displayBilling(Billing billing){
        List<Billing> bills = new ArrayList<>();

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery("select * from billing");
            while(resultSet.next()){
                String paymentMethod = resultSet.getString("paymentMethod");
                int UPIid = resultSet.getInt("UPIid");

                bills.add(billing);
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

        return bills;
    }

    private void initConnection() {

    }

    public boolean deleteBilling(int UPIid) throws SQLException {

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            return statement.execute("delete from billing where UPIid= "+UPIid);
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
