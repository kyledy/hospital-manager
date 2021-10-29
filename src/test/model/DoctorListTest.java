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
        assertEquals(0, dl.getDoctorList().size());
    }

    @Test
    void testInitDoctors() {
        dl.initDoctors();
        assertEquals(NUM_DOCTORS, dl.getDoctorList().size());
        assertEquals(D1, dl.getDoctorList().get(0));
        assertEquals(D2, dl.getDoctorList().get(1));
        assertEquals(D3, dl.getDoctorList().get(2));
        assertEquals(D4, dl.getDoctorList().get(3));
        assertEquals(D5, dl.getDoctorList().get(4));
        assertEquals(D6, dl.getDoctorList().get(5));
        assertEquals(D7, dl.getDoctorList().get(6));
        assertEquals(D8, dl.getDoctorList().get(7));
        assertEquals(D9, dl.getDoctorList().get(8));
    }

}
