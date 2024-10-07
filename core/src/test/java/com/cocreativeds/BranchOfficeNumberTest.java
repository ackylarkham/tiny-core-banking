package com.cocreativeds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.Objects;
public class BranchOfficeNumberTest {

    @Test
    void testBranchOfficeNumber() {
        BranchOfficeNumber bc = new BranchOfficeNumber();
        assertEquals("000", bc.getBranchOfficeNumber());
    }
    @Test
    void testGetBranchOfficeNumber() {
        BranchOfficeNumber bc = new BranchOfficeNumber("123");
        assertEquals("123", bc.getBranchOfficeNumber());
    }

    @Test
    void testSetBranchOfficeNumber() {
        BranchOfficeNumber bc = new BranchOfficeNumber();
        bc.setBranchOfficeNumber("999");
        assertEquals("999", bc.getBranchOfficeNumber());
    }

    @Test
    void testToString() {
        BranchOfficeNumber bc = new BranchOfficeNumber("123");
        assertEquals("店番: 123", bc.toString()); 
    }

    @Test
    void testSetBranchOfficeNumberException01() {
        BranchOfficeNumber bc = new BranchOfficeNumber();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> bc.setBranchOfficeNumber("0a2"));
        assertEquals("店番は3桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetBranchOfficeNumberException02() {
        BranchOfficeNumber bc = new BranchOfficeNumber();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> bc.setBranchOfficeNumber("1235"));
        assertEquals("店番は3桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetBranchOfficeNumberException03() {
        BranchOfficeNumber bc = new BranchOfficeNumber();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> bc.setBranchOfficeNumber(""));
        assertEquals("店番は3桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetBranchOfficeNumberException04() {
        BranchOfficeNumber bc = new BranchOfficeNumber();
        String b = null;
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> bc.setBranchOfficeNumber(b));
        assertEquals("店番は3桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testEquals01() {
        BranchOfficeNumber bc1 = new BranchOfficeNumber("123");
        assertEquals(bc1, bc1);
    }

    @Test
    void testEquals02() {
        BranchOfficeNumber bc1 = new BranchOfficeNumber("123");
        BranchOfficeNumber bc2 = new BranchOfficeNumber("123");
        assertEquals(bc1, bc2);
    }

    @Test
    void testEquals03() {
        BranchOfficeNumber bc1 = new BranchOfficeNumber("123");
        BranchOfficeNumber bc2 = new BranchOfficeNumber("999");
        assertNotEquals(bc1, bc2);
    }

    @Test
    void testHashCode() {
        String c = "123";
        BranchOfficeNumber bc = new BranchOfficeNumber(c);
        int hc = Objects.hash(c);
        assertEquals(hc,bc.hashCode());
    }

    @Test
    void testCompareTo() {
        BranchOfficeNumber bc1 = new BranchOfficeNumber("001");
        BranchOfficeNumber bc2 = new BranchOfficeNumber("100");
        assertEquals(-1, bc1.compareTo(bc2));
        assertEquals(0, bc1.compareTo(bc1));
        assertEquals(1, bc2.compareTo(bc1));
    }

    @Test
    void testClone() {
        BranchOfficeNumber bc1 = new BranchOfficeNumber("123");
        BranchOfficeNumber bc2 = bc1.clone();
        assertEquals(bc1, bc2);
    }
}
