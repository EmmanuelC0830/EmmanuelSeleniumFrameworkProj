
@tag
Feature: Verifying incorrect Email prompt

Background:
Given I landed on the Ecommerce page

  @ErrorTest
  Scenario Outline: Positive test for negative results on login
  
    Given Logged in with a valid username <name> and password <password>
    Then "Incorrect email or password." message is displayed on the login page
  
    Examples: 
      | name 	              | 	 password    |	
      | moon.jax@gmail.com  | 	 Emmanuel12  | 
      
