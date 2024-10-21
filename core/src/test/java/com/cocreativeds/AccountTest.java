package com.cocreativeds;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class AccountTest {

    @Test
    void testOpenAccount() {
        Account a = new Account();
        a.openAccount(new BankCode("1234"), new BranchOfficeNumber("001"), new AccountTypeCode("1"));
        System.out.println(a.toString());
    }

    @Test
    void testToString() {
        Account ac = new Account(new BankCode("1234"),
        new BranchOfficeNumber("123"),
        new AccountTypeCode("1"),
        new AccountNumber("1234567"),
        new AccountId("0123456789ABCDEFGHJKMNPQRS"));
        assertEquals("口座: 1234-123-1-1234567-0123456789ABCDEFGHJKMNPQRS", ac.toString());;
    }
}
