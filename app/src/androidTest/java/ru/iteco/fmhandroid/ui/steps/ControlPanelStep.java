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


import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.ControlPanelData;
import ru.iteco.fmhandroid.ui.data.TestData;

public class ControlPanelStep {
    TestData testData = new TestData();
    ControlPanelData controlPanelData = new ControlPanelData();

    public void controlPanelLoading() {
        Allure.step("Проверка открытия страницы Control Panel");
        testData.checkIsDisplayed(
                controlPanelData.controlPanelTitle,
                controlPanelData.sortNewsButtonCP,
                controlPanelData.filterNewsButtonCP

        );
    }


    public void pageLoading() {
        Allure.step("Проверка открытия страницы редактирования");
        testData.checkIsDisplayed(
                controlPanelData.titleBar,
                controlPanelData.categoryBar,
                controlPanelData.publishDateBar,
                controlPanelData.timeBar,
                controlPanelData.descriptionBar,
                controlPanelData.saveButtonOfCreatingNews
        );
    }




    public void waitingControlPanelPage() {
        Allure.step("Ожидание загрузки страницы Control Panel");
        testData.waitForElementToLoad(R.id.add_news_image_view, 10000);
    }


    public void toCreatingNewsViaButton() {
        Allure.step("Нажатие на кнопку Creating News");
        testData.clickToElement(
                controlPanelData.creatingNewsButton
        );
    }



    public void getCategoryText() {
        Allure.step("Заполнение поля Category");
        controlPanelData.categoryBar.perform(replaceText(testData.getRandomCategory()), closeSoftKeyboard());
    }


    public void getTitleText(String text) {
        Allure.step("Заполнение поля Title");
        controlPanelData.titleBar.perform(replaceText(text), closeSoftKeyboard());
    }

    private void okButton() {
        controlPanelData.deleteNewsOkButton.inRoot(isDialog()).perform(click());
        controlPanelData.timeBar.check(matches(isDisplayed()));
    }

    public void getPublicationDate() {
        Allure.step("Ввод даты публикации");
        controlPanelData.publishDateBar.perform(click());
        okButton();
    }


    public void getPublicationTime() {
        Allure.step("Ввод времени публикации");
        controlPanelData.timeBar.perform(click());
        okButton();
    }


    public void getDescriptionText(String description) {
        Allure.step("Ввод описания новости");
        controlPanelData.descriptionBar.perform(replaceText(description), closeSoftKeyboard());
    }


    public void clickSaveButton() {
        Allure.step("Нажатие на кнопку Save");
        controlPanelData.saveButtonOfCreatingNews.perform(click());
    }


    public void clickEditingNewsButton() {
        Allure.step("Нажатие на кнопку Editing News");
        controlPanelData.newsListCP.perform(
                RecyclerViewActions.actionOnItemAtPosition(0, testData.clickChildView(R.id.edit_news_item_image_view))
        );

    }



    public void checkCreatingTitle(String title) {
        Allure.step("Поиск созданной новости");
        ViewInteraction getCreatingNews = testData.findViewByText(title);
        testData.checkIsDisplayed(getCreatingNews);
    }

    public void checkEditingTitle(String title) {
        Allure.step("Поиск измененной новости");
        onView(isRoot()).perform(testData.waitForView(withText(title), 5000)); // 5 секунд ожидания

        onView(allOf(instanceOf(TextView.class), withText(title)))
                .check(matches(isDisplayed()));
    }

    public Matcher<View> getAgreementButtonMatcher() {

        return withId(android.R.id.button1);
    }


    public void clickDeleteNewsButton(int newsPosition) {
        Allure.step("Нажатие на кнопку Delete News");
        clickOnRecyclerItem(newsPosition, R.id.delete_news_item_image_view);
        confirmAction();
    }

    public void deleteOkButton() {
        Allure.step("Нажатие подтверждения удаления Новости");

        controlPanelData.deleteNewsOkButton.perform(click());
    }

    private void clickOnRecyclerItem(int position, int viewId) {
        controlPanelData.newsListCP
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, testData.clickChildView(viewId)));
    }

    private void confirmAction() {

        onView(getAgreementButtonMatcher()).perform(click());
    }

}
