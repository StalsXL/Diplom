package ru.iteco.fmhandroid.ui.data;


import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ControlPanelData {
    TestData testData = new TestData();
    public ViewInteraction controlPanelTitle = testData.findViewByText("Control panel");
    public ViewInteraction sortNewsButtonCP = testData.findViewById(R.id.sort_news_material_button);
    public ViewInteraction filterNewsButtonCP = testData.findViewById(R.id.filter_news_material_button);
    public ViewInteraction creatingNewsButton = testData.findViewById(R.id.add_news_image_view);
    public ViewInteraction editingNewsButton = testData.findViewById(R.id.edit_news_item_image_view);
    public ViewInteraction deleteNewsButton = testData.findViewById(R.id.delete_news_item_image_view);
    public ViewInteraction createNewsTitle = testData.findViewById(R.id.container_custom_app_bar_include_on_fragment_create_edit_news);
    public ViewInteraction categoryBar = testData.findViewById(R.id.news_item_category_text_auto_complete_text_view);
    public ViewInteraction titleBar = testData.findViewById(R.id.news_item_title_text_input_edit_text);
    public ViewInteraction publishDateBar = testData.findViewById(R.id.news_item_publish_date_text_input_edit_text);
    public ViewInteraction timeBar = testData.findViewById(R.id.news_item_publish_time_text_input_edit_text);
    public ViewInteraction descriptionBar = testData.getInputField(R.id.news_item_description_text_input_layout);
    public ViewInteraction saveButtonOfCreatingNews = testData.findViewById(R.id.save_button);
    public ViewInteraction deleteNewsOkButton = testData.findViewById(android.R.id.button1);
    public ViewInteraction newsListCP = testData.findViewById(R.id.news_list_recycler_view);

}

