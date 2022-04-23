@wip6
Feature: As a data consumer, I want UI and DB book categories match.

  Scenario: verify book categories with DB

    Given login as a librarian
    When navigate to "Books" page

    And I take all book categories in UI
    And I execute a query to get book categories
    Then verify book categories from UI match the book_categories table from DB.