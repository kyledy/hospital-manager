package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import model.Patient;

public class PatientTest {
    Patient p;

    @Test
    void constructorTest() {
        p = new Patient("", 0);

        assertEquals("", p.getPatientName());
        assertEquals(0, p.getPatientID());

        p.setPatientName("Andrea Chan");
        p.setPatientID(1008);

        assertEquals("Andrea Chan", p.getPatientName());
        assertEquals(1008, p.getPatientID());
    }

}
