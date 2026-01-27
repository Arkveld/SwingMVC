package controller;

import dao.AccountDao;
import model.Account;
import model.Customer;
import view.ViewHome;
import view.ViewRegister;

import javax.swing.*;

public class HomeController {
    //Attribut
    //Pas besoin de model pour ce controller
    private ViewHome viewHome;

    public HomeController(ViewHome viewHome) {
        this.viewHome = viewHome;
        //Évenements pour les boutons
        viewHome.addButtonLoginListener(e -> {
            //Récupère les données du formulaire
            String email = viewHome.getInputMail();
            String password = viewHome.getPasswordField();
            if(email.isEmpty() || password.isEmpty()){
                viewHome.viewMessage("Veuillez remplir tous les champs du formulaire");
            } else {
                login(email, password);
            }
        });
        viewHome.addButtonRegisterListener(e -> {
            viewHome.closeView();
            new RegisterController(new ViewRegister());
        });
    }
    private void login (String email, String password){
        AccountDao accountDao = new AccountDao();
        Customer customer = accountDao.getCustomerByMail(email);
        if(customer.getEmail() == null){
            viewHome.viewMessage("Échec login");
        } else if(!customer.getPassword().equals(password)){
            viewHome.viewMessage("Échec login");
        } else {
            viewHome.viewMessage("Authentification réussie");
            Account account = accountDao.getAccountByCustomer(customer.getIdCustomer());
        }
    }
}
