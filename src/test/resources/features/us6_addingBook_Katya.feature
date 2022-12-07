@wip
Feature: As librarian, I should be able to add book to library

  Scenario Outline:
    Given User logs in as librarian
    And Librarian navigates to "Books" page
    When Librarian clicks to add book
    And Librarian enters book name "<Book Name>"
    When Librarian enters ISBN "<ISBN>"
    And Librarian enters year "<Year>"
    When Librarian enters author "<Author>"
    And Librarian chooses the book category "<Book Category>"
    And Librarian clicks to save changes
    Then Librarian verify new book by "<Book Name>"
    Then Librarian verify new book from database by "<Book Name>"

    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Clean Code            | 09112022 | 2021 | Robert C.Martin | Drama                |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |