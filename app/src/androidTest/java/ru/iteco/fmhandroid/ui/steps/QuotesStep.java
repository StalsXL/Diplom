package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.not;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

import ru.iteco.fmhandroid.ui.data.QuotesData;
import ru.iteco.fmhandroid.ui.data.TestData;

public class QuotesStep {



    public static void quotesLoading() {
        Allure.step("Проверка открытия страницы");
        TestData.checkIsDisplayed(
                QuotesData.quotesTitle,
                QuotesData.quotesList
        );
    }


    public static void quotesWaiting() {
        Allure.step("Ожидание открытия страницы Quotes");
        TestData.waitForElementToLoad(R.id.our_mission_item_list_recycler_view, 5000);
    }

}
