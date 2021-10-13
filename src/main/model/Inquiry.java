package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Inquiry {
    String subject;
    String date;
    String remarks;
    private static ArrayList<Inquiry> inquiries = new ArrayList<>();

    // Dummy inquiries for showAllInquiries, because Inquiry instances cannot be shared between Patient and Admin
    static Inquiry i1 = new Inquiry("cannot book appointment", "September 16, 2021", "N/a");
    static Inquiry i2 = new Inquiry("emergency appointment", "November 19, 2021", "Please hurry!");
    static Inquiry i3 = new Inquiry("I have a crush on a doctor", "January 4, 2021", "I won't tell!");


    // constructor for the Inquiry class
    public Inquiry(String subject, String date, String remarks) {
        this.subject = subject;
        this.date = date;
        this.remarks = remarks;
    }

    // MODIFIES: this
    // EFFECTS: sets the value of subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // MODIFIES: this
    // EFFECTS: sets the value of date
    public void setDate(String date) {
        this.subject = date;
    }

    // MODIFIES: this
    // EFFECTS: sets the value of remarks
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    // EFFECTS: returns the value of subject for this
    public String getSubject() {
        return this.subject;
    }

    // EFFECTS: returns the value of date for this
    public String getDate() {
        return this.date;
    }

    // EFFECTS: returns the value of remarks for this
    public String getRemarks() {
        return this.remarks;
    }

    // MODIFIES: inquiries
    // EFFECTS: Adds an inquiry to list inquiries
    public static void addInquiry(Inquiry i) {
        inquiries.add(i);
    }

    // MODIFIES: inquiries
    // EFFECTS: prompts the user to submit an inquiry
    public static void submitInquiry() {
        Inquiry i = new Inquiry("", "", "");

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the subject of your inquiry.");
        String thisSubject = myScanner.nextLine();
        System.out.println("Please enter the date of your inquiry.");
        String thisDate = myScanner.nextLine();
        System.out.println("Please enter any additional remarks.");
        String thisRemarks = myScanner.nextLine();

        i.setSubject(thisSubject);
        i.setDate(thisDate);
        i.setRemarks(thisRemarks);
        addInquiry(i);

        System.out.println("Successful! Here is your receipt: ");
        System.out.println("\n");
        System.out.println("Subject: " + thisSubject);
        System.out.println("Date: " + thisDate);
        System.out.println("Additional Remarks: ");
        System.out.println(thisRemarks);

        continueUsingPatient();
    }

    // EFFECTS: prints all inquiries currently stored in inquiries
    public static void showAllInquiries() {
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

        removeInquiry();
    }

    // REQUIRES: inquiries is non-empty
    // MODIFIES: inquiries
    // EFFECTS: removes element from inquiries with given entry number
    // Sadly, I haven't yet been able to figure out how to correctly display the indexing of number in between instances
    // and after removal. :(
    public static void removeInquiry() {
        System.out.println("Do you wish to remove an Inquiry? (Y/N)");
        Scanner next = new Scanner(System.in);
        String choice = next.nextLine();

        if (choice.equals("Y")) {
            System.out.println("Which number would you like to remove?");
            int numberToRemove = Integer.parseInt(next.nextLine());

            int j = 0;
            for (Inquiry i : inquiries) {
                j += 1;
                if (j == (numberToRemove)) {
                    inquiries.remove(i);
                }
                System.out.println("Successful!");
                break;
            }
            continueUsingAdmin();

        } else if (choice.equals("N")) {
            continueUsingAdmin();
        } else {
            System.out.println("Sorry, that was not a valid answer.");
            removeInquiry();
        }
    }

    // EFFECTS: prompts the user to continue the program if they are accessing it from the admin-side
    public static void continueUsingAdmin() {
        System.out.println("\n");
        System.out.println("1: Return to the Admin page");
        System.out.println("2: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        Admin a = new Admin();

        switch (choice) {
            case "1":
                a.showAdminOptions();
                break;
            case "2":
                break;
            default:
                System.out.println("That was not a valid choice.");
                continueUsingAdmin();
        }
    }

    // EFFECTS: prompts the user to continue the program if they are accessing it from the patient-side
    public static void continueUsingPatient() {
        System.out.println("\n");

        System.out.println("1: Submit another Inquiry");
        System.out.println("2: Return to the Patient Homepage");
        System.out.println("3: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        Patient p = new Patient("", 0);

        switch (choice) {
            case "1":
                submitInquiry();
                break;
            case "2":
                p.showPatientOptions();
                break;
            case "3":
                break;
            default:
                System.out.println("That was not a valid choice.");
                continueUsingPatient();
        }
    }

}
