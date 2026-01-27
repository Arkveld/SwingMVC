package controller;

import model.Account;
import view.ViewAccount;

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
            System.out.println("Bouton Logout");
        });

    }
}
