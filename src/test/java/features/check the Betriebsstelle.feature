@tc4
Feature: Check the Betriebsstelle

Scenario: User should be able to check the Betriebsstelle
Given I opened the "baseURL"
And I entered login details
Then I clicked on "logoIcon"
And I entered "AA" in Betriebsstelle
Then I clicked on saveFilter button
And I clicked on laufage Button
And I clicked on Arrow Down for only first row
And I clicked on Arrow Right
Then I verified that "AA" is present at Detailansicht page
And I verified that status of "AA" is "OK"