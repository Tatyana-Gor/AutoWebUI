Feature: create mail


  Background:
  Given I am autoriz

    Scenario:
      Given I go to create mail interface
      When I click send to
      And I click person name
      And I click add
      And I fill subject
      And I fill text
      And I click send mail
      Then I see success message