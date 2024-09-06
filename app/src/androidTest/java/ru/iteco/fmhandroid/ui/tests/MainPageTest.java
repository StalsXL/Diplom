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
import ru.iteco.fmhandroid.ui.steps.ControlPanelStep;
import ru.iteco.fmhandroid.ui.steps.MainPageStep;
import ru.iteco.fmhandroid.ui.steps.NewsStep;


@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Страница Main.")

public class MainPageTest extends TestData {
    MainPageStep mainPageStep = new MainPageStep();
    AuthorizationStep authStep = new AuthorizationStep();
    AboutStep aboutStep = new AboutStep();

    @Before
    public void prepareToUp() {
        try {
            mainPageStep.waitingForLoadMainPage();
        } catch (Exception e) {
            authStep.LogInToApp();
            mainPageStep.waitingForLoadMainPage();
        }
    }


    @Story(value = "Переход на страницу News через кнопку ALL NEWS")
    @Test
    public void shouldGoFromMainToNewsViaAllNewsButton() {

        mainPageStep.toAllNewsPage();
    }

    @Story(value = "Переход на страницу News через кнопку ALL NEWS")
    @Test
    public void shouldGoFromMainToNewsViaNewsButton() {

        mainPageStep.toNewsPageViaMenu();
    }

    @Story(value = "Переход на страницу About")
    @Test
    public void shouldGoFromMainToAboutPage() {
        mainPageStep.toAboutPageViaMenu();
        aboutStep.AboutPageLoading();
    }
}

