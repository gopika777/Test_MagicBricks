Feature: Invalid Feedback Submission
Background:
Given the user is on shortlisted property details page
#TS_MB_12 
Scenario: Submit feedback without filling any fields

When I click the side bar
And I click report issue
Then I submit the feedback form without filling anything
And a validation error message is displayed