Feature: Login Functionality

  @SmokeTest
  Scenario Outline:  Login with valid username and password as positive test
    When User enter valid "<username>" and "<password>"
    Then User should login successfully
    Examples:
      | username | password |
      | username | password |

  @LoginSuccess
  Scenario: Login with invalid username or password as negative test
    When User enter invalid username or invalid password
      | username        | asdasdasd |
      | apple@gmail.com | password  |
      | apple@gmail.com | swe2123   |
    Then User should NOT login and receive error message

    #BDD (Behavior driven development)
    # TDD (Test Driven Development)
