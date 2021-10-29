package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorTest {
    private Doctor d;

    @BeforeEach
    void runBefore() {
        d = new Doctor("", "");
    }

    @Test
    void testConstructor() {
        assertEquals("", d.getDoctorName());
        assertEquals("", d.getDepartment());
    }

    // getter methods are implicitly tested by these setter method tests
    @Test
    void testSetDoctorName() {
        d.setDoctorName("kyle");
        assertEquals("kyle", d.getDoctorName());
    }

    @Test
    void testSetDepartMent() {
        d.setDepartment("cardiology");
        assertEquals("cardiology", d.getDepartment());
    }

}
