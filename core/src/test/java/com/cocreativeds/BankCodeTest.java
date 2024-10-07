package com.cocreativeds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class BankCodeTest {
    @Test
    void testBankCode() {
        BankCode bc = new BankCode();
        assertEquals("0000", bc.getBankCode());
    }
    @Test
    void testGetBankCode() {
        BankCode bc = new BankCode("1234");
        assertEquals("1234", bc.getBankCode());
    }

    @Test
    void testSetBankCode() {
        BankCode bc = new BankCode();
        bc.setBankCode("9999");
        assertEquals("9999", bc.getBankCode());
    }

    @Test
    void testToString() {
        BankCode bc = new BankCode("1234");
        assertEquals("金融機関コード: 1234", bc.toString()); 
    }

    @Test
    void testSetBankCodeException01() {
        BankCode bc = new BankCode();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> bc.setBankCode("0a23"));
        assertEquals("金融機関コードは4桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetBankCodeException02() {
        BankCode bc = new BankCode();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> bc.setBankCode("12345"));
        assertEquals("金融機関コードは4桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetBankCodeException03() {
        BankCode bc = new BankCode();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> bc.setBankCode(""));
        assertEquals("金融機関コードは4桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetBankCodeException04() {
        BankCode bc = new BankCode();
        String b = null;
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> bc.setBankCode(b));
        assertEquals("金融機関コードは4桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testEquals01() {
        BankCode bc1 = new BankCode("1234");
        assertEquals(bc1, bc1);
    }

    @Test
    void testEquals02() {
        BankCode bc1 = new BankCode("1234");
        BankCode bc2 = new BankCode("1234");
        assertEquals(bc1, bc2);
    }

    @Test
    void testEquals03() {
        BankCode bc1 = new BankCode("1234");
        BankCode bc2 = new BankCode("9999");
        assertNotEquals(bc1, bc2);
    }

    @Test
    void testHashCode() {
        String c = "1234";
        BankCode bc = new BankCode(c);
        int hc = Objects.hash(c);
        assertEquals(hc,bc.hashCode());
    }

    @Test
    void testCompareTo() {
        BankCode bc1 = new BankCode("0001");
        BankCode bc2 = new BankCode("0100");
        assertEquals(-1, bc1.compareTo(bc2));
        assertEquals(0, bc1.compareTo(bc1));
        assertEquals(1, bc2.compareTo(bc1));
    }

    @Test
    void testClone() {
        BankCode bc1 = new BankCode("1234");
        BankCode bc2 = bc1.clone();
        assertEquals(bc1, bc2);
    }
}
