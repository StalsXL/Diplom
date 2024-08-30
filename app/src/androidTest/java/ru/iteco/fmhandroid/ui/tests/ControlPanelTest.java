package ru.iteco.fmhandroid.ui.tests;


import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import org.junit.runner.RunWith;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;

import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.data.VariablesData;
import ru.iteco.fmhandroid.ui.steps.AuthorizationStep;
import ru.iteco.fmhandroid.ui.steps.ControlPanelStep;
import ru.iteco.fmhandroid.ui.steps.MainPageStep;
import ru.iteco.fmhandroid.ui.steps.NewsStep;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Страница Control Panel.")
public class ControlPanelTest extends TestData {

    @Before
    public void prepareToUp() {
        try {
            MainPageStep.waitingForLoadMainPage();
        } catch (Exception e) {
            AuthorizationStep.LogInToApp();
            MainPageStep.waitingForLoadMainPage();
        }
    }

    @Story(value = "Добавление новости")
    @Test
    public void shouldAddNews() {
        MainPageStep.toAllNewsPage();
        NewsStep.NewsPageLoading();
        NewsStep.openControlPanel();
        ControlPanelStep.controlPanelLoading();
        ControlPanelStep.toCreatingNewsViaButton();
        ControlPanelStep.pageLoading();
        ControlPanelStep.getCategoryText();
        ControlPanelStep.getTitleText(VariablesData.randomTitle);
        ControlPanelStep.getPublicationDate();
        ControlPanelStep.getPublicationTime();
        ControlPanelStep.getDescriptionText(VariablesData.description);
        ControlPanelStep.clickSaveButton();
        ControlPanelStep.waitingControlPanelPage();
        MainPageStep.toNewsPageViaMenu();
        ControlPanelStep.checkCreatingTitle(VariablesData.randomTitle);
    }

    @Story(value = "Редактирование новости")
    @Test
    public void shouldChangeNews() {
        MainPageStep.toAllNewsPage();
        NewsStep.NewsPageLoading();
        NewsStep.openControlPanel();
        ControlPanelStep.controlPanelLoading();
        ControlPanelStep.clickEditingNewsButton();
        ControlPanelStep.pageLoading();
        ControlPanelStep.getTitleText(VariablesData.newRandomTitle);
        ControlPanelStep.clickSaveButton();
        ControlPanelStep.waitingControlPanelPage();
        MainPageStep.toNewsPageViaMenu();
        NewsStep.waitingNewsPage();
        ControlPanelStep.CheckEditingTitle(VariablesData.newRandomTitle);
    }

    @Story(value = "Удаление новости")
    @Test
    public void shouldDeleteNews() {
        MainPageStep.toAllNewsPage();
        NewsStep.NewsPageLoading();
        NewsStep.openControlPanel();
        ControlPanelStep.controlPanelLoading();
        ControlPanelStep.waitingControlPanelPage();
        ControlPanelStep.clickDeleteNewsButton(0);
        ControlPanelStep.deleteOkButton();
        ControlPanelStep.waitingControlPanelPage();
    }

}
