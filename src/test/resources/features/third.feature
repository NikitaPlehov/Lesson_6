Feature: Более сложный тест

  Background:
    Given открыт браузер
    * страница логина открыта

  Scenario: Использование AND в Given
    Given user logged in

  Scenario: Простой тест со всеми ключевыми словами
    Then username field is displayed