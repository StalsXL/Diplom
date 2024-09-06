package ru.iteco.fmhandroid.ui.tests;


import org.junit.Before;

import io.qameta.allure.kotlin.Story;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;

import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.steps.AboutStep;
import ru.iteco.fmhandroid.ui.steps.AuthorizationStep;
import ru.iteco.fmhandroid.ui.steps.MainPageStep;
import ru.iteco.fmhandroid.ui.steps.NewsStep;
import ru.iteco.fmhandroid.ui.steps.QuotesStep;


@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Страница Quotes.")
public class QuotesPageTest extends TestData {
    MainPageStep mainPageStep = new MainPageStep();
    AuthorizationStep authStep = new AuthorizationStep();
    QuotesStep quotesStep = new QuotesStep();
    @Before
    public void prepareToUp() {
        try {
            mainPageStep.waitingForLoadMainPage();
        } catch (Exception e) {
            authStep.LogInToApp();
            mainPageStep.waitingForLoadMainPage();
        }
    }

    @Story(value = "Переход со страницы Main на Quotes")
    @Test
    public void shouldGoFromMainToQuotes() {
        mainPageStep.toQuotesPage();
        quotesStep.quotesWaiting();
        quotesStep.quotesLoading();
    }


}
