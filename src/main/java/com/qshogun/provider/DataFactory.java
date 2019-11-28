package com.qshogun.provider;

import com.qshogun.model.User;
import com.qshogun.util.DataGenerator;

public class DataFactory {

    public static User getUser() {
        return new User.Builder()
                .setFirstName(DataGenerator.getFirstname())
                .setLastName(DataGenerator.getLastname())
                .setEmailAddress(DataGenerator.getEmailAddress())
                .setPassword(DataGenerator.getPassword())
                .build();
    }


}
