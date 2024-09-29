
@tag
Feature: ErrorValidation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given i landed on a Ecommerce page
    When Login with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

   Examples: 
      | name             | password | 
      | sri234@gmail.com |Fjot&02  |
