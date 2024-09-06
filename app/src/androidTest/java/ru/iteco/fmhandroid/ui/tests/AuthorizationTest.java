package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.not;


import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.data.MainData;
import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.steps.AuthorizationStep;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.steps.MainPageStep;


@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Вход в личный кабинет. Авторизация.")
public class AuthorizationTest extends TestData {
    AuthorizationStep authStep = new AuthorizationStep();
    MainPageStep mainPageStep = new MainPageStep();


    private View decorView;
    @Story(value = "Ввод валидных значений и выход из приложения")
    @Test
    public void validLoginTest() {
        authStep.LogInToApp();
        authStep.logOutFromApp();
    }


    @Story(value = "Ввод невалидных данных")
    @Test
    public void notValidCredentials() {
        try {
            authStep.waitingForLoadLoginPage();
            authStep.enterNotValidCredentials();
            authStep.pageNotLoading("Something went wrong. Try again later.", decorView);
            mainPageStep.notGetMainPageLogo();
        } catch (Exception e) {
            authStep.performLogoutIfAuthenticated();
        }
    }
    @Story(value = "Ввод невалидного логина")
    @Test
    public void notValidLogin() {
        try {
            authStep.waitingForLoadLoginPage();
            authStep.enterNotValidLogin();
            authStep.pageNotLoading("Something went wrong. Try again later.", decorView);
            authStep.waitingForLoadLoginPage();
        } catch (Exception e) {
            authStep.performLogoutIfAuthenticated();
        }
    }

    @Story(value = "Ввод с пустыми полями")
    @Test
    public void emptyLoginAndPassword() {
        try {
            authStep.waitingForLoadLoginPage();
            authStep.enterEmptyFields();

            authStep.pageNotLoading("Login and password cannot be empty", decorView);
            mainPageStep.notGetMainPageLogo();
        } catch (Exception e) {
            authStep.performLogoutIfAuthenticated();
        }
    }

}

