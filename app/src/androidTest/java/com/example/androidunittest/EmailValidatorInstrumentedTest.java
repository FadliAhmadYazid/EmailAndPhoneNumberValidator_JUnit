package com.example.androidunittest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EmailValidatorInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /*
        Test case untuk instrumental test:
        1. Memasukkan email valid dan memastikan tombol "Lanjutkan" diaktifkan.
        2. Memasukkan email tanpa domain dan memastikan tombol "Lanjutkan" tetap dinonaktifkan.
        3. Memasukkan email tanpa "@" dan memastikan pesan error ditampilkan.
        4. Memasukkan email kosong dan memastikan tombol "Lanjutkan" tetap dinonaktifkan.
     */

    @Test
    public void testValidEmailEnablesContinueButton() {
        // Memasukkan email valid
        onView(withId(R.id.emailInput)).perform(typeText("test@example.com"));
        // Klik tombol validasi
        onView(withId(R.id.validateButton)).perform(click());
        // Memastikan tombol "Lanjutkan" diaktifkan
        onView(withId(R.id.continueButton)).check(matches(isEnabled()));
    }

    @Test
    public void testEmailWithoutDomainDisablesContinueButton() {
        // Memasukkan email tanpa domain
        onView(withId(R.id.emailInput)).perform(typeText("test@"));
        // Klik tombol validasi
        onView(withId(R.id.validateButton)).perform(click());
        // Memastikan tombol "Lanjutkan" dinonaktifkan
        onView(withId(R.id.continueButton)).check(matches(not(isEnabled())));
    }

    @Test
    public void testEmailWithoutAtSymbolShowsErrorMessage() {
        // Memasukkan email tanpa "@"
        onView(withId(R.id.emailInput)).perform(typeText("testexample.com"));
        // Klik tombol validasi
        onView(withId(R.id.validateButton)).perform(click());
        // Memastikan pesan error ditampilkan
        onView(withId(R.id.errorMessage)).check(matches(withText("Email tidak valid!")));
    }

    @Test
    public void testEmptyEmailDisablesContinueButton() {
        // Memasukkan email kosong
        onView(withId(R.id.emailInput)).perform(typeText(""));
        // Klik tombol validasi
        onView(withId(R.id.validateButton)).perform(click());
        // Memastikan tombol "Lanjutkan" dinonaktifkan
        onView(withId(R.id.continueButton)).check(matches(not(isEnabled())));
    }
}