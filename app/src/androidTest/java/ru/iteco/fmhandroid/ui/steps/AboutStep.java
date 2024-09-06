package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.not;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.data.AboutData;
import ru.iteco.fmhandroid.ui.data.TestData;

public class AboutStep {
    AboutData aboutData = new AboutData();
    TestData testData = new TestData();

    @Step("Проверка открытия страницы About")
    public void AboutPageLoading() {
        testData.checkIsDisplayed(
                aboutData.versionApp,
                aboutData.privacyPolicyTitle,
                aboutData.privacyPolicyLink,
                aboutData.termsOfUseTitle,
                aboutData.termsOfUseLink,
                aboutData.backButton,
                aboutData.versionTitle,
                aboutData.versionNumber,
                aboutData.logoAbout
        );
    }


    public void fromAboutToMain() {
        Allure.step("Переход на страницу Main");
        testData.clickToElement(
                aboutData.backButton
        );
    }


    public void goToPrivacyPolicyLink() {
        Allure.step("Клик по ссылке на Privacy Policy");
        testData.clickToElement(
                aboutData.privacyPolicyLink
        );
    }


    public void checkPrivacyPolicyText() {
        Allure.step("Проверка, что текст Privacy Policy отображается");
        testData.checkIsDisplayed(
                aboutData.privacyPolicyText
        );
    }
    @Step("Клик по ссылке на Terms Of Use")
    public void goToTermsOfUseLink() {
        Allure.step("Клик по ссылке на Terms Of Use");
        testData.clickToElement(
                aboutData.termsOfUseLink
        );
    }

    public void checkTermsOfUseText() {
        Allure.step("Проверка, что текст Terms Of Use отображается");
        testData.checkIsDisplayed(
                aboutData.termsOfUseText
        );
    }
}
