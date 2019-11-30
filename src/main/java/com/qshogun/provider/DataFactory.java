package com.qshogun.provider;

import com.qshogun.model.ContactUsMessageTemplate;
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

    public static ContactUsMessageTemplate getContactUsMessageTemplateCustomerService() {
        return new ContactUsMessageTemplate.Builder()
                .setSubject("Customer service")
                .setEmailAddress(DataGenerator.getEmailAddress())
                .setMessageToBeSent(DataGenerator.getMessageToBeSent())
                .build();
    }
    public static ContactUsMessageTemplate getContactUsMessageTemplateWebmaster() {
        return new ContactUsMessageTemplate.Builder()
                .setSubject("Webmaster")
                .setEmailAddress(DataGenerator.getEmailAddress())
                .setMessageToBeSent(DataGenerator.getMessageToBeSent())
                .build();
    }
}
