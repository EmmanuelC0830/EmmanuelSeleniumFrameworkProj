#Author: your.email@your.domain.com
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
Feature: Buying products on an Ecommerce platform
  I want to use this template for my feature file

Background:
Given I landed on the Ecommerce page

  @PurchaseTest
  Scenario Outline: Positive test for buying produtcs
  
    Given Logged in with a valid username <name> and password <password>
    When I add product <product> to the cart
    And checkout product <product> and submit the order 
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage
  
    Examples: 
      | name 	              | 	 password    |	 product   |
      | moon.jax6@gmail.com | 	 Emmanuel-12 | ZARA COAT 3 |
      
