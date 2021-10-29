package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientListTest {
    private PatientList pl;
    private Patient p;

    @BeforeEach
    void runBefore() {
        pl = new PatientList();
        p = new Patient("");
    }

    @Test
    void testConstructor() {
        assertEquals(0, pl.getPatientList().size());
    }

    @Test
    void testAddPatient() {
        pl.addPatient(p);
        assertEquals(1, pl.getPatientList().size());
    }
}
