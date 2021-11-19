package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        assertEquals(0, al.length());
        al.removeAppointment(a.getName());
        assertEquals(0, al.length());

        al.addAppointment(a);
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
