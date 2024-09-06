package ru.iteco.fmhandroid.ui.data;

public class VariablesData {
    TestData testData = new TestData();


    public static class User {
        private final String login;
        private final String password;

        public User(String login, String password){

            this.login = login;
            this.password = password;
        }



        public String getLogin() {

            return login;
        }
        public String getPassword() {

            return password;
        }

    }
    public String title = "Новости о погоде";
    public String newTitle = "новые новости";
    public String description = "Описание новости";

    public static final int MAX_RANDOM_NUMBER = 1000;

    public String randomTitle = testData.generateRandomTitle(title);
    public String newRandomTitle = testData.generateRandomTitle(newTitle);
}
