package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InquiryTest {
    private Inquiry i;

    @BeforeEach
    void runBefore() {
        i = new Inquiry("", "", "");
    }

    @Test
    void testConstructor() {
        assertEquals("", i.getSubject());
        assertEquals("", i.getDate());
        assertEquals("", i.getRemarks());
    }

    @Test
    void testSetSubject() {
        i.setSubject("harry potter");
        assertEquals("harry potter", i.getSubject());
    }

    @Test
    void testSetDate() {
        i.setDate("January 4, 2021");
        assertEquals("January 4, 2021", i.getDate());
    }

    @Test
    void testSetRemarks() {
        i.setRemarks("nothing else!");
        assertEquals("nothing else!", i.getRemarks());
    }
}
