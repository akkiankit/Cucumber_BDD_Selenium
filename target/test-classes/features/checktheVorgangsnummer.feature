@tc2
Feature: Check Vorgangsummer
Scenario: User should be able to check the vorgangsummer
Given I opened the "baseURL"
And I entered login details
Then I clicked on "logoIcon"
And I selected current Date
Then I clicked on saveFilter button
Then I captured one of Vorgangs-Nr no
Then I clicked on open Filter Button
And I entered captured Vurgang-Nr no
Then I clicked on saveFilter button
And I clicked on Arrow Down
And I clicked on Arrow Right
Then I Verified that Vurgang-Nr details
Then I clicked on logout Button
