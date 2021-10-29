package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Doctor.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppointmentListTest {
    private AppointmentList al;

    @BeforeEach
    void runBefore() {
        al = new AppointmentList();
    }

    // implicitly tests the getter method
    @Test
    void testConstructor() {
        assertEquals(0, al.getAppointmentList().size());
    }
}
