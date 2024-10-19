package com.cocreativeds;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class AccountIdTest {
    @Test
    void testClone() {
        AccountId a1 = new AccountId("0123456789ABCDEFGHJKMNPQRS");
        AccountId a2 = a1.clone();
        assertEquals(a1, a2);
    }

    @Test
    void testCompareTo() {
        AccountId a1 = new AccountId();
        AccountId a2 = new AccountId();
        a2.generateAccountId();
        assertTrue(a1.compareTo(a2) < 0);
        assertEquals(0,a1.compareTo(a1));
        assertTrue(a2.compareTo(a1) > 0);
    }

    @Test
    void testEquals01() {
        AccountId a1 = new AccountId();
        assertEquals(a1, a1);
    }

    @Test
    void testEquals02() {
        AccountId a1 = new AccountId();
        AccountId a2 = new AccountId();
        assertEquals(a1, a2);
    }

    @Test
    void testEquals03() {
        AccountId a1 = new AccountId();
        AccountId a2 = new AccountId();
        a2.generateAccountId();
        assertNotEquals(a1, a2);
    }
    @Test
    void testGenerateAccountId() {
        AccountId a = new AccountId();
        a.generateAccountId();
        System.out.println(a.getAccountId());
    }

    @Test
    void testGetAccountId() {
        AccountId a = new AccountId();
        assertEquals("00000000000000000000000000", a.getAccountId());
    }

    @Test
    void testHashCode() {
        AccountId a = new AccountId();
        int hc = Objects.hash("00000000000000000000000000");
        assertEquals(hc,a.hashCode());
    }

    @Test
    void testSetAccountId() {
        AccountId a = new AccountId();
        a.setAccountId("0123456789ABCDEFGHJKMNPQRS");
        assertEquals("0123456789ABCDEFGHJKMNPQRS", a.getAccountId());
    }

    @Test
    void testToString() {
        AccountId a = new AccountId();
        assertEquals("口座識別子: 00000000000000000000000000", a.toString());
    }

    /* エラーケース */
    @Test
    void testSetAccountIdError01() {
        AccountId a = new AccountId();
        IllegalArgumentException expected = 
        assertThrows(IllegalArgumentException.class, () -> a.setAccountId(null)); //null
    assertEquals("口座識別子は26桁の文字列でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountIdError02() {
        AccountId a = new AccountId();
        IllegalArgumentException expected = 
        assertThrows(IllegalArgumentException.class, () -> a.setAccountId("0123456789ABCDEFGHJKMNPQRST")); //1文字長い
    assertEquals("口座識別子は26桁の文字列でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountIdError03() {
        AccountId a = new AccountId();
        IllegalArgumentException expected = 
        assertThrows(IllegalArgumentException.class, () -> a.setAccountId("0123456789ABCDEFGHJKMNPQR")); //1文字短い
    assertEquals("口座識別子は26桁の文字列でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountIdError04() {
        AccountId a = new AccountId();
        IllegalArgumentException expected = 
        assertThrows(IllegalArgumentException.class, () -> a.setAccountId("0123456789IBCDEFGHJKMNPQRS")); //使用できない文字が含まれている
    assertEquals("口座識別子は26桁の文字列でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountIdError05() {
        AccountId a = new AccountId();
        IllegalArgumentException expected = 
        assertThrows(IllegalArgumentException.class, () -> a.setAccountId("0123456789LBCDEFGHJKMNPQRS")); //使用できない文字が含まれている
    assertEquals("口座識別子は26桁の文字列でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountIdError06() {
        AccountId a = new AccountId();
        IllegalArgumentException expected = 
        assertThrows(IllegalArgumentException.class, () -> a.setAccountId("0123456789OBCDEFGHJKMNPQRS")); //使用できない文字が含まれている
    assertEquals("口座識別子は26桁の文字列でなくてはならない", expected.getMessage());
    }

    @Test
    void testSetAccountIdError07() {
        AccountId a = new AccountId();
        IllegalArgumentException expected = 
        assertThrows(IllegalArgumentException.class, () -> a.setAccountId("0123456789UBCDEFGHJKMNPQRS")); //使用できない文字が含まれている
    assertEquals("口座識別子は26桁の文字列でなくてはならない", expected.getMessage());
    }
}
