package view;

import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewAccount {
    //Attributs
    JFrame frame;
    JPanel panel;
    JLabel label1, label2, label3;
    JButton btnDepot, btnRetrait, btnLogout;

    public ViewAccount(Account account) {
        initialize(account);
    }

    private void initialize(Account account){

        //******** Frame ********/
        this.frame = new JFrame();
        this.frame.setSize(720, 540);
        this.frame.setTitle("Bank App");
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //******** Panel ********/
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBackground(new Color(24, 26, 178));

        //******** Label ********/
        this.label1 = new JLabel("Titulaire du compte: " + account.getCustomer().getFirstname() + " " + account.getCustomer().getLastname());
        this.label1.setBounds(70, 60, 540, 50);
        this.label1.setFont(new Font("Noto Sans", Font.PLAIN, 32));
        this.label1.setForeground(Color.white);
        this.panel.add(this.label1);

        this.label2 = new JLabel("Votre solde:");
        this.label2.setBounds(230, 140, 120, 50);
        this.label2.setFont(new Font("Noto Sans", Font.PLAIN, 20));
        this.label2.setForeground(Color.white);
        this.panel.add(this.label2);

        this.label3 = new JLabel( account.getSolde() + "€");
        this.label3.setBounds(350, 140, 480, 50);
        this.label3.setFont(new Font("Noto Sans", Font.PLAIN, 34));
        this.label3.setForeground(Color.white);
        this.panel.add(this.label3);

        //******** Buttons ********/
        this.btnDepot = new JButton("Dépôt");
        this.btnDepot.setBounds(50, 350, 120, 50);
        this.panel.add(this.btnDepot);

        this.btnRetrait = new JButton("Retrait");
        this.btnRetrait.setBounds(190, 350, 120, 50);
        this.panel.add(this.btnRetrait);

        this.btnLogout = new JButton("Déconnexion");
        this.btnLogout.setBounds(480, 350, 120, 50);
        this.panel.add(this.btnLogout);

        //********** Affichage ********** /
        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }

    public void addButtonDepot(ActionListener listener){
        this.btnDepot.addActionListener(listener);
    }

    public void addButtonRetrait(ActionListener listener){
        this.btnRetrait.addActionListener(listener);
    }

    public void addButtonLogout(ActionListener listener){
        this.btnLogout.addActionListener(listener);
    }

    public void closeView() {
        this.frame.dispose();
    }

    public void viewMessage(String message){
        JOptionPane.showMessageDialog(this.frame, message);
    }
}
