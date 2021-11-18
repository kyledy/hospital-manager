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

    // System-wide username and password
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "1234";

    // GUI elements for the Login Button
    Container loginScreen = getContentPane();
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Log in");
    JCheckBox showPassword = new JCheckBox("Show Password");

    // These two components set the background color
    JPanel backgroundPanel = new JPanel();
    Color customColor = new Color(167, 222, 250);

    // constructor
    // EFFECTS: constructs the login button
    public LoginScreen() {

        this.setTitle("Login authentication required");
        this.setVisible(true);
        this.setBounds(800, 200, 500, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        loginScreen.setLayout(null);
        setPositionAndSize();
        addComponents();
        addActionEvents();

        JOptionPane.showMessageDialog(this, "Username is admin, Password is 1234");
    }

    // EFFECTS: sets the position and size of the GUI elements on the content pane
    public void setPositionAndSize() {
        usernameLabel.setBounds(100, 150, 100, 30);
        passwordLabel.setBounds(100, 220, 100, 30);
        usernameField.setBounds(200, 150, 150, 30);
        passwordField.setBounds(200, 220, 150, 30);
        loginButton.setBounds(170, 350, 100, 30);
        showPassword.setBounds(200, 250, 150, 30);
        backgroundPanel.setBounds(0, 0, 600, 700);
    }

    // MODIFIES: container
    // EFFECTS: adds GUI components to container
    public void addComponents() {
        loginScreen.add(usernameLabel);
        loginScreen.add(passwordLabel);
        loginScreen.add(usernameField);
        loginScreen.add(passwordField);
        loginScreen.add(loginButton);
        loginScreen.add(showPassword);
        loginScreen.add(backgroundPanel);
        backgroundPanel.setBackground(customColor);
        showPassword.setBackground(customColor);
    }

    // MODIFIES: loginButton, showPassword
    // EFFECTS: adds action listener to login button and show password button
    public void addActionEvents() {
        loginButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    // EFFECTS: adds action listening behavior for login button and show password button
    @Override
    public void actionPerformed(ActionEvent e) {

        // Login button
        // If username and password match the system-wide username and password, logs in user to the system. Otherwise,
        // displays an error message and continues displaying the login screen. If the user logs in successfully, the
        // login screen closes and the user is taken to the main menu.

        if (e.getSource() == loginButton) {
            // tryUsername and tryPassword are local variables or the queried username and password fields
            String tryUsername = usernameField.getText();
            // I encountered problems when setting up the char[] for password, so I opted to use getText() instead.
            String tryPassword = passwordField.getText();
            if (tryUsername.equals(CORRECT_USERNAME) && tryPassword.equals(CORRECT_PASSWORD)) {

                // This block of code was taken from the main method of the
                // original console-based implementation of the program.
                try {
                    dispose();
                    new MainMenu();
                } catch (FileNotFoundException fe) {
                    System.out.println("Unable to run application: file not found");
                }

            } else {
                // error message
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        // Show password
        // Shows the original text that was typed in when the show password box is checked, and vice versa
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
}
