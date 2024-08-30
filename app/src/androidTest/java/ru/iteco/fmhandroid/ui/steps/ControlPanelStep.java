package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static ru.iteco.fmhandroid.ui.data.TestData.clickChildView;

import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.ControlPanelData;
import ru.iteco.fmhandroid.ui.data.TestData;

public class ControlPanelStep {

    public static void controlPanelLoading() {
        Allure.step("Проверка открытия страницы Control Panel");
        TestData.checkIsDisplayed(
                ControlPanelData.controlPanelTitle,
                ControlPanelData.sortNewsButtonCP,
                ControlPanelData.filterNewsButtonCP

        );
    }


    public static void pageLoading() {
        Allure.step("Проверка открытия страницы редактирования");
        TestData.checkIsDisplayed(
                ControlPanelData.titleBar,
                ControlPanelData.categoryBar,
                ControlPanelData.publishDateBar,
                ControlPanelData.timeBar,
                ControlPanelData.descriptionBar,
                ControlPanelData.saveButtonOfCreatingNews
        );
    }




    public static void waitingControlPanelPage() {
        Allure.step("Ожидание загрузки страницы Control Panel");
        TestData.waitForElementToLoad(R.id.add_news_image_view, 10000);
    }


    public static void toCreatingNewsViaButton() {
        Allure.step("Нажатие на кнопку Creating News");
        TestData.clickToElement(
                ControlPanelData.creatingNewsButton
        );
    }



    public static void getCategoryText() {
        Allure.step("Заполнение поля Category");
        ControlPanelData.categoryBar.perform(replaceText(TestData.getRandomCategory()), closeSoftKeyboard());
    }


    public static void getTitleText(String text) {
        Allure.step("Заполнение поля Title");
        ControlPanelData.titleBar.perform(replaceText(text), closeSoftKeyboard());
    }

    private static void okButton() {
        ControlPanelData.deleteNewsOkButton.inRoot(isDialog()).perform(click());
        ControlPanelData.timeBar.check(matches(isDisplayed()));
    }

    public static void getPublicationDate() {
        Allure.step("Ввод даты публикации");
        ControlPanelData.publishDateBar.perform(click());
        okButton();
    }


    public static void getPublicationTime() {
        Allure.step("Ввод времени публикации");
        ControlPanelData.timeBar.perform(click());
        okButton();
    }


    public static void getDescriptionText(String description) {
        Allure.step("Ввод описания новости");
        ControlPanelData.descriptionBar.perform(replaceText(description), closeSoftKeyboard());
    }


    public static void clickSaveButton() {
        Allure.step("Нажатие на кнопку Save");
        ControlPanelData.saveButtonOfCreatingNews.perform(click());
    }


    public static void clickEditingNewsButton() {
        Allure.step("Нажатие на кнопку Editing News");
        ControlPanelData.newsListCP.perform(
                RecyclerViewActions.actionOnItemAtPosition(0, clickChildView(R.id.edit_news_item_image_view))
        );

    }



    public static void checkCreatingTitle(String title) {
        Allure.step("Поиск созданной новости");
        ViewInteraction getCreatingNews = TestData.findViewByText(title);
        TestData.checkIsDisplayed(getCreatingNews);
    }

    public static void CheckEditingTitle(String title) {
        Allure.step("Поиск измененной новости");
        onView(isRoot()).perform(TestData.waitForView(withText(title), 5000)); // 5 секунд ожидания

        onView(allOf(instanceOf(TextView.class), withText(title)))
                .check(matches(isDisplayed()));
    }

    public static Matcher<View> getAgreementButtonMatcher() {

        return withId(android.R.id.button1);
    }


    public static void clickDeleteNewsButton(int newsPosition) {
        Allure.step("Нажатие на кнопку Delete News");
        clickOnRecyclerItem(newsPosition, R.id.delete_news_item_image_view);
        confirmAction();
    }

    public static void deleteOkButton() {
        Allure.step("Нажатие подтверждения удаления Новости");

        ControlPanelData.deleteNewsOkButton.perform(click());
    }

    private static void clickOnRecyclerItem(int position, int viewId) {
        ControlPanelData.newsListCP
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, TestData.clickChildView(viewId)));
    }

    private static void confirmAction() {

        onView(getAgreementButtonMatcher()).perform(click());
    }

}
