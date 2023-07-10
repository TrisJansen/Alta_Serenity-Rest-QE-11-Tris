Feature: Update feature

  @Tugas @Negative-Case
  Scenario Outline: Put update user with Job was Numerik
    Given Put update user with valid id <id> and job was numerik
    When Send request put update user
    Then Status code should be 400 BadRequest
    And Respons body name was "Jansen Sihombing" and job was 534353543543
    Examples:
    | id |
    | 1  |
    | 2  |

  @Tugas @Positive-Case
  Scenario Outline: Put update user without job body
    Given Put update user with valid id <id> without job body
    When Send request put update user
    Then Status code should be 200 OK
    And Respons body name was "Jansen Sihombing" and job was ""
    And Validate success put update user json schema without job body
    Examples:
    | id |
    | 1  |
    | 2  |

  @Tugas @Positive-Case
  Scenario Outline: Put update user without user name on name body
    Given Put update user with valid id <id> without user name on name body
    When Send request put update user
    Then Status code should be 200 OK
    And Respons body name was "" and job was "Wiraswasta"
    And Validate success put update user json schema without name body
    Examples:
    | id |
    | 1  |
    | 2  |

  @Tugas @Positive-Case
  Scenario Outline: Put update user without user name on name body
    Given Put update user with valid id <id> without user name on name body
    When Send request put update user
    Then Status code should be 200 OK
    And Respons body name was "" and job was "Wiraswasta"
    And Validate success put update user json schema without name body
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas @Negative-Case
  Scenario: Put update user without user name and job
    Given Put update user with valid id 1 without user name and job body
    When Send request put update user
    Then Status code should be 400 BadRequest