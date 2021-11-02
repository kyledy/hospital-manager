package persistence;

import model.Appointment;
import model.MedicalRecord;
import model.Patient;

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

    protected void checkPatient(String name, int id, Patient p) {
        assertEquals(name, p.getName());
        assertEquals(id, p.getId());
    }

    protected void checkAppointment(String name, String time, Appointment a) {
        assertEquals(name, a.getName());
        assertEquals(time, a.getTime());
    }
}
