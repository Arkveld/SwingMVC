package view;

import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewRetrait {
    //Attributs
    JFrame frame;
    JPanel panel;
    JLabel label1, label2;
    JTextField montant;
    JButton button;

    public ViewRetrait(Account account) {
        initialize(account);
    }

    private void initialize(Account account){

        this.frame = new JFrame();
        this.frame.setSize(720, 540);
        this.frame.setTitle("Bank App");
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //******************* Panel ******************/
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBackground(new Color(24, 26, 178));

        //************ label (Titre) ****************/
        this.label1 = new JLabel("Retrait");
        this.label1.setBounds(290, 10, 480, 80);
        this.label1.setFont(new Font("Noto Sans", Font.PLAIN, 28));
        this.label1.setForeground(Color.white);
        this.panel.add(this.label1);

        //************** Formulaire **********************/
        this.label2 = new JLabel("Veuillez saisir un montant");
        this.label2.setBounds(170, 100, 400, 20);
        this.label2.setFont(new Font("Noto Sans", Font.PLAIN, 18));
        this.label2.setForeground(Color.white);
        this.panel.add(this.label2);

        //*********** Input ***********/
        this.montant = new JTextField();
        this.montant.setBounds(170, 130, 480, 30);
        this.panel.add(this.montant);

        //*********** Bouton ***********/
        this.button = new JButton("Retirer");
        this.button.setBackground(Color.green);
        this.button.setForeground(Color.white);
        this.button.setBounds(170, 190, 100, 50);
        this.panel.add(this.button);

        //********** Affichage **********/
        this.frame.add(this.panel);
        this.frame.setVisible(true);

    }

    public int getInputMontant(){
        return Integer.parseInt(this.montant.getText());
    }

    public void addButton(ActionListener listener){
        this.button.addActionListener(listener);
    }

    public void closeView(){
        this.frame.dispose();
    }

    public void viewMessage(String message){
        JOptionPane.showMessageDialog(this.frame, message);
    }
}
