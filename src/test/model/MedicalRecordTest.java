package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.MedicalRecord.addMedicalRecord;
import static org.junit.jupiter.api.Assertions.*;

import model.MedicalRecord;

import java.util.ArrayList;

public class MedicalRecordTest {
    MedicalRecord m;
    ArrayList<MedicalRecord> medicalRecords;

    @BeforeEach
    void runBefore() {
        m = new MedicalRecord("", 0, 0, 0, "");
    }

    @Test
    void constructorTest() {
        assertEquals("", m.getName());
        assertEquals(0, m.getAge());
        assertEquals(0, m.getHeight());
        assertEquals(0, m.getWeight());
        assertEquals("", m.getBloodType());

        m.setName("Andrea Chan");
        m.setAge(20);
        m.setHeight(130);
        m.setWeight(60);
        m.setBloodType("O");

        assertEquals("Andrea Chan", m.getName());
        assertEquals(20, m.getAge());
        assertEquals(130, m.getHeight());
        assertEquals(60, m.getWeight());
        assertEquals("O", m.getBloodType());
    }

    @Test
    void addMedicalRecordTest() {

        MedicalRecord m2 = new MedicalRecord("A", 0, 0, 0, "A");
        MedicalRecord m3 = new MedicalRecord("B", 1, 1, 1, "B");

        medicalRecords = new ArrayList<>();
        assertEquals(0, medicalRecords.size());

        addMedicalRecord(medicalRecords, m);
        assertEquals(1, medicalRecords.size());
        assertEquals(m, medicalRecords.get(0));

        addMedicalRecord(medicalRecords, m2);
        addMedicalRecord(medicalRecords, m3);
        assertEquals(3, medicalRecords.size());
        assertEquals(m3, medicalRecords.get(2));
    }

}

