package model;

import java.util.Scanner;

public class FrequentlyAskedQuestions {

    // EFFECTS: Prompts the user to select an FAQ question of their choice
    public static void showFAQ() {
        System.out.println("Welcome to the Frequently Asked Questions Page!");
        System.out.println("Here we have gathered a list of commonly asked questions by our patients.");

        System.out.println("Please press the corresponding number to learn more about your question.");
        System.out.println("1: How do I book an appointment?");
        System.out.println("2: How do I submit an Inquiry?");
        System.out.println("3: How long will it take for my inquiry to be answered?");
        System.out.println("4: When are visiting hours?");
        System.out.println("5: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();
        answerQuestion(choice);
    }

    // EFFECTS: Answers the question based on the choice of the user, and prompts them to ask if they want to keep
    //          going, or return to the Patient homepage
    public static void answerQuestion(String choice) {
        switch (choice) {

            case "1":
            case "2":
                System.out.println("Using this program, there will be a prompt that will allow you to select it.");
                continueUsing();
                break;

            case "3":
                System.out.println("Our apologies, we are currently experiencing a high volume of requests.");
                System.out.println("Rest assured that your inquiry will be answered in 3-5 business days.");
                continueUsing();
                break;

            case "4":
                System.out.println("Visiting hours are from 8am-5pm on weekdays, and 10am-5pm on weekends.");
                continueUsing();
                break;

            case "5":
                System.out.println("Thank you for using MyHospitalManager!");
                continueUsing();

            default:
                System.out.println("That wasn't a valid choice. Please try again.");
                showFAQ();
                break;
        }
    }

    // EFFECTS: returns the user to the Patient homepage, or exits
    public static void continueUsing() {
        Patient p = new Patient("", 0);

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
                p.showPatientOptions();

            case "3":
                break;

            case "4":
                System.out.println("Sorry, that wasn't a valid choice. Please try again.");
                System.out.println("\n");
                continueUsing();
        }
    }


}
