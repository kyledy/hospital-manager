package persistence;

import model.MedicalRecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This test borrows heavily from the test provided in JSonSerializationDemo.
public class JsonTest {
    protected void checkMedicalRecord(String name, int age, int height, int weight, String bloodType, MedicalRecord m) {
        assertEquals(name, m.getName());
        assertEquals(age, m.getAge());
        assertEquals(height, m.getHeight());
        assertEquals(weight, m.getWeight());
        assertEquals(bloodType, m.getBloodType());
    }
}
