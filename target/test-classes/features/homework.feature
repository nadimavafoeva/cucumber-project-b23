Feature:  Doing homework

  As a student
  I want to be able to finish my homework
  So that i can learn good stuff

  Scenario: Homework web order product table
    Given we are at web order login page
    And we provide valid credentials
    When we select "View all products" tab from sidebar
    Then we should see table with below content
    # for the sake of simplicity below table is modified to match exactly to actual table
      | Product name | Price | Discount |
      | MyMoney      | $100  | 8%       |
      | FamilyAlbum  | $80   | 15%      |
      | ScreenSaver  | $20   | 10%      |


    @ui
  Scenario: User should see correct product price generated
    Given we are at web order login page
    And we provide valid credentials
    When we select "Order" tab from sidebar
    Then we should see three section as below
      |Product Information|
      |Address Information|
      |Payment Information|
    And select each product from dropdown should change the unit price accordingly
      | ScreenSaver | 20   |
      | MyMoney     | 100  |
      | FamilyAlbum | 80   |
      # you need to loop to select each item and assert unit price box