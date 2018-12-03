@shopping
Feature: Go shopping within the website!!

  Background: Login into the website
    Given I'm logged into the "website"

  Scenario: I'm searching for the cheapest dress
    And Enter "dress" into search box
    And I'm clicking "search" button
    Then I sort the output list by "Price: Lowest first" dress

  Scenario: I want to buy "Printed Summer Dress" if it's still in stock
    And Enter "Printed Summer Dress" into search box
    And I'm clicking "search" button
    And add them up to the "cart"
    When I go to the cart "conclusion"
    Then I submit "buy process" every dresses

  Scenario: Contact customer service
    And click in "Contact us" button
    When I fulfill every needed "gap" for send a message
    Then "send" the message


