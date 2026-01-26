package controller;

import model.Account;
import model.Customer;
import view.ViewHome;
import view.ViewRegister;

import javax.swing.*;

public class RegisterController {
    private ViewRegister viewRegister;

    public RegisterController(ViewRegister viewRegister) {
        this.viewRegister = viewRegister;

        viewRegister.addButtonHome(e-> {
            viewRegister.closeView();
            new HomeController(new ViewHome());
        });

        viewRegister.addButtonRegister(e-> {
            String firstname = viewRegister.getInputFirstname();
            String lastname = viewRegister.getInputlastName();
            String email = viewRegister.getInputEmail();
            String password = viewRegister.getInputPassword();

            //Instance d'un client
            Customer customer = new Customer(firstname, lastname, email, password);
            //Instance d'un account
            Account account = new Account(customer);
            viewRegister.viewMessage(account.getCustomer().getFirstname());
        });
    }

}
