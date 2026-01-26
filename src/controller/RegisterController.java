package controller;

import dao.AccountDao;
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

            //Récupère les données du formulaire
            String firstname = viewRegister.getInputFirstname();
            String lastname = viewRegister.getInputLastName();
            String email = viewRegister.getInputEmail();
            String password = viewRegister.getInputPassword();

            //Vérifiz si tous les champs sont remplis
            if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty()){
                viewRegister.viewMessage("Veuillez remplir tous les champs du formulaire");
            } else {
                //Instance d'un client
                Customer customer = new Customer(firstname, lastname, email, password);
                //Instance d'un account
                Account account = new Account(customer);
                //Instance de la dao
                AccountDao accountDao = new AccountDao();
                //Envoi vers la BDD
                if(accountDao.register(account)){
                    viewRegister.viewMessage("Inscription réussie");
                    //Redirection
                    viewRegister.closeView();
                    new HomeController(new ViewHome());
                } else {
                    viewRegister.viewMessage("Échec de lors l'inscription");
                }
            }
        });
    }
}
