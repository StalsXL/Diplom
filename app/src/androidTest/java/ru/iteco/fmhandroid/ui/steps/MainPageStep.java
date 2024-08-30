package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.not;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.MainData;
import ru.iteco.fmhandroid.ui.data.TestData;

public class MainPageStep {

    public static void mainPageLoading() {
        Allure.step("Проверка, что главная страница отображается на экране");
        TestData.checkIsDisplayed(
            MainData.mainPageNewsList,
            MainData.mainPageQuotesButton,
            MainData.mainPageAllNewsButton
        );
    }

    public static void notGetMainPageLogo() {
        Allure.step("Проверка баннера главной страницы");
        MainData.mainPageLogo.check(matches(not(isDisplayed())));
    }


    public static void waitingForLoadMainPage() {
        Allure.step("Ожидание загрузки Main page");
        TestData.waitForElementToLoad(R.id.container_list_news_include_on_fragment_main, 5000);
    }



    public static void toQuotesPage() {
        Allure.step("Нажатие по кнопке Quotes");
        TestData.clickToElement(MainData.mainPageQuotesButton);
    }


    public static void toAllNewsPage() {
        Allure.step("Нажатие по кнопке ALL NEWS");
        TestData.clickToElement(MainData.mainPageAllNewsButton);
    }

    public static void toNewsPageViaMenu() {
        Allure.step("Нажатие по кнопке News через кнопку навигации");
        TestData.clickToElement(MainData.navigationButton);
        TestData.clickToElement(MainData.newsPageButton);
    }


    public static void toAboutPageViaMenu() {
        Allure.step("Нажатие по кнопке News через кнопку навигации");
        TestData.clickToElement(MainData.navigationButton);
        TestData.clickToElement(MainData.aboutPageButton);
    }


    public static void toMainPageViaMenu() {
        Allure.step("Нажатие по кнопке Main через кнопку навигации");
        TestData.clickToElement(MainData.navigationButton);
        TestData.clickToElement(MainData.mainPageButton);
    }
}
