package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.espresso.action.ViewActions;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.data.AuthorizationData;
import ru.iteco.fmhandroid.ui.data.VariablesData;

public class AuthorizationStep {
    AuthorizationData authData = new AuthorizationData();
    TestData testData = new TestData();
    MainPageStep mainPageStep = new MainPageStep();

    private static View decorView;


    public void waitingForLoadLoginPage() {
        Allure.step("Ожидание загрузки страницы Authorization Page");
        testData.waitForElementToLoad(R.id.login_text_input_layout, 8000);
    }



    public void pageLoading() {
        Allure.step("Проверка загрузки страницы авторизации");
        testData.checkIsDisplayed(
                authData.getLoginField,
                authData.getPasswordField,
                authData.getEnterButton
        );
    }


    public void enterValidCredentials() {
        Allure.step("Авторизация с валидными данными");
        VariablesData.User user = new VariablesData.User("login2", "password2");
        enterLogin(user.getLogin());
        enterPassword(user.getPassword());
        clickEnterButton();
    }


    public void enterNotValidCredentials() {
        Allure.step("Авторизация с невалидными данными");
        VariablesData.User user = new VariablesData.User("log4321", "pass4321");
        enterLogin(user.getLogin());
        enterPassword(user.getPassword());
        clickEnterButton();
    }


    public void enterNotValidLogin() {
        Allure.step("Авторизация с невалидным логином");
        VariablesData.User user = new VariablesData.User("log4321", "password2");
        enterLogin(user.getLogin());
        enterPassword(user.getPassword());
        clickEnterButton();
    }


    public void enterEmptyFields() {
        Allure.step("Авторизация с пустыми полями логина и пароля");
        VariablesData.User user = new VariablesData.User("", "");
        enterLogin(user.getLogin());
        enterPassword(user.getPassword());
        clickEnterButton();
    }

    private void enterLogin(String login) {
        authData.getLoginField.perform(typeText(login), ViewActions.closeSoftKeyboard());
    }

    private void enterPassword(String password) {
        authData.getPasswordField.perform(typeText(password), ViewActions.closeSoftKeyboard());
    }

    private void clickEnterButton() {

        authData.getEnterButton.perform(click());
    }



    public  void pageNotLoading(String message, View decorView) {
        Allure.step("Проверка, что страница авторизации снова отображается на экране");
        onView(withText(message))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }



    public void performLogoutIfAuthenticated() {
        Allure.step("Выход из приложения");
        testData.clickToElement(authData.getAuthorizationButton);
        testData.clickToElement(authData.getLogOutButton);
    }


    @Step("Вход в приложение")
    public void LogInToApp() {
        Allure.step("Вход в приложение");
        waitingForLoadLoginPage();
        pageLoading();
        enterValidCredentials();
        mainPageStep.waitingForLoadMainPage();
        mainPageStep.mainPageLoading();
    }



    public void logOutFromApp() {
        Allure.step("Выход из приложения");
        try {
            waitingForLoadLoginPage();
            pageLoading();
        } catch (Exception e) {
            handleAuthorizationIconClick();
            performLogOut();
            pageLoading();

        }
    }


    private void handleAuthorizationIconClick() {
        Allure.step("Клик по иконке Авторизация");
        testData.checkIsDisplayed(authData.getAuthorizationButton);
        authData.getAuthorizationButton.perform(click());
    }


    private void performLogOut() {
        Allure.step("Клик по кнопке Log Out");
        testData.checkIsDisplayed(authData.getLogOutButton);
        authData.getLogOutButton.perform(click());
    }
}



