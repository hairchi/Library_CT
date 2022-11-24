Feature: As a user, I should be able to log in.

  @wip
  Scenario Outline: Verify login with valid credentials
    Given user on the login page
    When user enters username "<email>" and passcode "<password>" and clicks the login button
    Examples:
      | email               | password |
      | student59@library   | cJaTyCRJ |
      | student60@library   | AoSFw44Y |
      | librarian59@library | DmSqxDEJ |
      | librarian60@library | Lj5VU4Tq |

