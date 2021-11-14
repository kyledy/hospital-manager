package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// This class represents the login system of the program.
// This code references an online tutorial from https://www.tutorialsfield.com/login-form-in-java-swing-with-source-
// code/. More specifically, the ActionPerformed method.
public class LoginScreen extends JFrame implements ActionListener {

    // Login button elements
    Container container = getContentPane();
    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Log in");
    JCheckBox showPassword = new JCheckBox("Show Password");

    // System-wide username and password
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "1234";

    // constructor
    // EFFECTS: constructs the login button
    public LoginScreen() {
        container.setLayout(null);
        setPositionAndSize();
        addComponents();
        addActionEvents();
    }

    public void setPositionAndSize() {
        username.setBounds(100, 150, 100, 30);
        password.setBounds(100, 220, 100, 30);
        usernameField.setBounds(200, 150, 150, 30);
        passwordField.setBounds(200, 220, 150, 30);
        loginButton.setBounds(170, 350, 100, 30);
        showPassword.setBounds(200, 250, 150, 30);
    }

    public void addComponents() {
        container.add(username);
        container.add(password);
        container.add(usernameField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(showPassword);
    }

    public void addActionEvents() {
        loginButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // login button
        if (e.getSource() == loginButton) {
            String tryUsername;
            String tryPassword;
            tryUsername = usernameField.getText();
            // The method getText() for password fields is deprecated for security reasons, but I chose to include it
            // for ease of implementation.
            tryPassword = passwordField.getText();
            if (tryUsername.equals(CORRECT_USERNAME) && tryPassword.equals(CORRECT_PASSWORD)) {
                dispose();

                try {
                    new HospitalManager();
                } catch (FileNotFoundException fe) {
                    System.out.println("Unable to run application: file not found");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        //show password
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
}
