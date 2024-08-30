package ru.iteco.fmhandroid.ui.data;


//import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainData {

    public static ViewInteraction mainPageNewsList = TestData.findViewById(R.id.container_list_news_include_on_fragment_main);
    public static ViewInteraction mainPageQuotesButton = TestData.findViewById(R.id.our_mission_image_button);
    public static ViewInteraction mainPageAllNewsButton = TestData.findViewById(R.id.all_news_text_view);
    public static ViewInteraction mainPageLogo = TestData.findViewById(R.id.trademark_image_view);
    public static ViewInteraction navigationButton = TestData.findViewById(R.id.main_menu_image_button);
    public static ViewInteraction mainPageButton = TestData.findViewByText("Main");
    public static ViewInteraction newsPageButton = TestData.findViewByText("News");
    public static ViewInteraction aboutPageButton = TestData.findViewByText("About");


}
