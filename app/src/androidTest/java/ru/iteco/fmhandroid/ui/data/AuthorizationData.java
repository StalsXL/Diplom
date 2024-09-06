package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.widget.EditText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationData {
    TestData testData = new TestData();
    public ViewInteraction getLoginField = testData.getInputField(R.id.login_text_input_layout);
    public ViewInteraction getPasswordField = testData.getInputField(R.id.password_text_input_layout);
    public ViewInteraction getEnterButton = testData.findViewById(R.id.enter_button);
    public ViewInteraction getAuthorizationButton = testData.findViewById(R.id.authorization_image_button);
    public ViewInteraction getLogOutButton = testData.findViewByText("Log out");





}

