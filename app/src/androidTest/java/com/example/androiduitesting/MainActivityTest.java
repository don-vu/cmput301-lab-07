package com.example.androiduitesting;
import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> scenario = new
            ActivityScenarioRule<MainActivity>(MainActivity.class);
    @Test
    public void testActivitySwitch(){
        // Click on first item in city list
        onData(anything())
                .inAdapterView(withId(R.id.city_list))
                .atPosition(0)
                .perform(click());

        // Check if text "Back" is matched with any of the text
        // displayed on the screen
        onView(withText("Back")).check(matches(isDisplayed()));
    }
    @Test
    public void testConsistentCityName(){
        // City to match
        String city = "Edmonton";

        // Click on first item in city list
        onData(anything())
                .inAdapterView(withId(R.id.city_list))
                .atPosition(0)
                .perform(click());

        // Check if text "Edmonton" is matched with any of the text
        // displayed on the screen
        onView(withText("Edmonton")).check(matches(isDisplayed()));
    }
    @Test
    public void testBackButton(){
        // Click on first item in city list
        onData(anything())
                .inAdapterView(withId(R.id.city_list))
                .atPosition(0)
                .perform(click());

        // Click on the back button
        onView(withId(R.id.backButton)).perform(click());

        // Check if text "ADD CITY" is matched with any of the text
        // displayed on the screen
        onView(withText("ADD CITY")).check(matches(isDisplayed()));
    }
}