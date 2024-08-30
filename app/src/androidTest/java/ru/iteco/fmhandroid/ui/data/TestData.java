package ru.iteco.fmhandroid.ui.data;

import static android.app.PendingIntent.getActivity;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

import android.view.View;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import androidx.test.ext.junit.rules.ActivityScenarioRule;


import org.hamcrest.Matcher;
import org.junit.Rule;

import java.util.Random;
import java.util.concurrent.TimeoutException;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

public class TestData {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    public static ViewAction waitDisplayed(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {

                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> has been displayed during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long endTime = System.currentTimeMillis() + millis;
                final Matcher<View> viewMatcher = allOf(withId(viewId), isDisplayed());

                while (System.currentTimeMillis() < endTime) {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        if (viewMatcher.matches(child)) {
                            return;
                        }
                    }
                    uiController.loopMainThreadForAtLeast(100);
                }

                throw new PerformException.Builder()
                        .withActionDescription(getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }


    public static ViewAction waitForView(final Matcher<View> viewMatcher, final long timeout) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot(); // Действие должно выполняться на корневом элементе
            }

            @Override
            public String getDescription() {
                return "ожидание до " + timeout + " миллисекунд для появления элемента.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + timeout;

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        // Если элемент найден, вернется null и выполнение завершится
                        if (viewMatcher.matches(child)) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50); // Задержка перед следующей проверкой

                } while (System.currentTimeMillis() < endTime);

                // Если элемент не найден, выбросится ошибка
                throw new PerformException.Builder()
                        .withCause(new TimeoutException())
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .build();
            }
        };
    }


    public static ViewAction clickChildView(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                // Ограничение: корневой элемент должен быть отображен на экране
                return isDisplayed();
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id: " + id;
            }

            @Override
            public void perform(UiController uiController, View view) {
                // Ищем дочерний элемент по переданному идентификатору
                View childView = view.findViewById(id);
                if (childView != null) {
                    // Если элемент найден, выполняем клик
                    childView.performClick();
                } else {
                    // Если элемент не найден, выбрасываем исключение
                    throw new PerformException.Builder()
                            .withActionDescription(getDescription())
                            .withViewDescription(HumanReadables.describe(view))
                            .withCause(new NullPointerException("Child view not found with id: " + id))
                            .build();
                }
            }
        };

    }

    public static ViewInteraction getInputField(int layoutId) {
        return onView(allOf(
                isDescendantOfA(withId(layoutId)),
                isAssignableFrom(EditText.class)
        ));
    }
    public static ViewInteraction findViewById(int id) {

        return onView(withId(id));
    }

    public static ViewInteraction findViewByText(String text) {

        return onView(withText(text));
    }

    public static void clickToElement(ViewInteraction element) {
        element.check(matches(isDisplayed()));
        element.perform(click());
    }

    public static void waitForElementToLoad(int viewId, long timeoutMillis) {
        onView(isRoot()).perform(waitDisplayed(viewId, timeoutMillis));
    }

     public static void checkIsDisplayed(ViewInteraction... elements) {
        for (ViewInteraction element : elements) {
            element.check(matches(isDisplayed()));
        }
    }



    private static final String[] categories = {
            "Объявление",
            "День рождения",
            "Зарплата",
            "Профсоюз",
            "Праздник",
            "Массаж",
            "Благодарность",
            "Нужна помощь"
    };

    public static String getRandomCategory() {
        Random random = new Random();
        int index = random.nextInt(categories.length);
        return categories[index];
    }




    private static int generateRandomNumber() {
        return  new Random().nextInt(VariablesData.MAX_RANDOM_NUMBER) + 1;
    }

    public static String generateRandomTitle(String title) {
        int random = generateRandomNumber();
        return title + random;
    }
}


