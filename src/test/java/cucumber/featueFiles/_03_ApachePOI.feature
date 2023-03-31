Feature: ApachePOI New Payee Functionality

  Background:
#    When User enter valid "<username>" and "<password>"
#    Then User should login successfully
    And User navigate to online banking page
    When Click pay bills module
    Then Click add new payee module

  Scenario: Create new payee from Excel
    Given User create add New Payee as positive test

    # DDD (Data Driven Development) -- ApachePOI
    # TDD (Test Driven Development)