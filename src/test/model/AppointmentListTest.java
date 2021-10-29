package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(0, al.getAppointmentList().size());
    }

    @Test
    void testAddAppointment() {
        al.addAppointment(a);
        assertEquals(1, al.getAppointmentList().size());
    }
}