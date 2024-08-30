package ru.iteco.fmhandroid.ui.data;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesData {
    public static ViewInteraction quotesTitle = TestData.findViewById(R.id.our_mission_title_text_view);
    public static ViewInteraction quotesList = TestData.findViewById(R.id.our_mission_item_list_recycler_view);

}
