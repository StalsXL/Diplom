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
    MainPageStep mainPageStep = new MainPageStep();
    AuthorizationStep authStep = new AuthorizationStep();
    NewsStep newsStep = new NewsStep();
    ControlPanelStep controlPanelStep = new ControlPanelStep();


    @Before
    public void prepareToUp() {
        try {
            mainPageStep.waitingForLoadMainPage();
        } catch (Exception e) {
            authStep.LogInToApp();
            mainPageStep.waitingForLoadMainPage();
        }
    }

    @Story(value = "Добавление новости")
    @Test
    public void shouldAddNews() {
        VariablesData variablesData = new VariablesData();
        mainPageStep.toAllNewsPage();
        newsStep.NewsPageLoading();
        newsStep.openControlPanel();
        controlPanelStep.controlPanelLoading();
        controlPanelStep.toCreatingNewsViaButton();
        controlPanelStep.pageLoading();
        controlPanelStep.getCategoryText();
        controlPanelStep.getTitleText(variablesData.randomTitle);
        controlPanelStep.getPublicationDate();
        controlPanelStep.getPublicationTime();
        controlPanelStep.getDescriptionText(variablesData.description);
        controlPanelStep.clickSaveButton();
        controlPanelStep.waitingControlPanelPage();
        mainPageStep.toNewsPageViaMenu();
        controlPanelStep.checkCreatingTitle(variablesData.randomTitle);
    }

    @Story(value = "Редактирование новости")
    @Test
    public void shouldChangeNews() {
        VariablesData variablesData = new VariablesData();
        mainPageStep.toAllNewsPage();
        newsStep.NewsPageLoading();
        newsStep.openControlPanel();
        controlPanelStep.controlPanelLoading();
        controlPanelStep.clickEditingNewsButton();
        controlPanelStep.pageLoading();
        controlPanelStep.getTitleText(variablesData.newRandomTitle);
        controlPanelStep.clickSaveButton();
        controlPanelStep.waitingControlPanelPage();
        mainPageStep.toNewsPageViaMenu();
        newsStep.waitingNewsPage();
        controlPanelStep.checkEditingTitle(variablesData.newRandomTitle);
    }

    @Story(value = "Удаление новости")
    @Test
    public void shouldDeleteNews() {
        mainPageStep.toAllNewsPage();
        newsStep.NewsPageLoading();
        newsStep.openControlPanel();
        controlPanelStep.controlPanelLoading();
        controlPanelStep.waitingControlPanelPage();
        controlPanelStep.clickDeleteNewsButton(0);
        controlPanelStep.deleteOkButton();
        controlPanelStep.waitingControlPanelPage();
    }

}
