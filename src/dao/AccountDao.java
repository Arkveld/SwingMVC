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
}
