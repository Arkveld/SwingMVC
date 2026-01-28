package controller;

import model.Account;
import view.ViewAccount;
import view.ViewDepot;
import view.ViewHome;

import java.util.SequencedSet;

public class AccountController {
    private ViewAccount viewAccount;
    private Account account;

    public AccountController(ViewAccount viewAccount, Account account) {
        this.viewAccount = viewAccount;
        this.account = account;

        viewAccount.addButtonDepot(e->{
           viewAccount.closeView();
           new DepotController(new ViewDepot(account), account);
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
