Feature: Hello World
  Rule: This is my first rule
  Scenario: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told "Nope"

  Scenario: Add two positive numbers
    Given I have a Calculator
    When I add 3 and 5
    Then the sum should be 8