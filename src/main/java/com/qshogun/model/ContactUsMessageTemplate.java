package com.qshogun.model;

public class ContactUsMessageTemplate {

    private String subject;
    private String emailAddress;
    private String messageToBeSent;

    public static class Builder {
        ContactUsMessageTemplate messageTemplate= new ContactUsMessageTemplate();

        public Builder setSubject(String subject) {
            messageTemplate.subject = subject;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            messageTemplate.emailAddress = emailAddress;
            return this;
        }

        public Builder setMessageToBeSent(String messageToBeSent) {
            messageTemplate.messageToBeSent = messageToBeSent;
            return this;
        }

        public ContactUsMessageTemplate build() {
            return messageTemplate;
        }
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getMessageToBeSent() {
        return messageToBeSent;
    }
}
