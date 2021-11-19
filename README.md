# Term Project for CPSC 210: MyHospitalManager

### What does the application do?

The application I am designing is a hospital management application.

### Who will use it?

This application is intended for use by hospital personnel.

### Why is this project of interest to me?

I find this project fascinating because I went into Computer Science with the intent of pursuing bioinformatics.
Ever since I was young, I have been interested in the field of medicine, largely due to the fact that my parents
studied medicine while they were in college. As such, I feel like this term project is a way to bridge my two passions
and pursue my interests further.

## User Stories
- As a user, I want to be able to log in using a system-wide username and password.
- As a user, I wish to be able to book an appointment for a given patient.
- As a user, I wish to be able to generate a list of inquiries made to the Help Desk.
- As a user, I wish to be able to generate a list of all doctors currently employed at the Hospital.
- As a user, I wish to be able to check patients in and out of the system.
- As a user, I wish to be able to input medical records into the system.
- As a user, I wish to be able to save the current state of the program to file (more specifically 
currently checked-in patients,  medical records, and booked appointments).
- As a user, I wish to be given the option to load the previous state of my program.

##Phase 4: Task 2
- Thu Nov 18 17:12:17 PST 2021: Patient has been added to list of patients.
- Thu Nov 18 17:12:21 PST 2021: Patient has been added to list of patients.
- Thu Nov 18 17:12:24 PST 2021: Patient has been removed to list of patients.
- Thu Nov 18 17:12:27 PST 2021: Doctor has been added to list of doctors.
- Thu Nov 18 17:12:27 PST 2021: Doctor has been added to list of doctors.
- Thu Nov 18 17:12:27 PST 2021: Doctor has been added to list of doctors.
- Thu Nov 18 17:12:27 PST 2021: Doctor has been added to list of doctors.
- Thu Nov 18 17:12:27 PST 2021: Doctor has been added to list of doctors.
- Thu Nov 18 17:12:27 PST 2021: Doctor has been added to list of doctors.
- Thu Nov 18 17:12:27 PST 2021: Doctor has been added to list of doctors.
- Thu Nov 18 17:12:27 PST 2021: Doctor has been added to list of doctors.
- Thu Nov 18 17:12:27 PST 2021: Doctor has been added to list of doctors.
- Thu Nov 18 17:12:27 PST 2021: List of doctors has been initialized with final variables.
- Thu Nov 18 17:12:30 PST 2021: Inquiry has been added to list of inquiries.
- Thu Nov 18 17:12:30 PST 2021: Inquiry has been added to list of inquiries.
- Thu Nov 18 17:12:30 PST 2021: Inquiry has been added to list of inquiries.
- Thu Nov 18 17:12:30 PST 2021: List of inquiries has been initialized.
- Thu Nov 18 17:12:37 PST 2021: Medical record has been added to list of medical records.
- Thu Nov 18 17:12:46 PST 2021: Appointment added to list of appointments.
- Thu Nov 18 17:12:49 PST 2021: Appointment removed from list of appointments.
- Event log has been cleared.

##Phase 4: Task 3

Looking back on my UML diagram, if I had more time to refactor the code, I would refactor my design in the following
ways: 
- Move the lists of data above in the hierarchy right under MainMenu, so that it could be a focal point of control
- Integrate the list of appointments, doctors, medical records, patients, and inquiries directly into their menu 
classes, to increase cohesion and reduce coupling.
- This one feels a bit unrealistic, but have main menu implement the writable interface (or an interface with similar
functionality) so that all its subclasses could freely implement the toJson() methods without complicating the design
further.
