
Feature: Navigate in spider-ump


  // Si en el feature hay únicamente un Background sin scenarios, el test se ignora

  Scenario: Go to spider-ump and login
    Given "spider_environment" url
    And I type user "admin" and password "Admin-2013"
    Then I am in the "main" page
    #And click in "<string>" layer

 # Scenario: Moving towards different layers
 #   When click in "<string>" button



