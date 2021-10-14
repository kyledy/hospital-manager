package model;

import org.junit.jupiter.api.Test;

import static model.Appointment.getDoctorNameFromChoice;
import static model.Doctor.d1;
import static model.Doctor.d2;
import static model.Doctor.d3;
import static model.Doctor.d4;
import static model.Doctor.d5;
import static model.Doctor.d6;
import static model.Doctor.d7;
import static model.Doctor.d8;
import static model.Doctor.d9;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    void constructorTest() {
        Appointment a = new Appointment("", "");

        assertEquals("", a.getDoctorName());
        assertEquals("", a.getDepartment());

        a.setDoctorName("Seuss");
        a.setDepartment("Children's books");

        assertEquals("Seuss", a.getDoctorName());
        assertEquals("Children's books", a.getDepartment());
    }

    @Test
    void getDoctorNameFromChoiceCaseOne() {
        String choice = "1";
        assertEquals(getDoctorNameFromChoice(choice), d1.getDoctorName());
    }

    @Test
    void getDoctorNameFromChoiceCaseTwo() {
        String choice = "2";
        assertEquals(getDoctorNameFromChoice(choice), d2.getDoctorName());
    }

    @Test
    void getDoctorNameFromChoiceCaseThree() {
        String choice = "3";
        assertEquals(getDoctorNameFromChoice(choice), d3.getDoctorName());
    }

    @Test
    void getDoctorNameFromChoiceCaseFour() {
        String choice = "4";
        assertEquals(getDoctorNameFromChoice(choice), d4.getDoctorName());
    }

    @Test
    void getDoctorNameFromChoiceCaseFive() {
        String choice = "5";
        assertEquals(getDoctorNameFromChoice(choice), d5.getDoctorName());
    }

    @Test
    void getDoctorNameFromChoiceCaseSix() {
        String choice = "6";
        assertEquals(getDoctorNameFromChoice(choice), d6.getDoctorName());
    }

    @Test
    void getDoctorNameFromChoiceCaseSeven() {
        String choice = "7";
        assertEquals(getDoctorNameFromChoice(choice), d7.getDoctorName());
    }

    @Test
    void getDoctorNameFromChoiceCaseEight() {
        String choice = "8";
        assertEquals(getDoctorNameFromChoice(choice), d8.getDoctorName());
    }

    @Test
    void getDoctorNameFromChoiceCaseNine() {
        String choice = "9";
        assertEquals(getDoctorNameFromChoice(choice), d9.getDoctorName());
    }

    @Test
    void getDoctorNameFromChoiceCaseDefault() {
        String choice = "10";
        assertEquals(getDoctorNameFromChoice(choice), "Seuss");
    }
}
