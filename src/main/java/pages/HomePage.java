package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class HomePage extends BasePage {
    
   
	@FindBy(xpath ="//input[@aria-label='Origin location']")
    private WebElement fromField;
    
    @FindBy(xpath = "//input[@aria-label='Destination location']")
    private WebElement toField;
    
    @FindBy(xpath = "//span[contains(text(),'Departure')]")
    private WebElement departureDate;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
    
    @FindBy(xpath="//span[contains(text(),'AMD')]//following::div[@class='vPgG-checkbox']")
    private WebElement selectFromValue;
    
    @FindBy(xpath="(//div[@aria-label='Remove value'])[1]")
   // @FindBy(xpath=" (//div[@role='button']/parent::div[@class='c_neb-item-close'])[1]")
    private WebElement crossValue;
    
    @FindBy(xpath="//span[contains(text(),'NYC')]")
    private WebElement selectAirport;
    
    @FindBy(xpath="//div[@aria-label='Select end date from calendar input']")
    private WebElement returnDate;
    
    @FindBy(xpath="//div[@role='button' and @aria-label='Open main navigation']")
    private WebElement mainMenu;
    
    @FindBy(xpath="(//span[contains(text(),'Search')])[2]")
    private WebElement search;
    
    @FindBy(xpath="(//span[contains(text(),'Select')])[1]")
    private WebElement selectDeal;
    
    @FindBy(xpath="(//div[contains(text(),'Book')]//parent::div[@class='Iqt3-button-content'])[1]")
    private WebElement bookDeal;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void clickCrossButton() {
    	 //crossValue.click();
       try {
            crossValue.click();
        } catch (Exception e) {
            System.out.println("Cross button not found or not clickable");
        }
    }
    
    public void enterFromLocation(String from) throws InterruptedException {
        fromField.sendKeys(from);
        WebElement selectfromDropdown= driver.findElement(By.xpath("//li[@aria-label='John F Kennedy Intl']//div/div[@class='vPgG-checkbox']"));
        selectfromDropdown.click();
      //  selectFromValue.click();
       // fromField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
    }
    
    public void enterToLocation(String to) {
       toField.click();
    	toField.sendKeys(to);
    	
    	 WebElement selectfromDropdown= driver.findElement(By.xpath("//li[@aria-label='Love Field']//div/div[@class='vPgG-checkbox']"));
         selectfromDropdown.click();
    }
    public void selectDateFromCalendarAfterToday(int days) {
    	departureDate.click();
		SimpleDateFormat date = new SimpleDateFormat("MMMM d, yyyy");
		Date dt = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.add(Calendar.DATE, days);
		String newDate = date.format(calendar.getTime());
		String xPath = String.format("//div[@role='button' and contains(@aria-label, '%s')]", newDate);
		
		
		//div[@role='button' and @aria-label='aria-label="November 5, 2025']
		WebElement selectDate = driver.findElement(By.xpath(xPath));
		selectDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
    public void selectDateFromCalendarAfterToday_returnDate(int days) {
    	SimpleDateFormat date = new SimpleDateFormat("MMMM d, yyyy");
		Date dt = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.add(Calendar.DATE, days);
		String returnDate = date.format(calendar.getTime());
		String xPath = String.format("//div[@role='button' and @aria-label='%s Prices on this day are above average']", returnDate);
		
		
		//div[@role='button' and @aria-label=''%s'. Selected as end date. Prices on this day are above average']
		WebElement selectDate = driver.findElement(By.xpath(xPath));
		selectDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
   public void clickOnReturnDate() {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	   WebElement returnDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Return')]//parent::div)[2]")));
	   returnDateElement.click();

	   //returnDate.click();
   }
    
    public void clickSearch()  {
        searchButton.click();
        switchToLatestWindow();
    }
  
    public void validate_user_on_searchedData() {
    	
        String expectedText = "Book now"; 
        
       
        String actualText = driver.findElement(By.xpath("//div[contains(text(),'Book now')]")).getText();
        
        
        Assert.assertEquals("Search results validation failed", expectedText, actualText);
    	
    	
    	
    }
    
    public void click_on_flight_option(String text) throws InterruptedException {
    	
    	
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
    	submit.click();
    	switchToLatestWindow();
    	Thread.sleep(5000);
    	//searchButton.click();
    	
    	String xPath = String.format("//div[@role='button' and @aria-label='%s']/div", text);
    	
    	WebElement flightOption = driver.findElement(By.xpath(xPath));
		flightOption.click();

    }
    
    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    
    public void scrollByCoordinates(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
    }

	public void click_on_mainMenu() throws InterruptedException {
		Thread.sleep(2000);
		mainMenu.click();
		Thread.sleep(2000);
	}
	public void selectDateFromCalendarAfterTodayReturn(int days) {
    	
		SimpleDateFormat date = new SimpleDateFormat("MMMM d, yyyy");
		Date dt = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.add(Calendar.DATE, days);
		String newDate = date.format(calendar.getTime());
		String xPath = String.format("//div[@role='button' and contains(@aria-label, '%s')]", newDate);
		
		
		//div[@role='button' and @aria-label='aria-label="November 5, 2025']
		WebElement selectDate = driver.findElement(By.xpath(xPath));
		selectDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
    
    public void switchToLatestWindow() {
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

	public void click_noOfPerson(String text) {
		driver.findElement(By.xpath("//span[contains(text(),'1 adult, Economy')]")).click();
		
	String xPath= String.format("(//input[@aria-label='%s']//following::button[@aria-label='Increment'])[1]", text);
	WebElement incrementPeople= driver.findElement(By.xpath(xPath));
	incrementPeople.click();
	search.click();
	
		
	}

	public void selectDeal() throws InterruptedException {
		selectDeal.click();
		Thread.sleep(2000);
		
	}
    
   public void bookDeal() throws InterruptedException {
	   bookDeal.click();
	   Thread.sleep(2000);
	   driver.close();
	   Thread.sleep(1000);
   }
  
}
