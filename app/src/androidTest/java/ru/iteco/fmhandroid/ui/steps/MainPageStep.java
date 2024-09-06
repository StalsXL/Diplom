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
    TestData testData = new TestData();
    MainData mainData = new MainData();


    public void mainPageLoading() {

        Allure.step("Проверка, что главная страница отображается на экране");
        testData.checkIsDisplayed(
                mainData.mainPageNewsList,
                mainData.mainPageQuotesButton,
                mainData.mainPageAllNewsButton
        );
    }

    public void notGetMainPageLogo() {
        Allure.step("Проверка баннера главной страницы");
        mainData.mainPageLogo.check(matches(not(isDisplayed())));
    }


    public void waitingForLoadMainPage() {
        Allure.step("Ожидание загрузки Main page");
        testData.waitForElementToLoad(R.id.container_list_news_include_on_fragment_main, 5000);
    }



    public void toQuotesPage() {
        Allure.step("Нажатие по кнопке Quotes");
        testData.clickToElement(mainData.mainPageQuotesButton);
    }


    public void toAllNewsPage() {
        Allure.step("Нажатие по кнопке ALL NEWS");
        testData.clickToElement(mainData.mainPageAllNewsButton);
    }

    public void toNewsPageViaMenu() {
        Allure.step("Нажатие по кнопке News через кнопку навигации");
        testData.clickToElement(mainData.navigationButton);
        testData.clickToElement(mainData.newsPageButton);
    }


    public void toAboutPageViaMenu() {
        Allure.step("Нажатие по кнопке News через кнопку навигации");
        testData.clickToElement(mainData.navigationButton);
        testData.clickToElement(mainData.aboutPageButton);
    }


    public void toMainPageViaMenu() {
        Allure.step("Нажатие по кнопке Main через кнопку навигации");
        testData.clickToElement(mainData.navigationButton);
        testData.clickToElement(mainData.mainPageButton);
    }
}
