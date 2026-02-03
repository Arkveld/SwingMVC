package app;

import controller.HomeController;
import controller.SplashController;
import view.ViewHome;
import view.ViewSplash;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new SplashController(new ViewSplash());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeController(new ViewHome());
            }
        });
    }
}
