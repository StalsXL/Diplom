package ru.iteco.fmhandroid.ui.tests;

import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.steps.AboutStep;
import ru.iteco.fmhandroid.ui.steps.AuthorizationStep;
import ru.iteco.fmhandroid.ui.steps.MainPageStep;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Страница About.")

public class AboutPageTest extends TestData {
    MainPageStep mainPageStep = new MainPageStep();
    AuthorizationStep authStep = new AuthorizationStep();
    AboutStep aboutStep = new AboutStep();


    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void prepareToUp() {
        try {
            mainPageStep.waitingForLoadMainPage();
        } catch (Exception e) {
            authStep.LogInToApp();
            mainPageStep.waitingForLoadMainPage();
        }
    }

    @Story(value = "Переход со страницы About на страницу Main")
    @Test
    public void shouldGoFromAboutToMain() {
        mainPageStep.toAboutPageViaMenu();
        aboutStep.AboutPageLoading();
        aboutStep.fromAboutToMain();

    }




    @Story(value = "Переход по ссылке Privacy Policy")
    @Test
    public void shouldGoToPrivacyPolicyLink() {
        mainPageStep.toAboutPageViaMenu();
        aboutStep.AboutPageLoading();
        aboutStep.goToPrivacyPolicyLink();
        aboutStep.checkPrivacyPolicyText();
        Espresso.pressBack();
    }



    @Story(value = "Переход по ссылке Terms Of Use")
    @Test
    public void shouldGoToTermsOfUseLink() {
        mainPageStep.toAboutPageViaMenu();
        aboutStep.AboutPageLoading();
        aboutStep.goToTermsOfUseLink();
        aboutStep.checkTermsOfUseText();
        Espresso.pressBack();
    }

}


