package controller;

import dao.AccountDao;
import model.Account;
import view.ViewAccount;
import view.ViewRetrait;

public class RetraitController {
    private ViewRetrait viewRetrait;
    private Account account;

    public RetraitController(ViewRetrait viewRetrait, Account account) {
        this.viewRetrait = viewRetrait;
        this.account = account;

        viewRetrait.addButton(e-> {
            //Récupérer le montant
            int amount = viewRetrait.getInputMontant();
            AccountDao accountDao = new AccountDao();
            if(!accountDao.retrait(account, amount)){
                viewRetrait.viewMessage("Échec de l'opération");
            } else {
                viewRetrait.viewMessage("Votre compte a été débiter");
            }
            viewRetrait.closeView();
            new AccountController(new ViewAccount(account), account);
        });
    }
}
