package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;
import pages.HomePage;
import java.time.Duration;

public class KayakSteps {
    private WebDriver driver;
    private HomePage homePage;
    
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }
    
   @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    
    @Given("I am on Kayak homepage")
    public void i_am_on_kayak_homepage() throws InterruptedException {
    	//driver.get("https://egov.uscis.gov/");
        driver.get("https://www.kayak.com");
        Thread.sleep(3000);
    }
    
    @When("I clear the existing value")
    public void click_on_cross() {
        homePage.clickCrossButton();
    }
    
    @When("I enter from location {string}")
    public void i_enter_from_location(String from) throws InterruptedException {
        homePage.enterFromLocation(from);
    }
    
    @When("I enter to location {string}")
    public void i_enter_to_location(String to) {
        homePage.enterToLocation(to);
    }
    @And("I select {int} days after today in calender")
    public void i_select_days_after_today_in_calender(Integer days) {
        homePage.selectDateFromCalendarAfterToday(days);
    }
    
    @And("I select {int} days after today in ReturnDate")
    public void select_days_after_today_returnDate(Integer days) {
    	homePage.selectDateFromCalendarAfterTodayReturn(days);
    }
    
    @And("I click on returnDate")
    public void click_returnDate()
    {
    	homePage.clickOnReturnDate();
    }
    @And("I select {int} days after today in calender returnDate")
    public void i_select_days_after_today_in_calender_returnDate(Integer days) {
        homePage.selectDateFromCalendarAfterToday_returnDate(days);
    }
    
    @When("I click search button")
    public void i_click_search_button(){
        homePage.clickSearch();
    }
    
    @Then("I should see flight search results")
    public void i_should_see_flight_search_results() {
       homePage.validate_user_on_searchedData();
    }
    
	@Then("I click on {string} flight option")
	public void clickOnOption(String text) throws InterruptedException {
		homePage.click_on_flight_option(text);
		
	}
	
	@And("I scroll down the page")
	public void scrollPage(int x,int y) {
		homePage.scrollByCoordinates(x,y);
		
	}
	@And("I click on Main menu")
	public void clickMainmenu() throws InterruptedException {
		homePage.click_on_mainMenu();
		
	}
	@Then("I select {string} from the list")
	public void incrementPerson(String text) {
		homePage.click_noOfPerson(text);
		
	}
	
	@And("I select the first deal available")
	public void i_select_deal() throws InterruptedException {
		homePage.selectDeal();
	}
	
	@And("I book the flight")
	public void i_book_flight() throws InterruptedException {
		homePage.bookDeal();
	}

}

