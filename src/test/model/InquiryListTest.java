package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Inquiry.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InquiryListTest {
    private static final int NUM_OF_INQUIRIES = 3;
    private InquiryList il;

    @BeforeEach
    void runBefore() {
        il = new InquiryList();
    }

    @Test
    void testConstructor() {
        assertEquals(0, il.getInquiryList().size());
    }

    @Test
    void testInitInquiries() {
        il.initInquiries();
        assertEquals(NUM_OF_INQUIRIES, il.getInquiryList().size());
        assertEquals(I1, il.getInquiryList().get(0));
        assertEquals(I2, il.getInquiryList().get(1));
        assertEquals(I3, il.getInquiryList().get(2));
    }
}
