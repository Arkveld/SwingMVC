package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewHome {
    //Attributs
    JFrame frame;
    JPanel panel;
    JButton btnRegister, btnLogin;
    JLabel label1, label2;
    JTextField mailField;
    JPasswordField passwordField;

    public ViewHome() {
        initialize();
    }
    private void initialize(){
        this.frame = new JFrame();
        this.frame.setSize(720, 540);
        this.frame.setTitle("Bank App");
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBackground(new Color(24, 26, 178));

        //************** Label **********************/
        this.label1 = new JLabel("Bank App");
        this.label1.setBounds(290, 15, 200, 80);
        this.label1.setFont(new Font("Noto Sans", Font.BOLD, 38));
        this.label1.setForeground(Color.YELLOW);
        this.panel.add(this.label1);

        this.label2 = new JLabel("Bienvenue veuillez vous identifiez");
        this.label2.setBounds(170, 70, 480, 80);
        this.label2.setFont(new Font("Noto Sans", Font.PLAIN, 28));
        this.label2.setForeground(Color.white);
        this.panel.add(this.label2);

        //************** Input **********************/
        this.mailField = new JTextField("Email");
        this.mailField.setBounds(200, 160, 400, 30);
        this.panel.add(this.mailField);

        this.passwordField = new JPasswordField("Password");
        this.passwordField.setBounds(200,210, 400, 30);
        this.panel.add(this.passwordField);

        //************** Button **********************/
        this.btnLogin = new JButton("Valider");
        this.btnLogin.setBounds(500, 260, 100, 30);
        this.btnLogin.setBackground(Color.YELLOW);
        this.panel.add(this.btnLogin);

        this.btnRegister = new JButton("S'inscrire");
        this.btnRegister.setBounds(20, 400, 100, 40);
        this.btnRegister.setBackground(Color.green);
        this.btnRegister.setForeground(Color.white);
        this.panel.add(this.btnRegister);

        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }

    //fonctions pour ajouter un évenement à un bouton
    public void addButtonRegisterListener(ActionListener listener){
        this.btnRegister.addActionListener(listener);
    }

    public void addButtonLoginListener(ActionListener listener){
        this.btnLogin.addActionListener(listener);
    }

    public void closeView() {
        this.frame.dispose();
    }

}
