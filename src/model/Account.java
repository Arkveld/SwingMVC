package model;

public class Account {
    // ************ Attributs ************
    private int idAccount;
    private Customer customer;
    private int solde;
    private int idCustomer;

    // ************ Constructeur ************
    public Account() {
    }

    public Account(Customer customer) {
        this.customer = customer;
        this.solde = 0;
    }

    // ************ Getter et Setter ************
    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
}
