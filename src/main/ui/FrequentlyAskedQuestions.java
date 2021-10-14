package ui;

import java.util.Scanner;

// This class represents the entirety of the Frequently Asked Questions Page that is found in the program.
public class FrequentlyAskedQuestions {

    // EFFECTS: Prompts the user to select an FAQ question of their choice
    public static void showFAQ() {

        System.out.println("Welcome to the Frequently Asked Questions Page!");
        System.out.println("Here we have gathered a list of commonly asked questions by our patients.");

        System.out.println("Please input the corresponding number to learn more about your question.");
        System.out.println("1: How do I book an appointment / submit an inquiry?");
        System.out.println("2: How long will it take for my inquiry to be answered?");
        System.out.println("3: When are visiting hours?");
        System.out.println("4: Exit");
        answerQuestion();
    }

    // EFFECTS: Answers the corresponding question based on the choice of the user
    public static void answerQuestion() {
        Scanner next = new Scanner(System.in);
        String choice = next.nextLine();

        switch (choice) {

            // Answer to FAQ question 1
            case "1":
                System.out.println("Using this program, there will be a prompt that will allow you to select it.");
                continueUsingFAQ();
                break;

            // Answer to FAQ question 2
            case "2":
                System.out.println("Rest assured that your inquiry will be answered in 3-5 business days.");
                continueUsingFAQ();
                break;

            // Answer to FAQ question 3
            case "3":
                System.out.println("Visiting hours are from 8am-5pm on weekdays, and 10am-5pm on weekends.");
                continueUsingFAQ();
                break;

            // A simple thank-you message if the user chooses to end the program
            case "4":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            // default statement which brings users back to the FAQ page if they have selected an invalid choice
            default:
                System.out.println("That wasn't a valid choice. Please try again.");
                showFAQ();
                break;
        }
    }

    // EFFECTS: returns the user to the Patient homepage, or exits
    public static void continueUsingFAQ() {

        System.out.println("\n");
        System.out.println("1: Return to the FAQ Page");
        System.out.println("2: Return to the Patient Homepage");
        System.out.println("3: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        switch (choice) {

            case "1":
                showFAQ();
                break;

            case "2":
                MyHospitalManager.showPatientOptions();
                break;

            case "3":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            case "4":
                System.out.println("Sorry, that wasn't a valid choice. Please try again.");
                System.out.println("\n");
                continueUsingFAQ();
                break;
        }
    }


}
