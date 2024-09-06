package ru.iteco.fmhandroid.ui.tests;

import androidx.test.espresso.Espresso;

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
import ru.iteco.fmhandroid.ui.steps.NewsStep;


@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Страница News.")

public class NewsPageTest extends TestData {
    MainPageStep mainPageStep = new MainPageStep();
    AuthorizationStep authStep = new AuthorizationStep();
    AboutStep aboutStep = new AboutStep();
    NewsStep newsStep = new NewsStep();

    @Before
    public void prepareToUp() {
        try {
            mainPageStep.waitingForLoadMainPage();
        } catch (Exception e) {
            authStep.LogInToApp();
            mainPageStep.waitingForLoadMainPage();
        }
    }

    @Story(value = "Переход со страницы News на страницу Main")
    @Test
    public void shouldGoFromNewsToMain() {
        mainPageStep.toAllNewsPage();
        newsStep.NewsPageLoading();
        mainPageStep.toMainPageViaMenu();
        mainPageStep.mainPageLoading();
    }

    @Story(value = "Переход со страницы News на страницу About")
    @Test
    public void shouldGoFromNewsToAbout() {
        mainPageStep.toAllNewsPage();
        newsStep.NewsPageLoading();
        mainPageStep.toAboutPageViaMenu();
        aboutStep.AboutPageLoading();
        Espresso.pressBack();
    }


}
