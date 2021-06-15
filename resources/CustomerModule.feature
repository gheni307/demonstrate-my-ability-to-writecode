@CustomerModuleTest
  Feature: Admin user should be able to see Reviews - Customer List

    @ViewListOfCustomer
    Scenario: Admin user should be able to see Reviews - Customer List
      Given Admin user should logged into the Dashboard page
      When click on Customer List link to the Customer List page
      Then verify count of total customers