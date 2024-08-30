package ru.iteco.fmhandroid.ui.data;


import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsData {
    public static ViewInteraction newsTitle = TestData.findViewByText("News");
    public static ViewInteraction sortNewsButton = TestData.findViewById(R.id.sort_news_material_button);
    public static ViewInteraction filterNewsButton = TestData.findViewById(R.id.filter_news_material_button);
    public static ViewInteraction controlPanelButton = TestData.findViewById(R.id.edit_news_material_button);
    public static ViewInteraction viewNewsView = TestData.findViewById(R.id.view_news_item_image_view);
    public static ViewInteraction newsItemTitle = TestData.findViewById(R.id.news_item_author_text_view);
    public static ViewInteraction newsItemDescription = TestData.findViewById(R.id.news_item_description_text_view);
    public static ViewInteraction newsItemDate = TestData.findViewById(R.id.news_item_date_text_view);



}
