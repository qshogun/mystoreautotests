package com.qshogun.listeners;

import com.qshogun.util.JiraPolicy;
import com.qshogun.util.JiraServiceProvider;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestJiraListener implements ITestListener {

    private String jiraUrl = "https://pkurszewski.atlassian.net/";
    private String jiraUsername = "pkurszewski@gmail.com";
    private String jiraPassword = "My6mNhLbGFG25939Gd8qA834";
    private String jiraProject = "MYS";


    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {

        JiraPolicy jiraPolicy = result
                .getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(JiraPolicy.class);
        boolean isTicketReady = jiraPolicy.logTicketReady();
        if(isTicketReady) {
            System.out.println("Is ticket ready for JIRA: " + isTicketReady);
            JiraServiceProvider jiraServiceProvider = new JiraServiceProvider(jiraUrl,jiraUsername, jiraPassword, jiraProject);
            String issueSummary = result
                    .getMethod()
                    .getConstructorOrMethod()
                    .getMethod()
                    .getName()
                    + "has failed due to some assertion or exception";
            String issueDescription = result
                    .getThrowable()
                    .getMessage()
                    +"\n";
            issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
            jiraServiceProvider
                    .createJiraTicket("Bug", issueSummary, issueDescription, "Piotr");
        }

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
