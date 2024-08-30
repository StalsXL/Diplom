package ru.iteco.fmhandroid.ui.data;

public class VariablesData {
    private final String login;
    private final String password;

    public VariablesData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {

        return login;
    }
    public String getPassword() {

        return password;
    }

    public static String title = "Новости о погоде";
    public static String newTitle = "новые новости";
    public static String description = "Описание новости";

    public static final int MAX_RANDOM_NUMBER = 1000;

    public static String randomTitle = TestData.generateRandomTitle(title);
    public static String newRandomTitle = TestData.generateRandomTitle(newTitle);
}
