package com.qshogun.util;

import com.github.javafaker.Faker;

public class DataGenerator {

    private static Faker faker = new Faker();

    public static String getFirstname() {
        return faker.name().firstName();
    }
    public static String getLastname() {
        return faker.name().lastName();
    }
    public static String getEmailAddress() {
        return faker.internet().emailAddress();
    }
    public static String getPassword() {
        return faker.internet().password();

    }
    public static String getMessageToBeSent() {
        return faker.country().capital();
    }

}
