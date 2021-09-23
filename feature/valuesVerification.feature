Feature: Mass Mutual QA Assessment
Description:Purpose of this feature is to test the verify the assessment scenarios

@Functional
Scenario: User verifies right count values appear on the screen
Given User is on Values Page
Then  Verify the Count of Values

@Functional
Scenario: User verifies values are greater than zero
Given User is on Values Page
When  User fetches all values from webpage
Then  Verify values are greater than zero

@Functional
Scenario: User verifies the total Balance is displayed correct
Given User is on Values Page
When  User fetch the value of total Amount
Then  Verify the total balance is correct

@Functional
Scenario: User verifies the currency format of the values
Given User is on Values Page
When  User fetches all values from webpage 
Then  Verify values are formated as currencies




