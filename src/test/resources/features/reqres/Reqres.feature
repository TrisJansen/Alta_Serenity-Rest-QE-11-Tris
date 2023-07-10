Feature: API Automation Testing ALTA QE Batch 11
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Respons body page value should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |
    Scenario: Post create new user with valid JSON
      Given Post create user with valid json
      When Send request post create user
      Then Status code should be 201 created
      And Respons body name was "Jansen Sihombing" and job was "QA Engineer"
    @Latihan
    Scenario Outline: Put update user with valid parameter id and JSON
      Given Put update user with valid id <id> and json
      When Send request put update user
      Then Status code should be 200 OK
      And Respons body name was "Jansen Sihombing Edit" and job was "QA Engineer Edit"
    Examples:
      | id |
      | 1  |
      | 2  |
    @Latihan
      Scenario Outline: Delete user with valid parameter id
      Given Delete user with valid id <id>
      When Send request delete user
      Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
