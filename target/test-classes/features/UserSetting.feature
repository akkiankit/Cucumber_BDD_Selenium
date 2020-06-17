@first
Feature: User Setting
Scenario: User should be able to change the setting
Given I opened the "baseURL"
And I entered login details
And I clicked on "Einstellungen"
And I clicked on "Benutzereinstellungen"
Then I select "QS" from select list
Then I select "Laufwege" as a radio button
And I click On save button
Then I clicked on logout Button
And I entered login details
Then I verified Laufwege is Active in table