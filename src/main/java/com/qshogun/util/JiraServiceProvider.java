package com.qshogun.util;

import net.rcarz.jiraclient.*;

public class JiraServiceProvider {

    public JiraClient jiraClient;
    public String project;

    public JiraServiceProvider(String jiraUrl, String username, String password, String project) {
        BasicCredentials credentials = new BasicCredentials(username, password);
        jiraClient = new JiraClient(jiraUrl, credentials);
        this.project = project;
    }

    public void createJiraTicket(String issueType, String summary, String description, String reporterName) {
        try {
            Issue.FluentCreate fluentCreate = jiraClient.createIssue(project, issueType);
            fluentCreate.field(Field.SUMMARY, summary);
            fluentCreate.field(Field.DESCRIPTION, description);
            Issue newIssue = fluentCreate.execute();
            System.out.println("News issue created in jira with ID: " + newIssue);
        } catch (JiraException e) {
            e.printStackTrace();
        }
    }
}
