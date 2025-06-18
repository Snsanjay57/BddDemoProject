#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Facebook Login functionality

  # 1. Scenario Outline with Examples
  Scenario Outline: Login with invalid email and password
    Given I am on the Facebook login page
    When I enter login Id: "<loginId>" and password: "<password>"
    And Hit the Login button
    Then I should see "<error>" message

    Examples: 
      | loginId    | password | error                                                        |
      | 8240855700 | Test@12  | The email address you entered isn't connected to an account. |

  # 2. Scenario - Invalid Email + Invalid Password
  Scenario: Login with invalid email and password
    Given I am on the Facebook login page
    When I enter "invalid@email.com" and "wrongpass"
    And Hit the Login button
    Then I should see a login error

  # 3. Scenario - Valid Email + Invalid Password
  Scenario: Login with valid email and invalid password
    Given I am on the Facebook login page
    When I enter "validemail@gmail.com" and "wrongpass"
    And Hit the Login button
    Then I should see a login error

  # 4. Scenario - Valid Email + Valid Password
  Scenario: Login with valid email and password
    Given I am on the Facebook login page
    When I enter "8240855700" and "Test@12345"
    And Hit the Login button
    Then I should be redirected to the home page

  # 5. Scenario - Validate the Home Dashboard screen with user name.
  Scenario: Validate the Home Dashboard screen with user name.
    Given I am on the Home Dashboard page
    When I enter "8240855700" and "Test@12345"
    And Hit the Login button
    Then I should be redirected to the home page

      # 5. Scenario - Search user name.
  Scenario: Search user name.
    Given I am on the Home Dashboard page
    When Enter the username: <Sanjay Meena> on Search field
    And click the searched data
    Then I should be redirected to the user: <Sanjay Meena> profile screen.