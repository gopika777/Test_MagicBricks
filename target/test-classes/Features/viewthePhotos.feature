Feature: View Property Photos
Scenario: View and close the photo gallery
Given the user is on the shortlisted property details
When I click the photo gallery 
And photo gallery opens
And I click the first photo
Then I click the right arrow to view the photos
Then I close the gallery
