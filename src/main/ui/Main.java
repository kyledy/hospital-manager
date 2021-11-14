package ui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setTitle("Login -- MyHospitalManager");
        loginScreen.setVisible(true);
        loginScreen.setBounds(800, 200, 500, 700);
        loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginScreen.setResizable(false);
    }
}
