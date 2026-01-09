# Kayak Flight Search Automation

A Selenium-based test automation framework for testing Kayak.com flight search functionality using Cucumber BDD and Page Object Model (POM) design pattern.

## Tech Stack

- **Java 21**
- **Selenium WebDriver 4.15.0**
- **Cucumber 7.14.0** - BDD framework
- **JUnit 4.13.2** - Test runner
- **Allure 2.31.0** - Test reporting
- **Maven** - Build tool
- **WebDriverManager 6.3.2** - Browser driver management

## Project Structure

```
Kayak/
├── src/
│   ├── main/java/
│   │   └── pages/
│   │       ├── BasePage.java          # Base class with WebDriver setup
│   │       └── HomePage.java          # Kayak homepage page object
│   └── test/
│       ├── java/
│       │   ├── runners/
│       │   │   └── TestRunner.java    # Cucumber test runner
│       │   └── stepDefinitions/
│       │       └── KayakSteps.java    # Cucumber step definitions
│       └── resources/
│           └── features/
│               └── flightSearch.feature  # BDD test scenarios
├── reports/                           # Test reports (Allure & Cucumber)
├── pom.xml
└── README.md
```

## Features Tested

- Navigate to Kayak homepage
- Enter origin and destination locations
- Select departure and return dates from calendar
- Choose flight options (Cheapest, Best, Quickest)
- Select number of passengers
- Select and book flight deals

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- Chrome browser
- Allure CLI (for report generation)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/NidhiDasadia/Kayak.git
cd Kayak
```

2. Install dependencies:
```bash
mvn clean install -DskipTests
```

## Running Tests

Run all tests:
```bash
mvn test
```

Run with Allure report generation:
```bash
./run-allure-tests.sh
```

## Test Reports

### Allure Reports
After test execution, Allure reports are generated in `reports/allure-reports/` with timestamped folders.

To view Allure report:
```bash
allure serve target/allure-results
```

### Cucumber Reports
- HTML Report: `reports/cucumber-html`
- JSON Report: `reports/cucumber-json/Cucumber.json`

## Sample Test Scenario

```gherkin
Feature: Kayak Flight Search Functionality

  Scenario: Search for flights
    Given I am on Kayak homepage
    When I clear the existing value
    When I enter from location "New York"
    When I enter to location "Dallas"
    And I select 3 days after today in calender
    Then I click on "Cheapest" flight option
    And I click on returnDate
    And I select 7 days after today in ReturnDate
    Then I select "Adults" from the list
    And I select the first deal available
    And I book the flight
```

## Page Object Methods

| Method | Description |
|--------|-------------|
| `enterFromLocation(String)` | Enter departure airport |
| `enterToLocation(String)` | Enter destination airport |
| `selectDateFromCalendarAfterToday(int)` | Select departure date |
| `selectDateFromCalendarAfterTodayReturn(int)` | Select return date |
| `clickOnReturnDate()` | Click return date field |
| `click_on_flight_option(String)` | Select flight sorting option |
| `click_noOfPerson(String)` | Set number of passengers |
| `selectDeal()` | Select first available deal |
| `bookDeal()` | Book the selected flight |

## Author

Nidhi Dasadia
