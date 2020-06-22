@tc3
Feature: Check the Zug_Nr
Scenario: User should be able to check ZUG_Nr
Given I opened the "baseURL"
And I entered login details
Then I clicked on "logoIcon"
And I selected current Date
Then I clicked on saveFilter button
And I clicked on laufage Button
Then I captured one of Zug-Nr no
Then I clicked on open Filter Button
And I entered captured zug-Nr no
Then I clicked on saveFilter button
And I clicked on Arrow Down
And I clicked on Arrow Right
Then I verified Zug-Nr details
Then I clicked on logout Button
