Feature: Kayak Flight Search Functionality

  Scenario: Search for flights
    Given I am on Kayak homepage
    When I clear the existing value
    When I enter from location "New York"
    When I enter to location "Dallas"
    And I select 3 days after today in calender
    
   
    #And I select 7 days after today in calender returnDate
  # When I click search button
  
   # And I scroll down the page
    Then I click on "Cheapest" flight option
     And I click on returnDate
     
    And I select 7 days after today in ReturnDate
    Then I select "Adults" from the list
    And I select the first deal available
    And I book the flight
   # Then I close the payment window
    
   # And I click on Main menu
 #   Then I should see flight search results
 
    