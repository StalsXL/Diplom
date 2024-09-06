package ru.iteco.fmhandroid.ui.data;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesData {
    TestData testData = new TestData();
    public ViewInteraction quotesTitle = testData.findViewById(R.id.our_mission_title_text_view);
    public ViewInteraction quotesList = testData.findViewById(R.id.our_mission_item_list_recycler_view);

}
