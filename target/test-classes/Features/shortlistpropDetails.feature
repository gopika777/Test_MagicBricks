Feature: Details of shortlist property\
Background:
Given the user is on the shortlisted property page 
#TS_MB_09 
Scenario: Verifying details of property from shortlist result
 
	And I click on the property from shorlisted list
	Then I scrolls down to view property details
	Then I validate the presence of the offer element
