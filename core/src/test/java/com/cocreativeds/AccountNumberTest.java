package com.cocreativeds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class AccountNumberTest {

    @Test
    void testAccountNumber() {
        AccountNumber an = new AccountNumber();
        assertEquals("0000000", an.getAccountNumber());
    }
    @Test
    void testGetAccountNumber() {
        AccountNumber an = new AccountNumber("1234567");
        assertEquals("1234567", an.getAccountNumber());
    }

    @Test
    void testSetAccountNumber() {
        AccountNumber an = new AccountNumber();
        an.setAccountNumber("9999999");
        assertEquals("9999999", an.getAccountNumber());
    }

    @Test
    void testToString() {
        AccountNumber an = new AccountNumber("1234567");
        assertEquals("口座番号: 1234567", an.toString()); 
    }

    @Test
    void testSetAccountNumberException01() {
        AccountNumber an = new AccountNumber();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> an.setAccountNumber("123456a"));
        assertEquals("口座番号は7桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountNumberException02() {
        AccountNumber an = new AccountNumber();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> an.setAccountNumber("12345678"));
        assertEquals("口座番号は7桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountNumberException03() {
        AccountNumber an = new AccountNumber();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> an.setAccountNumber(""));
        assertEquals("口座番号は7桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountNumberException04() {
        AccountNumber an = new AccountNumber();
        String b = null;
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> an.setAccountNumber(b));
        assertEquals("口座番号は7桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testEquals01() {
        AccountNumber an1 = new AccountNumber("1234567");
        assertEquals(an1, an1);
    }

    @Test
    void testEquals02() {
        AccountNumber an1 = new AccountNumber("1234567");
        AccountNumber an2 = new AccountNumber("1234567");
        assertEquals(an1, an2);
    }

    @Test
    void testEquals03() {
        AccountNumber an1 = new AccountNumber("1234567");
        AccountNumber an2 = new AccountNumber("9999999");
        assertNotEquals(an1, an2);
    }

    @Test
    void testHashCode() {
        String c = "1234567";
        AccountNumber an = new AccountNumber(c);
        int hc = Objects.hash(c);
        assertEquals(hc,an.hashCode());
    }

    @Test
    void testCompareTo() {
        AccountNumber an1 = new AccountNumber("1234567");
        AccountNumber an2 = new AccountNumber("1234568");
        assertTrue(an1.compareTo(an2) < 0);
        assertEquals(0,an1.compareTo(an1));
        assertTrue(an2.compareTo(an1) > 0);
    }

    @Test
    void testClone() {
        AccountNumber an1 = new AccountNumber("1234567");
        AccountNumber an2 = an1.clone();
        assertEquals(an1, an2);
    }

    @Test
    void testGenerateAccountNumber() {
        AccountNumber a = new AccountNumber();
        a.generateAccountNumber();
        System.out.println(a.getAccountNumber());
    }
}