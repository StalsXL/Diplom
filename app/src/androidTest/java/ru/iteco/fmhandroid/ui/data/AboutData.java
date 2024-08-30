package ru.iteco.fmhandroid.ui.data;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
public class AboutData {
    public static ViewInteraction versionApp = TestData.findViewById(R.id.about_version_title_text_view);
    public static ViewInteraction privacyPolicyTitle = TestData.findViewById(R.id.about_privacy_policy_label_text_view);
    public static ViewInteraction privacyPolicyLink = TestData.findViewById(R.id.about_privacy_policy_value_text_view);
    public static ViewInteraction termsOfUseTitle = TestData.findViewById(R.id.about_terms_of_use_label_text_view);
    public static ViewInteraction termsOfUseLink = TestData.findViewById(R.id.about_terms_of_use_value_text_view);
    public static ViewInteraction backButton = TestData.findViewById(R.id.about_back_image_button);
    public static ViewInteraction versionTitle = TestData.findViewById(R.id.about_version_title_text_view);
    public static ViewInteraction versionNumber = TestData.findViewById(R.id.about_version_value_text_view);
    public static ViewInteraction logoAbout = TestData.findViewById(R.id.trademark_image_view);
    public static ViewInteraction privacyPolicyText = TestData.findViewByText("Политика конфиденциальности");
    public static ViewInteraction termsOfUseText = TestData.findViewByText("Пользовательское соглашение");



}

