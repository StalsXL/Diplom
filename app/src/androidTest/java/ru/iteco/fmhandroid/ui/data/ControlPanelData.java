package ru.iteco.fmhandroid.ui.data;


import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ControlPanelData {
    public static ViewInteraction controlPanelTitle = TestData.findViewByText("Control panel");
    public static ViewInteraction sortNewsButtonCP = TestData.findViewById(R.id.sort_news_material_button);
    public static ViewInteraction filterNewsButtonCP = TestData.findViewById(R.id.filter_news_material_button);
    public static ViewInteraction creatingNewsButton = TestData.findViewById(R.id.add_news_image_view);
    public static ViewInteraction editingNewsButton = TestData.findViewById(R.id.edit_news_item_image_view);
    public static ViewInteraction deleteNewsButton = TestData.findViewById(R.id.delete_news_item_image_view);
    public static ViewInteraction createNewsTitle = TestData.findViewById(R.id.container_custom_app_bar_include_on_fragment_create_edit_news);
    public static ViewInteraction categoryBar = TestData.findViewById(R.id.news_item_category_text_auto_complete_text_view);
    public static ViewInteraction titleBar = TestData.findViewById(R.id.news_item_title_text_input_edit_text);
    public static ViewInteraction publishDateBar = TestData.findViewById(R.id.news_item_publish_date_text_input_edit_text);
    public static ViewInteraction timeBar = TestData.findViewById(R.id.news_item_publish_time_text_input_edit_text);
    public static ViewInteraction descriptionBar = TestData.getInputField(R.id.news_item_description_text_input_layout);
    public static ViewInteraction saveButtonOfCreatingNews = TestData.findViewById(R.id.save_button);
    public static ViewInteraction deleteNewsOkButton = TestData.findViewById(android.R.id.button1);
    public static ViewInteraction newsListCP = TestData.findViewById(R.id.news_list_recycler_view);

}

