package controller;

import dao.AccountDao;
import model.Account;
import view.ViewAccount;
import view.ViewDepot;

public class DepotController {

    private ViewDepot viewDepot;
    private Account account;

    public DepotController(ViewDepot viewDepot, Account account) {
        this.viewDepot = viewDepot;
        this.account = account;
        viewDepot.addButton(e -> {
            int amount = viewDepot.getInputMontant();
            AccountDao accountDao = new AccountDao();

            if(!accountDao.depot(account, amount)){
                viewDepot.viewMessage("Échec de l'opération");
            } else {
                viewDepot.viewMessage("Votre compte a été acréditer");
            }
            viewDepot.closeView();
            new AccountController(new ViewAccount(account), account);
        });
    }
}
