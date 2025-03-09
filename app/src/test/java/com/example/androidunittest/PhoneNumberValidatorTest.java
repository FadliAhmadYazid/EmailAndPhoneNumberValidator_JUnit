package com.example.androidunittest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PhoneNumberValidatorTest {

    /*
        Test case untuk validasi nomor telepon:
        1. Memasukkan nomor telepon valid dan memastikan nomor tersebut dianggap valid.
        2. Memasukkan nomor telepon yang mengandung huruf dan memastikan nomor tersebut dianggap tidak valid.
        3. Memasukkan nomor telepon yang terlalu pendek dan memastikan nomor tersebut dianggap tidak valid.
        4. Memasukkan nomor telepon yang terlalu panjang dan memastikan nomor tersebut dianggap tidak valid.
        5. Memasukkan nomor telepon kosong dan memastikan nomor tersebut dianggap tidak valid.
     */

    @Test
    public void testValidPhoneNumber() {
        // Memasukkan nomor telepon valid (12 digit, hanya angka)
        assertTrue(PhoneNumberValidator.isValidPhoneNumber("081234567890"));
    }

    @Test
    public void testPhoneNumberWithLetters() {
        // Memasukkan nomor telepon yang mengandung huruf
        assertFalse(PhoneNumberValidator.isValidPhoneNumber("0812abc567890"));
    }

    @Test
    public void testPhoneNumberTooShort() {
        // Memasukkan nomor telepon yang terlalu pendek (kurang dari 10 digit)
        assertFalse(PhoneNumberValidator.isValidPhoneNumber("08123456"));
    }

    @Test
    public void testPhoneNumberTooLong() {
        // Memasukkan nomor telepon yang terlalu panjang (lebih dari 13 digit)
        assertFalse(PhoneNumberValidator.isValidPhoneNumber("0812345678901234"));
    }

    @Test
    public void testEmptyPhoneNumber() {
        // Memasukkan nomor telepon kosong
        assertFalse(PhoneNumberValidator.isValidPhoneNumber(""));
    }
}