package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppointmentTest {
    private Appointment a;

    @BeforeEach
    void runBefore() {
        a = new Appointment("", "");
    }

    @Test
    void testConstructor() {
        assertEquals("", a.getName());
        assertEquals("", a.getTime());
    }

    @Test
    void testSetName() {
        a.setName("andie");
        assertEquals("andie", a.getName());
    }

    @Test
    void testSetTime() {
        a.setTime("530 pm");
        assertEquals("530 pm", a.getTime());
    }
}
