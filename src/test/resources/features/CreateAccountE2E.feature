@CreateAccount
Feature: Create Account End to End Testing

  Scenario: Create Account create credentials and login
    When click on "Create Primary Account" button
    Then validate section title to be "Create Primary Account Holder"
    When fill up create account form
    |firstName | Maryam |
    |lastName  | Safi   |
    |prefix    | Mrs.   |
    | email    | random |
    | gender   | Female               |
    | maritalStatus | Married         |
    | employmentStatus | Unemployed   |
    |dob               | 01/29/1998   |
    When click on "Create Account" icon
    Then validate title to be "Sign up your account"
    Then validate created fullName and email
    When send text "random" to "Username" field
    When send text "Tek@2024" to "Password" field
    When send text "Tek@2024" to "Confirm Password" field
    And click on "Submit" button
    Given wait 5 seconds
    Then validate title to be "Sign in to your account"
    When send text "random" to "Username" field
    When send text "Tek@2024" to "Password" field
    When click on "Sign in" icon

