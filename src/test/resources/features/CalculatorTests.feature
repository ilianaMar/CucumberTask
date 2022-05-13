Feature: Create tests for calculating different type of numbers

  Rule: Integer calculator tests
  Scenario: Add two positive integer numbers
    Given I have a Calculator
    When I add integer numbers 3 and 5
    Then the integer sum should be 8

  Scenario: Add two negative integer numbers
    Given I have a Calculator
    When I add integer numbers -3 and -5
    Then the integer sum should be -8


  Rule: Double calculator tests
    Scenario: Add two positive double numbers
      Given I have a Calculator
      When I add double numbers 1.2 and 3.0
      Then the double sum should be 5.2

    Scenario: Add two negative integer numbers
      Given I have a Calculator
      When I add double numbers -1.2 and -3.0
      Then the double sum should be -4.2


  Rule: Third rule
  Scenario Outline: Calculate different numbers
    Given I have a Calculator
    When I add <num1> and <num2>
    Then the expected result should be <num3>

    Examples:
      | num1 | num2 | num3 |
      | 1    | 2    |3     |
      |1.2   | 2.2  |3.4   |


  Scenario: Implementation of step data table
    Given  I have input numbers
    |3|-1|
    |2|-5|
    When I use operator sum
    Then I print the results
    When I use operator difference
    Then I print the results

