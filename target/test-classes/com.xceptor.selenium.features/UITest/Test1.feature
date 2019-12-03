Feature: Create a classic account

  As a customer
  I should be able to create an account through lloydsbank website

  @CreateCurrentAccount
  Scenario Outline: Create a current account using lloydsbank website
    Given Customer launches the Lloyds Bank Website
    When Customer click "<ProductType>"
    When Customer choose "<AccountType>"
    When Customer enter No in the existing customer page
    When Customer click continue in the before you start page
    And  Customer will fill in all the details
    Then Customer will be able to create a new account
    Examples:
      | ProductType | AccountType|
      | Current Account   | Classic Account|



