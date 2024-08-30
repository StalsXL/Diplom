package ru.iteco.fmhandroid.ui.steps;


import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.NewsData;
import ru.iteco.fmhandroid.ui.data.TestData;

public class NewsStep {



    public static void NewsPageLoading() {
        Allure.step("Проверка открытия страницы News");
        TestData.checkIsDisplayed(
                NewsData.newsTitle,
                NewsData.sortNewsButton,
                NewsData.filterNewsButton,
                NewsData.controlPanelButton
        );
    }


    public static void waitingNewsPage() {
        Allure.step("Ожидпние загрузки страницы News");
        TestData.waitForElementToLoad(R.id.container_list_news_include, 10000);
    }


    public static void openControlPanel() {
        Allure.step("Открытие Control Panel");
        TestData.clickToElement(
                NewsData.controlPanelButton
        );

    }
}
