package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.not;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.data.AboutData;
import ru.iteco.fmhandroid.ui.data.TestData;

public class AboutStep {

    @Step("Проверка открытия страницы About")
    public static void AboutPageLoading() {
        TestData.checkIsDisplayed(
                AboutData.versionApp,
                AboutData.privacyPolicyTitle,
                AboutData.privacyPolicyLink,
                AboutData.termsOfUseTitle,
                AboutData.termsOfUseLink,
                AboutData.backButton,
                AboutData.versionTitle,
                AboutData.versionNumber,
                AboutData.logoAbout
        );
    }


    public static void fromAboutToMain() {
        Allure.step("Переход на страницу Main");
        TestData.clickToElement(
                AboutData.backButton
        );
    }


    public static void goToPrivacyPolicyLink() {
        Allure.step("Клик по ссылке на Privacy Policy");
        TestData.clickToElement(
                AboutData.privacyPolicyLink
        );
    }


    public static void checkPrivacyPolicyText() {
        Allure.step("Проверка, что текст Privacy Policy отображается");
        TestData.checkIsDisplayed(
                AboutData.privacyPolicyText
        );
    }
    @Step("Клик по ссылке на Terms Of Use")
    public static void goToTermsOfUseLink() {
        Allure.step("Клик по ссылке на Terms Of Use");
        TestData.clickToElement(
                AboutData.termsOfUseLink
        );
    }

    public static void checkTermsOfUseText() {
        Allure.step("Проверка, что текст Terms Of Use отображается");
        TestData.checkIsDisplayed(
                AboutData.termsOfUseText
        );
    }
}
