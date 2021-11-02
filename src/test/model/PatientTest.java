package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientTest {
    private Patient p;

    @BeforeEach
    void runBefore() {
        p = new Patient("", 0);
    }

    @Test
    void testConstructor() {
        assertEquals("", p.getName());
        assertEquals(0, p.getId());
    }

    @Test
    void testSetName() {
        p.setName("andie");
        assertEquals("andie", p.getName());
    }

    @Test
    void testSetId() {
        p.setId(1000);
        assertEquals(1000, p.getId());
    }
}
