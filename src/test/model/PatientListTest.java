package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientListTest {
    private PatientList pl;

    @BeforeEach
    void runBefore() {
        pl = new PatientList();
    }

    @Test
    void testConstructor() {
        assertEquals(0, pl.getPatientList().size());
    }
}
