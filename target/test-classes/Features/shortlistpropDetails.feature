Feature: Details of shortlist property\

Scenario: Verifying details of property from shortlist result
	Given the user is on the shortlisted property page 
	And I click on the property from shorlisted list
	Then I click on photos for viewing and I click back arrow to navigate back
	Then I validate the contact agent in the property page
