package ru.iteco.fmhandroid.ui.data;


import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsData {
    TestData testData = new TestData();
    public ViewInteraction newsTitle = testData.findViewByText("News");
    public ViewInteraction sortNewsButton = testData.findViewById(R.id.sort_news_material_button);
    public ViewInteraction filterNewsButton = testData.findViewById(R.id.filter_news_material_button);
    public ViewInteraction controlPanelButton = testData.findViewById(R.id.edit_news_material_button);
    public ViewInteraction viewNewsView = testData.findViewById(R.id.view_news_item_image_view);
    public ViewInteraction newsItemTitle = testData.findViewById(R.id.news_item_author_text_view);
    public ViewInteraction newsItemDescription = testData.findViewById(R.id.news_item_description_text_view);
    public ViewInteraction newsItemDate = testData.findViewById(R.id.news_item_date_text_view);



}
