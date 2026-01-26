package dao;

import core.DbConnection;
import model.Account;

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
}
