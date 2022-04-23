@wip2
Feature:As a librarian, I want to know the amount of borrowed books

  Background:

    Given Establish the database connection

  Scenario: verify the amount of borrowed books

    When I am in the homepage of the library app
    When I take borrowed books number
    Then borrowed books number information must match with DB

