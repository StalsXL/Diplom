package ru.iteco.fmhandroid.ui.steps;


import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.NewsData;
import ru.iteco.fmhandroid.ui.data.TestData;

public class NewsStep {

    TestData testData = new TestData();
    NewsData newsData = new NewsData();


    public void NewsPageLoading() {
        Allure.step("Проверка открытия страницы News");
        testData.checkIsDisplayed(
                newsData.newsTitle,
                newsData.sortNewsButton,
                newsData.filterNewsButton,
                newsData.controlPanelButton
        );
    }


    public void waitingNewsPage() {
        Allure.step("Ожидание загрузки страницы News");
        testData.waitForElementToLoad(R.id.container_list_news_include, 5000);
    }


    public void openControlPanel() {
        Allure.step("Открытие Control Panel");
        testData.clickToElement(
                newsData.controlPanelButton
        );

    }
}
