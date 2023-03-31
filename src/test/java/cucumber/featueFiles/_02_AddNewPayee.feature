Feature: Add New Payee Functionality

  Background:
#    When User enter valid "<username>" and "<password>"
#    Then User should login successfully
    And User navigate to online banking page
    When Click pay bills module
    Then Click add new payee module

  Scenario Outline: Add New Payee as positive test

    When User enter "<payeeName>" and "<payeeAddress>"and "<account>" and "<payeeDetails>"
    Then Success message should be displayed

    Examples:
      | payeeName | payeeAddress | account         | payeeDetails |
      | user1     | 1234 Blvd    | Bank of America | $Rich        |

#    todo: Complete scenario
  Scenario: Add New Payee as negative test