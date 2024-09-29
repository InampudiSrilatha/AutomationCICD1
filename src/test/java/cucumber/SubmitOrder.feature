 @tag
  Feature:Purchase the order from ecommerce website
    

Background:
Given i landed on a Ecommerce page

  @Regression
  Scenario Outline: Positive test for submiting the order
  
    Given Login with username <name> and password <password>
    When Add product <ProductName>to the cart
    And checkout <ProductName>is displayed and submit the order
    Then "Thankyou for the order." message is displayed on comformation page

    Examples: 
      | name             | password | ProductName  |
      | sri234@gmail.com |Fjot&023  | ZARA COAT 3  |
