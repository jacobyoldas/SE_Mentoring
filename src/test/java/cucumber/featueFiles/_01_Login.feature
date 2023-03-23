Feature: Login Functionality

  Scenario Outline:  Login with valid username and password as positive test

    When User enter valid "<username>" and "<password>"
    Then User should login successfully

    Examples:
      | username | password |
      | username | password |
