Feature: Login into web applicative

  Background:
    Given I enter into "http://automationpractice.com/index.php"
    And I click in "Sign in" button

  Scenario: Account not created
    When I set "tnunez@example.com" as user
    And I set "password" as password
    Then I got "Invalid Password" error because user does not exist

  Scenario: Correct login into web
    And Account "t.nunez@example.com" is already created
    When I set "t.nunez@example.com" as user
    And I set "password" as password
    Then I am "logged" into the web








