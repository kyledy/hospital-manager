package ui;

import model.Inquiry;

import java.util.Scanner;

// This class represents the UI portion of the Inquiry class. This class is special because it provides implementations
// that are used both by Patients and Administrators. Patients can submit an Inquiry to the help desk, and Admins can
// view all inquiries currently made to the help desk.

// Currently, the program does not support sharing the list of inquiries between instances of Patient and Admin, so
// I initialized some dummy variables into the showAllInquiries function to demonstrate it instead.
public class UserInquiry extends Inquiry {

    // Dummy inquiries for showAllInquiries, because Inquiry instances cannot be shared between Patient and Admin
    static Inquiry i1 = new Inquiry("cannot book appointment","September 16, 2021","N/a");
    static Inquiry i2 = new Inquiry("emergency appointment","November 19, 2021","Please hurry!");
    static Inquiry i3 = new Inquiry("I have a crush on a doctor","January 4, 2021","I won't say!");

    // constructor matching Inquiry superclass
    public UserInquiry(String subject, String date, String remarks) {
        super(subject, date, remarks);
    }

    // MODIFIES: i, inquiries
    // EFFECTS: creates a new Inquiry i based on user input, adds it to a list of inquiries contained in the
    // Inquiry class, then prints a receipt of the inquiry to the console
    public static void submitInquiry() {

        Inquiry i = new Inquiry("", "", "");

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the subject of your inquiry.");
        String thisSubject = myScanner.nextLine();

        System.out.println("Please enter the date of your inquiry.");
        String thisDate = myScanner.nextLine();

        System.out.println("Please enter any additional remarks.");
        String thisRemarks = myScanner.nextLine();

        // Setting the values of the new object i
        i.setSubject(thisSubject);
        i.setDate(thisDate);
        i.setRemarks(thisRemarks);
        addInquiry(i);

        // prints a receipt of the newly created Inquiry to the console
        System.out.println("Successful! Here is your receipt: ");
        System.out.println("\n");
        System.out.println("Subject: " + thisSubject);
        System.out.println("Date: " + thisDate);
        System.out.println("Additional Remarks: ");
        System.out.println(thisRemarks);

        // prompts the user if they want to continue
        continueUsingInquiryPatient();
    }

    // MODIFIES: inquiries
    // EFFECTS: prints all inquiries currently stored in the list of inquiries to the console
    public static void showAllInquiries() {

        // Initializing the dummy variables is the basis for the MODIFIES clause, otherwise the method would just have
        // EFFECTS
        addInquiry(i1);
        addInquiry(i2);
        addInquiry(i3);

        // Variable j starts indexing at 1, and keeps count of which entry was entered first
        int j = 0;

        for (Inquiry i : inquiries) {
            // Variable j starts indexing at 1, and keeps count of which entry was entered first
            j += 1;
            System.out.println(j);
            System.out.println("Subject: " + i.getSubject());
            System.out.println("Date: " + i.getDate());
            System.out.println("Additional Remarks: ");
            System.out.println(i.getRemarks());
            System.out.println("\n");
        }
        continueUsingInquiryAdmin();
    }

    // EFFECTS: prompts the user to continue the program if they are accessing the submitInquiry function
    // This method is the Patient-side implementation of this class
    public static void continueUsingInquiryPatient() {
        System.out.println("\n");

        System.out.println("1: Submit another Inquiry");
        System.out.println("2: Return to the Patient Homepage");
        System.out.println("3: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        switch (choice) {

            case "1":
                submitInquiry();
                break;

            case "2":
                MyHospitalManager.showPatientOptions();
                break;

            case "3":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            default:
                System.out.println("That was not a valid choice.");
                continueUsingInquiryPatient();
                break;
        }
    }

    // EFFECTS: prompts the user to continue the program if they are accessing the showAllInquiries function
    // This is the implementation for the class from the Admin-side
    public static void continueUsingInquiryAdmin() {

        System.out.println("\n");
        System.out.println("1: Return to the Admin page");
        System.out.println("2: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        switch (choice) {

            case "1":
                MyHospitalManager.showAdminOptions();
                break;

            case "2":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            default:
                System.out.println("That was not a valid choice.");
                continueUsingInquiryAdmin();
                break;
        }
    }
}
