package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewRegister {
    //Attributs
    JFrame frame;
    JPanel panel;
    JLabel label1, label2, label3, label4, label5;
    JTextField inputFirstname, inputLastname, inputMail;
    JPasswordField inputPassword;
    JButton btnRegister, btnHome;

    public ViewRegister() {
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
        this.label1 = new JLabel("Inscription");
        this.label1.setBounds(290, 10, 480, 80);
        this.label1.setFont(new Font("Noto Sans", Font.PLAIN, 28));
        this.label1.setForeground(Color.white);
        this.panel.add(this.label1);

        //************** Formulaire **********************/

        //************** Firstname **********************/
        this.label2 = new JLabel("Firstname");
        this.label2.setBounds(170, 100, 100, 20);
        this.label2.setFont(new Font("Noto Sans", Font.PLAIN, 18));
        this.label2.setForeground(Color.white);
        this.panel.add(this.label2);

        this.inputFirstname= new JTextField();
        this.inputFirstname.setBounds(170, 130, 480, 30);
        this.panel.add(this.inputFirstname);

        //************** Lastname **********************/
        this.label3 = new JLabel("Lastname");
        this.label3.setBounds(170, 170, 100, 20);
        this.label3.setFont(new Font("Noto Sans", Font.PLAIN, 18));
        this.label3.setForeground(Color.white);
        this.panel.add(this.label3);

        this.inputLastname = new JTextField();
        this.inputLastname.setBounds(170, 200, 480, 30);
        this.panel.add(this.inputLastname);

        //************** Mail**********************/
        this.label4 = new JLabel("Email");
        this.label4.setBounds(170, 240, 480, 30);
        this.label4.setFont(new Font("Noto Sans", Font.PLAIN, 18));
        this.label4.setForeground(Color.white);
        this.panel.add(this.label4);

        this.inputMail = new JTextField();
        this.inputMail.setBounds(170, 280, 480, 30);
        this.panel.add(this.inputMail);

        //************** Password **********************/
        this.label5 = new JLabel("Password");
        this.label5.setBounds(170, 320, 480, 30);
        this.label5.setFont(new Font("Noto Sans", Font.PLAIN, 18));
        this.label5.setForeground(Color.white);
        this.panel.add(this.label5);

        this.inputPassword = new JPasswordField();
        this.inputPassword.setBounds(170, 360, 480, 30);
        this.panel.add(this.inputPassword);

        //************** Boutons **********************/
        this.btnRegister = new JButton("Inscription");
        this.btnRegister.setBackground(Color.green);
        this.btnRegister.setForeground(Color.white);
        this.btnRegister.setBounds(520, 410, 120, 50);
        this.panel.add(this.btnRegister);

        this.btnHome = new JButton("Acceuil");
        this.btnHome.setBackground(Color.red);
        this.btnHome.setForeground(Color.white);
        this.btnHome.setBounds(20, 410, 120, 50);
        this.panel.add(this.btnHome);

        //********** Affichage **********/
        this.frame.add(this.panel);
        this.frame.setVisible(true);

    }

    //Getter
    public String getInputFirstname(){
        return this.inputFirstname.getText();
    }
    public String getInputlastName(){
        return this.inputLastname.getText();
    }

    public String getInputEmail(){
        return this.inputMail.getText();
    }

    public String getInputPassword(){
        return new String(this.inputPassword.getPassword());
    }

    public void addButtonRegister(ActionListener listener){
        this.btnRegister.addActionListener(listener);
    }
    public void addButtonHome(ActionListener listener){
        this.btnHome.addActionListener(listener);
    }
    public void closeView() {
        this.frame.dispose();
    }

    public void viewMessage(String message){
        JOptionPane.showMessageDialog(this.frame, message);
    }
}
