package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Doctor.addDoctor;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class DoctorTest {
    Doctor d;
    ArrayList<Doctor> doctors;

    @BeforeEach
    void runBefore() {
        d = new Doctor("", "");
    }

    @Test
    void constructorTest() {
        assertEquals("", d.getDoctorName());
        assertEquals("", d.getDepartment());

        d.setDoctorName("Andrea Chan");
        d.setDepartment("Optometry");

        assertEquals("Andrea Chan", d.getDoctorName());
        assertEquals("Optometry", d.getDepartment());
    }

    @Test
    void addDoctorTest() {

        Doctor d2 = new Doctor("A", "B");
        Doctor d3 = new Doctor("C", "D");
        doctors = new ArrayList<>();
        assertEquals(0, doctors.size());

        addDoctor(doctors, d);
        assertEquals(1, doctors.size());
        assertEquals(d, doctors.get(0));

        addDoctor(doctors, d2);
        addDoctor(doctors, d3);
        assertEquals(3, doctors.size());
        assertEquals(d3, doctors.get(2));
    }


}
