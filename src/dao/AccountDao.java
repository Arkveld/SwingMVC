package dao;

import core.DbConnection;
import model.Account;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {

    public AccountDao() {
    }

    public boolean register(Account account){
       try {
           String sql = "INSERT INTO customers (firstname, lastname, email, password) VALUES (?, ?, ?, ?)";
           String sql2 = "INSERT INTO account (customer_id, solde) VALUES (?, ?)";
           Connection con;
           PreparedStatement ps;
           ResultSet rs;
           int id = 0;

           con = DbConnection.seConnecter();
           ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
           ps.setString(1, account.getCustomer().getFirstname());
           ps.setString(2, account.getCustomer().getLastname());
           ps.setString(3, account.getCustomer().getEmail());
           ps.setString(4, account.getCustomer().getPassword());

           ps.executeUpdate();
           //On récupère le dernier id insérée
           rs = ps.getGeneratedKeys();
           if(rs.next()){
               id = rs.getInt(1);
           }

           ps = con.prepareStatement(sql2);
           ps.setInt(1, id);
           ps.setInt(2, account.getSolde());
           ps.executeUpdate();

           rs.close();
           ps.close();
           con.close();
           return true;


       } catch (SQLException e) {
           System.out.println("Erreurs dans nos serveurs");
           System.out.println(e.getMessage());
           return false;
       }
    }

    public Customer getCustomerByMail(String mail){
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            String sql = "SELECT * FROM customers WHERE email=?";
            con = DbConnection.seConnecter();
            ps = con.prepareStatement(sql);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            Customer customer = new Customer();
            while (rs.next()){
                customer.setIdCustomer(rs.getInt("id_customers"));
                customer.setFirstname(rs.getString("firstname"));
                customer.setLastname(rs.getString("lastname"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
            }
            rs.close();
            ps.close();
            con.close();
            return customer;
        } catch (SQLException e){
            System.out.println("Erreur dans nos serveurs");
            return null;
        }
    }

    public Account getAccountByCustomer(int id){
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "Select * from customers\n" +
                "Right Join account on customers.id_customers = account.customer_id\n" + "Where id_customers=?";
        try {
            con = DbConnection.seConnecter();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            //Instance de Account
            Customer customer = new Customer();
            int solde = 0;
            while (rs.next()){
                customer.setIdCustomer(rs.getInt("id_customers"));
                customer.setFirstname(rs.getString("firstname"));
                customer.setLastname(rs.getString("lastname"));
                solde = rs.getInt("solde");
            }
            Account account = new Account(customer);
            account.setSolde(solde);

            rs.close();
            ps.close();
            con.close();
            return account;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean depot(Account account, int amount){
        if(amount < 0){
            return false;
        } else {
            account.setSolde(account.getSolde() + amount);
            //Mise à jour dans la BDD
            String sql = "UPDATE account SET solde =? WHERE customer_id =?";
            Connection con;
            PreparedStatement ps;

            try {
                con = DbConnection.seConnecter();
                ps = con.prepareStatement(sql);
                ps.setInt(1, account.getSolde());
                ps.setInt(2, account.getCustomer().getIdCustomer());
                ps.executeUpdate();

                ps.close();
                con.close();
                return true;
            } catch (Exception e){
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
}
