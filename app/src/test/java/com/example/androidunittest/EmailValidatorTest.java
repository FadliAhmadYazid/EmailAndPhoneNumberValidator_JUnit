package com.example.androidunittest;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmailValidatorTest {

    /*
        Test case untuk validasi email:
        1. Email valid dengan format standar.
        2. Email tanpa domain -> tidak valid.
        3. Email tanpa "@" -> tidak valid.
        4. Email dengan domain tidak valid (tanpa titik) -> tidak valid.
        5. Email kosong -> tidak valid.
     */

    @Test
    public void testValidEmail() {
        assertTrue(EmailValidator.isValidEmail("test@example.com"));
    }

    @Test
    public void testEmailWithoutDomain() {
        assertFalse(EmailValidator.isValidEmail("test@"));
    }

    @Test
    public void testEmailWithoutAtSymbol() {
        assertFalse(EmailValidator.isValidEmail("testexample.com"));
    }

    @Test
    public void testEmailWithInvalidDomain() {
        assertFalse(EmailValidator.isValidEmail("test@example"));
    }

    @Test
    public void testEmptyEmail() {
        assertFalse(EmailValidator.isValidEmail(""));
    }
}