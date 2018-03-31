package com.simplemobiletools.calculator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.simplemobiletools.calculator.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule public final ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void addDigits() {
        press(R.id.btn_41);
        press(R.id.btn_42);
        press(R.id.btn_43);
        press(R.id.btn_31);
        press(R.id.btn_32);
        press(R.id.btn_33);
        press(R.id.btn_21);
        press(R.id.btn_22);
        press(R.id.btn_23);
        press(R.id.btn_51);
        checkResult("1,234,567,890");
    }

    @Test
    public void removeLeadingZero() {
        press(R.id.btn_51);
        press(R.id.btn_32);
        checkResult("5");
    }

    @Test
    public void additionTest() {
        press(R.id.btn_44);
        press(R.id.btn_42);
        press(R.id.btn_52);
        press(R.id.btn_32);
        press(R.id.btn_54);
        press(R.id.btn_33);
        press(R.id.btn_53);
        checkResult("3.5");
        checkFormula("-2.5+6");
        press(R.id.btn_53);
        checkResult("9.5");
        checkFormula("3.5+6");
    }

    @Test
    public void subtractionTest() {
        press(R.id.btn_21);
        press(R.id.btn_52);
        press(R.id.btn_22);
        press(R.id.btn_44);
        press(R.id.btn_43);
        press(R.id.btn_53);
        checkResult("4.8");
        checkFormula("7.8-3");
    }

    @Test
    public void multiplyTest() {
        press(R.id.btn_42);
        press(R.id.btn_34);
        press(R.id.btn_31);
        press(R.id.btn_53);
        checkResult("8");
        checkFormula("2*4");
    }

    @Test
    public void divisionTest() {
        press(R.id.btn_41);
        press(R.id.btn_51);
        press(R.id.btn_24);
        press(R.id.btn_31);
        press(R.id.btn_53);
        checkResult("2.5");
        checkFormula("10/4");
    }

    @Test
    public void divisionByZeroTest() {
        press(R.id.btn_22);
        press(R.id.btn_24);
        press(R.id.btn_51);
        press(R.id.btn_53);
        checkResult("0");
        checkFormula("8/0");
    }

    @Test
    public void moduloTest() {
        press(R.id.btn_21);
        press(R.id.btn_11);
        press(R.id.btn_42);
        press(R.id.btn_53);
        checkResult("1");
        checkFormula("7%2");
    }

    @Test
    public void powerTest() {
        press(R.id.btn_42);
        press(R.id.btn_12);
        press(R.id.btn_43);
        press(R.id.btn_53);
        checkResult("8");
        checkFormula("2^3");
    }

    @Test
    public void rootTest() {
        press(R.id.btn_23);
        press(R.id.btn_13);
        checkResult("3");
        checkFormula("√9");
    }

    @Test
    public void clearTest() {
        press(R.id.btn_42);
        press(R.id.btn_32);
        press(R.id.btn_52);
        press(R.id.btn_21);
        press(R.id.btn_14);
        checkResult("25");
        press(R.id.btn_14);
        checkResult("2");
        press(R.id.btn_14);
        checkResult("0");
        press(R.id.btn_14);
        checkResult("0");
    }

    @Test
    public void clearLongTest() {
        press(R.id.btn_42);
        press(R.id.btn_54);
        press(R.id.btn_32);
        press(R.id.btn_53);
        longPress((R.id.btn_14));
        press(R.id.btn_54);
        press(R.id.btn_42);
        press(R.id.btn_53);
        checkResult("2");
        checkFormula("");
    }

    @Test
    public void complexTest() {
        press(R.id.btn_42);
        press(R.id.btn_54);
        press(R.id.btn_32);
        press(R.id.btn_44);
        checkResult("7");
        checkFormula("2+5");

        press(R.id.btn_43);
        press(R.id.btn_34);
        checkResult("4");
        checkFormula("7-3");

        press(R.id.btn_32);
        press(R.id.btn_24);
        checkResult("20");
        checkFormula("4*5");

        press(R.id.btn_42);
        press(R.id.btn_11);
        checkResult("10");
        checkFormula("20/2");

        press(R.id.btn_31);
        press(R.id.btn_12);
        checkResult("2");
        checkFormula("10%4");

        press(R.id.btn_22);
        press(R.id.btn_11);
        checkResult("256");
        checkFormula("2^8");

        press(R.id.btn_13);
        checkResult("16");
        checkFormula("√256");

        press(R.id.btn_14);
        checkResult("1");

        press(R.id.btn_14);
        checkResult("0");
    }

    private void press(int id) {
        onView(withId(id)).perform(click());
    }

    private void longPress(int id) {
        onView(withId(id)).perform(longClick());
    }

    private void checkResult(String desired) {
        onView(withId(R.id.result)).check(matches(withText(desired)));
    }

    private void checkFormula(String desired) {
        onView(withId(R.id.formula)).check(matches(withText(desired)));
    }
}
