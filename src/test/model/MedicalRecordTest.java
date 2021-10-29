package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicalRecordTest {
    private MedicalRecord m;

    @BeforeEach
    void runBefore() {
        m = new MedicalRecord("", 0, 0, 0, "");
    }

    @Test
    void testConstructor() {
        assertEquals("", m.getName());
        assertEquals(0, m.getAge());
        assertEquals(0, m.getHeight());
        assertEquals(0, m.getWeight());
        assertEquals("", m.getBloodType());
    }

    @Test
    void testSetName() {
        m.setName("Jared");
        assertEquals("Jared", m.getName());
    }

    @Test
    void testSetAge() {
        m.setAge(12);
        assertEquals(12, m.getAge());
    }

    @Test
    void testSetHeight() {
        m.setHeight(174);
        assertEquals(174, m.getHeight());
    }

    @Test
    void testSetWeight() {
        m.setWeight(100);
        assertEquals(100, m.getWeight());
    }

    @Test
    void testSetBloodType() {
        m.setBloodType("O");
        assertEquals("O", m.getBloodType());
    }
}
