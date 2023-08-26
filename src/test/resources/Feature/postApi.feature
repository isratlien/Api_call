Feature:
  @Smoke

  Scenario Outline: check user reqistration successfully or not
    Given  user has the api '<path>'
    When user  hit '<name>' and '<job>'
    And call the api with body
    Then it will return created data

    Examples:
    |path |name |job |
    |user |Lien |QA  |