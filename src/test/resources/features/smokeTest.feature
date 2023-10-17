@SmokeTest
Feature: Messaging service API

  @PostMessage
  Scenario Outline: Verify user is able to post message - POST Operation
    Given Messaging service API is up and running
    When '<User1>' sends a '<message>' to '<User2>'
    And Verify that message is sent successfully
    Examples:
      | User1                                | User2                                | message    |
      | 4c7f2df9-1db8-4188-abbb-b860398a5019 | 59aa3d67-57ce-4335-9091-14f53d02f726 | Hello Test |

  @GetMessage
  Scenario: Verify user is able to retrieve messages - GET Operation
    Given Messaging service API is up and running
    When User is able to retrieve message
    And Verify that all the messages are retrieved successfully

  @ListMessage
  Scenario: Verify user is able to list messages - LIST Operation
    Given Messaging service API is up and running
    When User is able to view list of messages between User1 and User2
    And Verify that all the messages are listed successfully

  @DeleteMessage
  Scenario: Verify user is able to delete Message - DELETE Operation
    Given Messaging service API is up and running
    When User is able to delete the message
    And Verify that the message is deleted successfully









