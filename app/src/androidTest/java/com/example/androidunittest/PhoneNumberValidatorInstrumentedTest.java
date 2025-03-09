package com.example.androidunittest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class PhoneNumberValidatorInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /*
        Test case untuk instrumental test:
        1. Memasukkan nomor telepon valid dan memastikan tombol "Lanjutkan" diaktifkan.
        2. Memasukkan nomor telepon tidak valid dan memastikan tombol "Lanjutkan" tetap dinonaktifkan.
     */

    @Test
    public void testValidPhoneNumberEnablesContinueButton() {
        // Memasukkan nomor telepon valid (12 digit, hanya angka)
        onView(withId(R.id.phoneInput)).perform(typeText("081234567890"));
        // Klik tombol validasi nomor telepon
        onView(withId(R.id.validatePhoneButton)).perform(click());
        // Memastikan tombol "Lanjutkan" diaktifkan
        onView(withId(R.id.continueButton)).check(matches(isEnabled()));
    }

    @Test
    public void testInvalidPhoneNumberDisablesContinueButton() {
        // Memasukkan nomor telepon tidak valid (mengandung huruf)
        onView(withId(R.id.phoneInput)).perform(typeText("0812abc567890"));
        // Klik tombol validasi nomor telepon
        onView(withId(R.id.validatePhoneButton)).perform(click());
        // Memastikan tombol "Lanjutkan" tetap dinonaktifkan
        onView(withId(R.id.continueButton)).check(matches(not(isEnabled())));
    }
}