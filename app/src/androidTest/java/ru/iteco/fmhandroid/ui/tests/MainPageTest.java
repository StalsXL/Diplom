package ru.iteco.fmhandroid.ui.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.steps.AboutStep;
import ru.iteco.fmhandroid.ui.steps.AuthorizationStep;
import ru.iteco.fmhandroid.ui.steps.MainPageStep;


@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Страница Main.")

public class MainPageTest extends TestData {

    @Before
    public void prepareToUp() {
        try {
            MainPageStep.waitingForLoadMainPage();
        } catch (Exception e) {
            AuthorizationStep.LogInToApp();
            MainPageStep.waitingForLoadMainPage();
        }
    }


    @Story(value = "Переход на страницу News через кнопку ALL NEWS")
    @Test
    public void shouldGoFromMainToNewsViaAllNewsButton() {

        MainPageStep.toAllNewsPage();
    }

    @Story(value = "Переход на страницу News через кнопку ALL NEWS")
    @Test
    public void shouldGoFromMainToNewsViaNewsButton() {

        MainPageStep.toNewsPageViaMenu();
    }

    @Story(value = "Переход на страницу About")
    @Test
    public void shouldGoFromMainToAboutPage() {
        MainPageStep.toAboutPageViaMenu();
        AboutStep.AboutPageLoading();
    }
}

