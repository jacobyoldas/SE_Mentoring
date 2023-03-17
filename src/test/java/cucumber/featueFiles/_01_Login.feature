Feature: Login Functionality

  Scenario Outline:  Login with valid username and password as positive test

    Given User navigate to website
    When User enter valid "<username>" and "<password>"
    Then User should login successfully
    Then User close the website

    Examples:
      | username | password |
      | username | password |
