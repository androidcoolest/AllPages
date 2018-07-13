Feature: Login Test Functionality
Scenario: Correct username
Given User navigates to Stackoverflow.com 
When User Provides correct username and passsoword
And Clicks Log In button
Then Login is Successful