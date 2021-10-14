package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Inquiry.addInquiry;
import static org.junit.jupiter.api.Assertions.*;

import model.Inquiry;

import java.util.ArrayList;

public class InquiryTest {
    Inquiry i;
    ArrayList<Inquiry> inquiries;

    @BeforeEach
    void runBefore() {
        i = new Inquiry("", "", "");
    }

    @Test
    void constructorTest() {
        assertEquals("", i.getSubject());
        assertEquals("", i.getDate());
        assertEquals("", i.getRemarks());

        i.setSubject("heart attack!");
        i.setDate("September 30, 2021");
        i.setRemarks("Please hurry!");

        assertEquals("heart attack!", i.getSubject());
        assertEquals("September 30, 2021", i.getDate());
        assertEquals("Please hurry!", i.getRemarks());
    }

    @Test
    void addInquiryTest() {

        Inquiry i2 = new Inquiry("A", "B", "C");
        Inquiry i3 = new Inquiry("D", "E", "F");
        inquiries = new ArrayList<>();
        assertEquals(0, inquiries.size());

        addInquiry(inquiries, i);
        assertEquals(1, inquiries.size());
        assertEquals(i, inquiries.get(0));

        addInquiry(inquiries, i2);
        addInquiry(inquiries, i3);
        assertEquals(3, inquiries.size());
        assertEquals(i3, inquiries.get(2));
    }

}
