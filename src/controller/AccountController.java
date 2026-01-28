package controller;

import model.Account;
import view.ViewAccount;
import view.ViewHome;

import java.util.SequencedSet;

public class AccountController {
    private ViewAccount viewAccount;

    public AccountController(ViewAccount viewAccount) {
        this.viewAccount = viewAccount;

        viewAccount.addButtonDepot(e->{
            System.out.println("Bouton Dépôt");
        });

        viewAccount.addButtonRetrait(e-> {
            System.out.println("Bouton Retrait");
        });

        viewAccount.addButtonLogout(e-> {
            viewAccount.closeView();
            new HomeController(new ViewHome());
        });

    }
}
