package com.cocreativeds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.Objects;
public class AccountTypeCodeTest {

    @Test
    void testAccountTypeCode() {
        AccountTypeCode ac = new AccountTypeCode();
        assertEquals("0", ac.getAccountTypeCode());
    }
    @Test
    void testGetAccountTypeCode() {
        AccountTypeCode ac = new AccountTypeCode("1");
        assertEquals("1", ac.getAccountTypeCode());
    }

    @Test
    void testSetAccountTypeCode() {
        AccountTypeCode ac = new AccountTypeCode();
        ac.setAccountTypeCode("9");
        assertEquals("9", ac.getAccountTypeCode());
    }

    @Test
    void testToString() {
        AccountTypeCode ac = new AccountTypeCode("1");
        assertEquals("預金種目コード: 1", ac.toString()); 
    }

    @Test
    void testSetAccountTypeCodeException01() {
        AccountTypeCode ac = new AccountTypeCode();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> ac.setAccountTypeCode("a"));
        assertEquals("預金種目コードは1桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountTypeCodeException02() {
        AccountTypeCode ac = new AccountTypeCode();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> ac.setAccountTypeCode("15"));
        assertEquals("預金種目コードは1桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountTypeCodeException03() {
        AccountTypeCode ac = new AccountTypeCode();
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> ac.setAccountTypeCode(""));
        assertEquals("預金種目コードは1桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountTypeCodeException04() {
        AccountTypeCode ac = new AccountTypeCode();
        String b = null;
        IllegalArgumentException expected = 
            assertThrows(IllegalArgumentException.class, () -> ac.setAccountTypeCode(b));
        assertEquals("預金種目コードは1桁の数字でなくてはならない", expected.getMessage());
    }

    @Test
    void testEquals01() {
        AccountTypeCode ac1 = new AccountTypeCode("1");
        assertEquals(ac1, ac1);
    }

    @Test
    void testEquals02() {
        AccountTypeCode ac1 = new AccountTypeCode("1");
        AccountTypeCode ac2 = new AccountTypeCode("1");
        assertEquals(ac1, ac2);
    }

    @Test
    void testEquals03() {
        AccountTypeCode ac1 = new AccountTypeCode("1");
        AccountTypeCode ac2 = new AccountTypeCode("9");
        assertNotEquals(ac1, ac2);
    }

    @Test
    void testHashCode() {
        String c = "1";
        AccountTypeCode ac = new AccountTypeCode(c);
        int hc = Objects.hash(c);
        assertEquals(hc,ac.hashCode());
    }

    @Test
    void testCompareTo() {
        AccountTypeCode ac1 = new AccountTypeCode("1");
        AccountTypeCode ac2 = new AccountTypeCode("9");
        assertTrue(ac1.compareTo(ac2) < 0);
        assertEquals(0,ac1.compareTo(ac1));
        assertTrue(ac2.compareTo(ac1) > 0);
    }

    @Test
    void testClone() {
        AccountTypeCode ac1 = new AccountTypeCode("1");
        AccountTypeCode ac2 = ac1.clone();
        assertEquals(ac1, ac2);
    }
}
