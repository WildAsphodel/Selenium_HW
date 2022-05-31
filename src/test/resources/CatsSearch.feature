Feature: Search for cats

  Background:
    Given Open Main page

  @hooks
    @close
  Scenario:
    When Open Image page
    And Search by text from Image page
    And Search image by tag
    Then New images should be visible

  Scenario:
    When Search by text from Main page
    Then Title should be correct