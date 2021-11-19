package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentListTest {
    private AppointmentList al;
    private Appointment a;

    @BeforeEach
    void runBefore() {
        al = new AppointmentList();
        a = new Appointment("", "");
    }

    // implicitly tests the getter method
    @Test
    void testConstructor() {
        assertEquals(0, al.length());
    }

    @Test
    void testAddAppointment() {
        al.addAppointment(a);
        assertEquals(1, al.length());
    }

    @Test
    void testRemoveAppointment() {

        try {
            al.removeAppointment(a.getName());
            fail("Exception should have been thrown");
        } catch (NullPointerException e) {
            // nothing
        }

        al.addAppointment(a);
        assertTrue(al.getAppointments().contains(a));
        assertEquals(1, al.length());

        al.removeAppointment(a.getName());
        assertEquals(0, al.length());
        assertFalse(al.getAppointments().contains(a));
    }

    @Test
    void testLength() {
        al.addAppointment(a);
        assertEquals(1, al.length());
    }
}
