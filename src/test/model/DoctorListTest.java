package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Doctor.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorListTest {
    private static final int NUM_DOCTORS = 9;
    private DoctorList dl;

    @BeforeEach
    void runBefore() {
        dl = new DoctorList();
    }

    // implicitly tests the getter method
    @Test
    void testConstructor() {
        assertEquals(0, dl.getDoctors().size());
    }

    @Test
    void testInitDoctors() {
        dl.initDoctors();
        assertEquals(NUM_DOCTORS, dl.getDoctors().size());
        assertEquals(D1, dl.getDoctors().get(0));
        assertEquals(D2, dl.getDoctors().get(1));
        assertEquals(D3, dl.getDoctors().get(2));
        assertEquals(D4, dl.getDoctors().get(3));
        assertEquals(D5, dl.getDoctors().get(4));
        assertEquals(D6, dl.getDoctors().get(5));
        assertEquals(D7, dl.getDoctors().get(6));
        assertEquals(D8, dl.getDoctors().get(7));
        assertEquals(D9, dl.getDoctors().get(8));
    }

}
