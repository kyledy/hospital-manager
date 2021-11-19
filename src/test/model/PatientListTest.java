package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PatientListTest {
    private PatientList pl;
    private Patient p;

    @BeforeEach
    void runBefore() {
        pl = new PatientList();
        p = new Patient("", 0);
    }

    @Test
    void testConstructor() {
        assertEquals(0, pl.length());
    }

    @Test
    void testAddPatient() {
        pl.addPatient(p);
        assertEquals(1, pl.length());
    }

    @Test
    void testRemovePatient() {
        assertEquals(0, pl.length());
        pl.removePatient(p.getName());
        assertEquals(0, pl.length());

        pl.addPatient(p);
        assertEquals(1, pl.length());

        pl.removePatient(p.getName());
        assertEquals(0, pl.length());
        assertFalse(pl.getPatients().contains(p));
    }

    @Test
    void testLength() {
        pl.addPatient(p);
        assertEquals(1, pl.length());
    }
}
