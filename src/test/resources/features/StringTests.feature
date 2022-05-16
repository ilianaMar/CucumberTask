Feature: Compare single words
  Background:
    Given I use case sensitive compare

  Scenario Outline: String test for comparison
    Given I use simple string "Examplesssz"
    When I remove character s
    And I remove character z
    Then I check <second_string> is equal to my string

    Examples:
    |second_string|
    |Example      |
    |Example123   |
    |example      |

  Scenario: Sentence tests
    Given I use simple sentence "_First sentence is set to ..._"
    When I remove sign _
    And I remove another single sign .
    When I use another simple sentence "_Second sentence is set to ..._"
    And I remove sign _
    And I remove another single sign .
    Then I compare both sentences

  Scenario: Word count test
    Given I have the paragraph
    """
    Lorem Ipsum sentence Lorem Ipsum sentence Lorem Ipsum sentence
    Lorem Ipsum sentence Lorem Ipsum sentence Lorem Ipsum sentence
    """
    Then I print the Words count
    And I have the paragraph
    """
    blabla
    """
    Then I print the Word count
