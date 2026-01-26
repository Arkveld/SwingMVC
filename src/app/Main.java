package app;

import controller.HomeController;
import view.ViewHome;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeController(new ViewHome());
            }
        });
    }
}
