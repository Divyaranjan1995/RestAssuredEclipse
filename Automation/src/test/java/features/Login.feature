Feature: Application Login

Scenario: Homepage Default Login
Given User is on NetBanking langing page
When User login into application with username "Divyaranjan1995" and password "Divya@123"
Then Home page is displayed
And Cards dsiplayed are "true"

Scenario: Homepage Default Login
Given User is on NetBanking langing page
When User login into application with username "Padhiary123" and password "Padhiary"
Then Home page is displayed
And Cards dsiplayed are "false"