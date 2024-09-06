package ru.iteco.fmhandroid.ui.data;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
public class AboutData {
    TestData testData = new TestData();
    public  ViewInteraction versionApp = testData.findViewById(R.id.about_version_title_text_view);
    public  ViewInteraction privacyPolicyTitle = testData.findViewById(R.id.about_privacy_policy_label_text_view);
    public ViewInteraction privacyPolicyLink = testData.findViewById(R.id.about_privacy_policy_value_text_view);
    public ViewInteraction termsOfUseTitle = testData.findViewById(R.id.about_terms_of_use_label_text_view);
    public ViewInteraction termsOfUseLink = testData.findViewById(R.id.about_terms_of_use_value_text_view);
    public ViewInteraction backButton = testData.findViewById(R.id.about_back_image_button);
    public ViewInteraction versionTitle = testData.findViewById(R.id.about_version_title_text_view);
    public ViewInteraction versionNumber = testData.findViewById(R.id.about_version_value_text_view);
    public ViewInteraction logoAbout = testData.findViewById(R.id.trademark_image_view);
    public ViewInteraction privacyPolicyText = testData.findViewByText("Политика конфиденциальности");
    public ViewInteraction termsOfUseText = testData.findViewByText("Пользовательское соглашение");



}

