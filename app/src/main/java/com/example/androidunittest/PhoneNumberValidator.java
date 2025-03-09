package com.example.androidunittest;

public class PhoneNumberValidator {

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }

        // Regex sederhana untuk validasi nomor telepon (contoh: 081234567890)
        String phonePattern = "^[0-9]{10,13}$";
        return phoneNumber.matches(phonePattern);
    }
}


