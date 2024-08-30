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
    static AuthorizationData authData = new AuthorizationData();
    private static View decorView;


    public static void waitingForLoadLoginPage() {
        Allure.step("Ожидание загрузки страницы Authorization Page");
        TestData.waitForElementToLoad(R.id.login_text_input_layout, 8000);
    }



    public static void pageLoading() {
        Allure.step("Проверка загрузки страницы авторизации");
        TestData.checkIsDisplayed(
                authData.getLoginField,
                authData.getPasswordField,
                authData.getEnterButton
        );
    }


    public static void enterValidCredentials() {
        Allure.step("Авторизация с валидными данными");
        VariablesData variables = new VariablesData("login2", "password2");
        enterLogin(variables.getLogin());
        enterPassword(variables.getPassword());
        clickEnterButton();
    }


    public static void enterNotValidCredentials() {
        Allure.step("Авторизация с невалидными данными");
        VariablesData variables = new VariablesData("log4321", "pass4321");
        enterLogin(variables.getLogin());
        enterPassword(variables.getPassword());
        clickEnterButton();
    }


    public static void enterNotValidLogin() {
        Allure.step("Авторизация с невалидным логином");
        VariablesData variables = new VariablesData("log4321", "password2");
        enterLogin(variables.getLogin());
        enterPassword(variables.getPassword());
        clickEnterButton();
    }


    public static void enterEmptyFields() {
        Allure.step("Авторизация с пустыми полями логина и пароля");
        VariablesData variables = new VariablesData("", "");
        enterLogin(variables.getLogin());
        enterPassword(variables.getPassword());
        clickEnterButton();
    }

    private static void enterLogin(String login) {
        authData.getLoginField.perform(typeText(login), ViewActions.closeSoftKeyboard());
    }

    private static void enterPassword(String password) {
        authData.getPasswordField.perform(typeText(password), ViewActions.closeSoftKeyboard());
    }

    private static void clickEnterButton() {
        authData.getEnterButton.perform(click());
    }



    public static void pageNotLoading(String message, View decorView) {
        Allure.step("Проверка, что страница авторизации снова отображается на экране");
        onView(withText(message))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }



    public static void performLogoutIfAuthenticated() {
        Allure.step("Выход из приложения");
        TestData.clickToElement(authData.getAuthorizationButton);
        TestData.clickToElement(authData.getLogOutButton);
    }


    @Step("Вход в приложение")
    public static void LogInToApp() {
        Allure.step("Вход в приложение");
        waitingForLoadLoginPage();
        pageLoading();
        enterValidCredentials();
        MainPageStep.waitingForLoadMainPage();
        MainPageStep.mainPageLoading();
    }



    public static void logOutFromApp() {
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


    private static void handleAuthorizationIconClick() {
        Allure.step("Клик по иконке Авторизация");
        TestData.checkIsDisplayed(authData.getAuthorizationButton);
        authData.getAuthorizationButton.perform(click());
    }


    private static void performLogOut() {
        Allure.step("Клик по кнопке Log Out");
        TestData.checkIsDisplayed(authData.getLogOutButton);
        authData.getLogOutButton.perform(click());
    }
}



