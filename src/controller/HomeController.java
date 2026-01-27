package controller;

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
        });
        viewHome.addButtonRegisterListener(e -> {
            viewHome.closeView();
            new RegisterController(new ViewRegister());
        });
    }
}
