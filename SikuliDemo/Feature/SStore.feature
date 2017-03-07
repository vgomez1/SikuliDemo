#Author: vgomez1@steelcase.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@tag
Feature: Steelcase Store -	This is a demo test

@Scenario1
Scenario: Blue Cobi chair appears 
  Given steelcase store home page
  When type cobi on the search field and press Enter
  Then the catalog page should appear showing a blue cobi chair in the first option


@Scenario2
Scenario: Cobi page is available
  Given a user in the catalog page after searching for cobi chair
  When click on cobi link or cobi image (if available)
  Then the user is redirected to the cobi chair page 

@Scenario3
Scenario: Image of red cobi chair is available
   Given a user in the cobi chair page
   When clicking on the thumbnail of red cobi
   Then a bigger image of a red cobi appears 
  
@Scenario4
Scenario: Image of blue cobi chair is available
   Given a user in the cobi chair page
   When clicking on the thumbnail of blue cobi
   Then a bigger image of blue cobi appears respectively
  