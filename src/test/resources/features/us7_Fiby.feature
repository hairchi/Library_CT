@wip
Feature: Books module
  As a student, I should be able to borrow a book
   @db
  Scenario: Students borrow new books
    Given I login as a student
    And I navigate to "Books" page
    And I search book name called "Head First Java"
    When I click Borrow "Head First Java"
    Then verify that "Head First Java" is shown in "Borrowing Books” page
    And verify logged student has "Head First Java" in database


