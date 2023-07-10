Feature: List Users

  @Tugas @Positive-Case
  Scenario Outline: Get single user with valid parameter page
    Given Get single user with valid parameter page <id>
    When Send request get single users
    Then Status single user code should be 200 OK
    And Response body id value should be <id>
    And Response body email should be email "<email>"
    And Validate success Get single user json schema
  Examples:
    | id | email                  |
    | 2  | janet.weaver@reqres.in |

  @Tugas @Negative-Case
  Scenario Outline: Get single user not found with unvalid parameter page
    Given Get single user not found with unvalid parameter page <id>
    When send request get single user not found
    Then Status code should be 404 not found
    And Validate success Get single user not found json schema
    Examples:
      | id |
      | 23 |

  @Tugas @Positive-Case
  Scenario Outline: Get list Resource
    Given Get list resource without parameter page <id>
    When Send request get list resource
    Then Status code should be 200 OK
    And Response body id value should be <id>
    And Response body name should be name "<name>"
  Examples:
    | id | name         |
    | 1  | cerulean     |
    | 2  | fuchsia rose |

  @Tugas @Positive-Case
  Scenario Outline: Get single Resource
    Given Get single resource with parameter page <id>
    When Send request get list resource
    Then Status code should be 200 OK
    And Response body id value should be <id>
    And Response body name should be name "<name>"
    And Validate success Get single resource json schema
    Examples:
      | id | name         |
      | 2  | fuchsia rose |

  @Tugas @Negative-Case
  Scenario Outline: Get single resource not found
    Given Get single resource with parameter page <id>
    When Send request get list resource
    Then Status code should be 404 not found
    And Validate success Get single resource not found json schema
    Examples:
      | id |
      | 23 |



