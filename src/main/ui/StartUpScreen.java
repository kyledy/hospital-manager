package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// This class represents a start-up screen displaying an image of the "logo of the program"
// The logo was designed by user SBTS2018, and taken from the URL https://www.flaticon.com/premium-icon/medical-symbol
// _1988622?term=medical&page=1&position=53&page=1&position=53&related_id=1988622&origin=search
// Image resizing takes reference from https://stackoverflow.com/questions/5895829/resizing-image-in-java
public class StartUpScreen extends JFrame implements ActionListener {

    // initializing image
    BufferedImage logo;

    // GUI elements
    Container startUpScreen = getContentPane();
    JLabel welcomeLabel = new JLabel("Welcome to MyHospitalManager!");
    JButton okButton = new JButton("Click OK to continue");

    // constructor
    // EFFECTS: constructs a window with image and one button prompting the user to continue
    public StartUpScreen() {
        this.setTitle("MyHospitalManager -- Start Up");
        this.setVisible(true);
        this.setBounds(800, 200, 500, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        // throws IO exception
        try {
            logo = ImageIO.read(new File("data/logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // scales the logo and sets it to a JLabel
        Image resizedLogo = logo.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        JLabel picLabel = new JLabel(new ImageIcon(resizedLogo));

        // sets layout and adds components to the window
        startUpScreen.setLayout(null);
        startUpScreen.add(welcomeLabel);
        startUpScreen.add(picLabel);
        startUpScreen.add(okButton);
        okButton.addActionListener(this);

        // sets the bounds of the window and its GUI elements
        welcomeLabel.setBounds(145, 40, 300, 50);
        okButton.setBounds(135, 425, 200, 100);
        picLabel.setBounds(109, 120, 250, 250);

    }

    // EFFECTS: if the OK button is pressed, brings user to the login menu
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            dispose();
            new LoginScreen();
        }
    }
}
