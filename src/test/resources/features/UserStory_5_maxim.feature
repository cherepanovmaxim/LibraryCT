
@wip5
Feature: As a data consumer, I want UI and DB book information are match.

  Background:
    Given Establish the database connection

  Scenario Outline: Verify book information with DB
    Given I login as a librarian
    When I navigate to "Books" page
    When I open book "<book>"
    Then book information must match the Database for "<book>"

    Examples:
      | book              |
      | Chordeiles minor  |
      | Lama glama        |
      | 1984              |
      | Caiman crocodilus |


