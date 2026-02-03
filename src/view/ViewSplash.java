package view;

import javax.swing.*;
import java.awt.*;

public class ViewSplash {

    private JProgressBar bar;

    public ViewSplash() {
        initialize();
    }

    private void initialize(){
        JWindow splashScreen = new JWindow();
        splashScreen.setSize(480, 360);
        splashScreen.setLocationRelativeTo(null);
        splashScreen.getContentPane().setBackground(new Color(24, 26, 178));

        JLabel label = new JLabel("Bank App");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setForeground(Color.YELLOW);

        bar = new JProgressBar(0, 1000);
        bar.setLayout(null);
        bar.setLocation(10,310);
        bar.setSize(460, 15);
        bar.setValue(0);
        bar.setForeground(Color.YELLOW);
        bar.setStringPainted(false);
        splashScreen.getContentPane().add(bar);

        //Affichage
        splashScreen.getContentPane().add(label);
        splashScreen.setVisible(true);
        load();
        splashScreen.dispose();
    }

    private void load(){
        int i = 0;
        while (i <= 1000){
            bar.setValue(i);
            i = i + 10;
            try {
                Thread.sleep(150);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
