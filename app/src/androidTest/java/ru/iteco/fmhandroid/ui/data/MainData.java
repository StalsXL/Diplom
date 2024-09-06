package ru.iteco.fmhandroid.ui.data;


//import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainData {
    TestData testData = new TestData();

    public ViewInteraction mainPageNewsList = testData.findViewById(R.id.container_list_news_include_on_fragment_main);
    public ViewInteraction mainPageQuotesButton = testData.findViewById(R.id.our_mission_image_button);
    public ViewInteraction mainPageAllNewsButton = testData.findViewById(R.id.all_news_text_view);
    public ViewInteraction mainPageLogo = testData.findViewById(R.id.trademark_image_view);
    public ViewInteraction navigationButton = testData.findViewById(R.id.main_menu_image_button);
    public ViewInteraction mainPageButton = testData.findViewByText("Main");
    public ViewInteraction newsPageButton = testData.findViewByText("News");
    public ViewInteraction aboutPageButton = testData.findViewByText("About");


}
