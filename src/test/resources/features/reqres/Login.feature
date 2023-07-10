Feature: Login feaature

  @Tugas @Positive-Case
  Scenario: Post Login succesfull with valid JSON
    Given Post login user with valid json
    When Send request post Login user
    Then Status code should be 200 OK
    And Respons body token was "QpwL5tke4Pnpja7X4"
    And Validate success post Login user json schema

  @Tugas @Negative-Case
  Scenario: Post login unsuccess without password
    Given Post login user with without password
    When Send request post Login user
    Then Status code should be 400 BadRequest
    And Respons body was "Missing password"
    And Validate post login unsuccess without password

  @Tugas @Negative-Case
  Scenario: Post login unsuccess without email
    Given Post login user with without email
    When Send request post Login user
    Then Status code should be 400 BadRequest
    And Respons body was "Missing email or username"
    And Validate post login unsuccess without email

  @Tugas @Negative-Case
  Scenario: Post login unsuccess without email and password
    Given Post login user with without email and password
    When Send request post Login user
    Then Status code should be 400 BadRequest
    And Respons body was "Missing email or username"
    And Validate post login unsuccess without email and password
