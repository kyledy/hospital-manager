package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*

// This class represents the login system of the program.
public class Login extends JFrame implements ActionListener {

    // User interface elements
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

    public Login() {
        container.setLayout(null);
        init();
        addComponents();
        addActionEvents();
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setTitle("Login Form");
        login.setVisible(true);
        login.setBounds(10, 10, 370, 600);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setResizable(false);
    }

    public void init() {
        username.setBounds(50, 150, 100, 30);
        password.setBounds(50, 220, 100, 30);
        usernameField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        showPassword.setBounds(150, 250, 150, 30);
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
                new HospitalManager();
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

*/
