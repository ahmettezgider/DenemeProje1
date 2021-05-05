Feature:

  Scenario: asd

    Given user on homepage
    And   user login
    When  user navigate to "Candidates"
    And   user select job title as "IT Manager"
    And   user click to search button
    Then  the results should be appear