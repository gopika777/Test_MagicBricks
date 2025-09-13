Feature: View Property Photos
Background:
Given the user is on the shortlisted property details

#TS_MB_11 
Scenario: View and close the photo gallery

When I click the photo gallery 
And photo gallery opens
And I click the first photo
Then I click the right arrow to view the photos
Then I close the gallery
