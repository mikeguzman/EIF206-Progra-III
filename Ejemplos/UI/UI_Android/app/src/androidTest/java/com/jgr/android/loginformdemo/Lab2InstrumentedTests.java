package com.jgr.android.loginformdemo;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Lab2InstrumentedTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testUIAttributes(){
        onView(withId(R.id.name_edit_text)).check(matches(withHint(R.string.name_hint)));
        onView(withId(R.id.phone_number_edit_text)).check(matches(withHint(R.string.phone_hint)));
        onView(withId(R.id.gender_spinner)).perform(click());

        onData(allOf(is(instanceOf(String.class)), is("Femenino"))).perform(click());
        onView(withId(R.id.gender_spinner)).check(matches(withSpinnerText("Femenino")));

        onView(withId(R.id.clear_button)).check(matches(withText(R.string.clear_button_text)));
        onView(withId(R.id.accept_button)).check(matches(withText(R.string.accept_button_text)));
        onView(withId(R.id.user_info_textview));
    }

    @Test
    public void clearCorrect(){
        onView(withId(R.id.name_edit_text)).perform(typeText("Jason"));
        onView(withId(R.id.phone_number_edit_text)).perform(typeText("1545"));
        onView(withId(R.id.clear_button)).perform(click());
        onView(withId(R.id.name_edit_text)).check(matches(withText("")));
        onView(withId(R.id.phone_number_edit_text)).check(matches(withText("")));
        onView(withId(R.id.gender_spinner)).check(matches(withSpinnerText("Masculino")));
    }

    @Test
    public void acceptCorrect(){
        String value = "Nombre: Jason \nTelefono: 1545 \nGenero: Masculino";
        onView(withId(R.id.name_edit_text)).perform(typeText("Jason"));
        onView(withId(R.id.phone_number_edit_text)).perform(typeText("1545"));
        onView(withId(R.id.accept_button)).perform(click());
        onView(withId(R.id.user_info_textview)).check(matches(withText(value)));
    }
}
