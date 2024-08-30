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

    @Before
    public void prepareToUp() {
        try {
            MainPageStep.waitingForLoadMainPage();
        } catch (Exception e) {
            AuthorizationStep.LogInToApp();
            MainPageStep.waitingForLoadMainPage();
        }
    }

    @Story(value = "Переход со страницы News на страницу Main")
    @Test
    public void shouldGoFromNewsToMain() {
        MainPageStep.toAllNewsPage();
        NewsStep.NewsPageLoading();
        MainPageStep.toMainPageViaMenu();
        MainPageStep.mainPageLoading();
    }

    @Story(value = "Переход со страницы News на страницу About")
    @Test
    public void shouldGoFromNewsToAbout() {
        MainPageStep.toAllNewsPage();
        NewsStep.NewsPageLoading();
        MainPageStep.toAboutPageViaMenu();
        AboutStep.AboutPageLoading();
        Espresso.pressBack();
    }


}
