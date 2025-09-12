Feature: Invalid Feedback Submission
Scenario: Submit feedback without filling any fields
Given the user is on shortlisted property details page
When I click the side bar
And I click report issue
Then I submit the feedback form without filling anything
And a validation error message is displayed