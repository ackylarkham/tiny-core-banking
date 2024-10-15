package com.cocreativeds;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void testToString() {
        Account ac = new Account("1234","123","1","1234567","1111111111");
        assertEquals("口座: 1234-123-1-1234567-1111111111", ac.toString());;
    }
}
