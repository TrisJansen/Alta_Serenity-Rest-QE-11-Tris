Feature: Register feature

  @Tugas @Positive-Case
Scenario: Post Register user with valid JSON
  Given Post Register user with valid json
  When Send request post Register user
  Then Status code should be 200 OK
  And Respons body id was 4 and token was "QpwL5tke4Pnpja7X4"
  And Validate success post register user json schema

  @Tugas @Negative-Case
Scenario: Post Register user without password
  Given post Register user without password
  When Send request post Register user
  Then Status code should be 400 BadRequest
  And Respons body was "Missing password"
  And Validate Unsuccess post register user json schema

  @Tugas @Negative-Case
Scenario: Post Register user without email
  Given post Register user without email
  When Send request post Register user
  Then Status code should be 400 BadRequest
  And Respons body was "Missing email or username"
  And Validate Unsuccess post register without email json schema

  @Tugas @Negative-Case
Scenario: Post Register user without email and password
  Given post Register user without email and password
  When Send request post Register user
  Then Status code should be 400 BadRequest
  And Respons body was "Missing email or username"
  And Validate Unsuccess post register without email and password json schema
