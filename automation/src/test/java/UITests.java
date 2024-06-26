import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UITests {
    private WebDriver driver;
    private String ogUrl = "file:///D:\\Downloads\\Assignment 5 - GUI Testing\\version1";
// change file paths accordingly - baseUrl is the version to be tested

      private String baseUrl = "file:///D:\\Downloads\\Assignment 5 - GUI Testing\\version1";

    // Comment above statement and uncomment the following statement to check for version 2
        //private String baseUrl = "file:///D:\\Downloads\\Assignment 5 - GUI Testing\\version2";

    @BeforeClass
    public void setUp() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\Assignment 5 - GUI Testing\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
    }



    @Test
    public void testPage1NameLocation() {
        String og1Url = ogUrl + "\\page1.html";
        driver.get(og1Url);
        WebElement ogName = driver.findElement(By.xpath("//div[@class='form active']/div[1]/input"));

        Point ogNameLocation = ogName.getLocation();

        String page1Url = baseUrl + "\\page1.html";
        driver.get(page1Url);
        WebElement nameInput = driver.findElement(By.xpath("//div[@class='form active']/div[1]/input"));

        Point nameInputLocation = nameInput.getLocation();
        Assert.assertEquals(nameInputLocation, ogNameLocation);
    }

    @Test
    public void testPage1NameSize() {
        String og1Url = ogUrl + "\\page1.html";
        driver.get(og1Url);
        WebElement ogName = driver.findElement(By.xpath("//div[@class='form active']/div[1]/input"));
        Dimension ogNameSize = ogName.getSize();


        String page1Url = baseUrl + "\\page1.html";
        driver.get(page1Url);
        WebElement nameInput = driver.findElement(By.xpath("//div[@class='form active']/div[1]/input"));
        Dimension nameInputSize = nameInput.getSize();

        Assert.assertEquals(nameInputSize, ogNameSize);
    }

    @Test
    public void testPage1EmailLocation() {
        String og1Url = ogUrl + "\\page1.html";
        driver.get(og1Url);
        WebElement ogEmail = driver.findElement(By.xpath("//div[@class='form active']/div[2]/input"));

        Point ogEmailLocation = ogEmail.getLocation();

        String page1Url = baseUrl + "\\page1.html";
        driver.get(page1Url);
        WebElement emailInput = driver.findElement(By.xpath("//div[@class='form active']/div[2]/input"));

        Point emailInputLocation = emailInput.getLocation();
        Assert.assertEquals(emailInputLocation, ogEmailLocation);
    }

    @Test
    public void testPage1EmailSize() {
        String og1Url = ogUrl + "\\page1.html";
        driver.get(og1Url);
        WebElement ogEmail = driver.findElement(By.xpath("//div[@class='form active']/div[2]/input"));
        Dimension ogEmailSize = ogEmail.getSize();


        String page1Url = baseUrl + "\\page1.html";
        driver.get(page1Url);
        WebElement emailInput = driver.findElement(By.xpath("//div[@class='form active']/div[2]/input"));
        Dimension emailInputSize = emailInput.getSize();

        Assert.assertEquals(emailInputSize, ogEmailSize);
    }
    @Test
    public void testPage1() {
        String page1Url = baseUrl + "\\page1.html";
        driver.get(page1Url);

        // Verify the image on page1
        WebElement imageElement = driver.findElement(By.xpath("//img[@alt='Restaurant image']"));
        Assert.assertTrue(imageElement.isDisplayed());

        // Find form elements and set input values
        WebElement nameInput = driver.findElement(By.xpath("//div[@class='form active']/div[1]/input"));
        nameInput.sendKeys("John Doe");
        Assert.assertEquals(nameInput.getAttribute("value"), "John Doe");

        WebElement emailInput = driver.findElement(By.xpath("//div[@class='form active']/div[2]/input"));
        emailInput.sendKeys("johndoe@example.com");
        Assert.assertEquals(emailInput.getAttribute("value"), "johndoe@example.com");

        WebElement ageRadio1 = driver.findElement(By.id("age1"));
        ageRadio1.click();
        Assert.assertTrue(ageRadio1.isSelected());

        WebElement ageRadio2 = driver.findElement(By.id("age2"));
        ageRadio2.click();
        Assert.assertTrue(ageRadio2.isSelected());

        WebElement ageRadio3 = driver.findElement(By.id("age3"));
        ageRadio3.click();
        Assert.assertTrue(ageRadio3.isSelected());

        WebElement tncCheckbox = driver.findElement(By.id("checktnc"));
        tncCheckbox.click();
        Assert.assertTrue(tncCheckbox.isSelected());
    }



    @Test
    public void testPage1TnCLocation() {
        String og1Url = ogUrl + "\\page1.html";
        driver.get(og1Url);
        WebElement ogTnC = driver.findElement(By.id("checktnc"));

        Point ogTnCLocation = ogTnC.getLocation();

        String page1Url = baseUrl + "\\page1.html";
        driver.get(page1Url);
        WebElement tncCheckbox = driver.findElement(By.id("checktnc"));

        Point tncCheckboxLocation = tncCheckbox.getLocation();
        Assert.assertEquals(tncCheckboxLocation, ogTnCLocation);
    }

    @Test
    public void testPage1TnCSize() {
        String og1Url = ogUrl + "\\page1.html";
        driver.get(og1Url);
        WebElement ogTnC = driver.findElement(By.id("checktnc"));
        Dimension ogTnCSize = ogTnC.getSize();


        String page1Url = baseUrl + "\\page1.html";
        driver.get(page1Url);
        WebElement tncCheckbox = driver.findElement(By.id("checktnc"));
        Dimension tncCheckboxSize = tncCheckbox.getSize();

        Assert.assertEquals(tncCheckboxSize, ogTnCSize);
    }
    @Test
    public void testPage1Flow() {
        String page1Url = baseUrl + "\\page1.html";
        driver.get(page1Url);
        // Click on the "Next" button
        WebElement nextButton = driver.findElement(By.xpath("//button[text()='Next']"));
        nextButton.click();

        // Verify that we are now on the next page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("page2.html"));
    }


    @Test
    public void testPage2() {
        String page2Url = baseUrl + "\\page2.html";
        driver.get(page2Url);
        // Select the gender radio button
        WebElement maleRadioBtn = driver.findElement(By.id("male"));
        maleRadioBtn.click();

        // Verify that the male radio button is selected
        Assert.assertTrue(maleRadioBtn.isSelected());

        // Select the female radio button
        WebElement femaleRadioBtn = driver.findElement(By.id("female"));
        femaleRadioBtn.click();

        // Verify that the female radio button is selected
        Assert.assertTrue(femaleRadioBtn.isSelected());

        // Select the pizza radio button
        WebElement pizzaRadioBtn = driver.findElement(By.xpath("//input[@value='pizza']"));
        pizzaRadioBtn.click();

        // Verify that the pizza radio button is selected
        Assert.assertTrue(pizzaRadioBtn.isSelected());

        // Select the taco radio button
        WebElement tacoRadioBtn = driver.findElement(By.xpath("//input[@value='taco']"));
        tacoRadioBtn.click();

        // Verify that the taco radio button is selected
        Assert.assertTrue(tacoRadioBtn.isSelected());

        // Select the burger radio button
        WebElement burgerRadioBtn = driver.findElement(By.xpath("//input[@value='burger']"));
        burgerRadioBtn.click();

        // Verify that the burger radio button is selected
        Assert.assertTrue(burgerRadioBtn.isSelected());

        // Set the spice indicator slider value to 50
        WebElement slider = driver.findElement(By.id("slider"));
        slider.sendKeys("50");

        // Verify that the slider value is 50
        Assert.assertEquals(slider.getAttribute("value"), "50");

        WebElement aboutTextArea = driver.findElement(By.id("about"));
        aboutTextArea.sendKeys("I want extra cheese on my pizza");

        // Verify that the text appears in the text area
        Assert.assertEquals(aboutTextArea.getAttribute("value"), "I want extra cheese on my pizza");

        // Click on the "Next" button
        WebElement nextButton = driver.findElement(By.xpath("//button[text()='Next']"));
        nextButton.click();

        // Verify that we are now on the next page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("page3.html"));

        // To test the functionality of previous button
        driver.get(baseUrl + "\\page2.html");

        // Click on the "Previous" button
        WebElement prevButton = driver.findElement(By.xpath("//button[text()='Previous']"));
        prevButton.click();

        // Verify that we are now on the next page
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("page1.html"));
    }

    @Test
    public void testPage2FoodLocation() {
        String og2Url = ogUrl + "\\page2.html";
        driver.get(og2Url);
        WebElement ogPizza = driver.findElement(By.xpath("//input[@value='pizza']"));
        WebElement ogTaco = driver.findElement(By.xpath("//input[@value='taco']"));
        WebElement ogBurger = driver.findElement(By.xpath("//input[@value='burger']"));
        Point ogPizzaLocation = ogPizza.getLocation();
        Point ogTacoLocation = ogTaco.getLocation();
        Point ogBurgerLocation = ogBurger.getLocation();

        String page2Url = baseUrl + "\\page2.html";
        driver.get(page2Url);
        WebElement pizzaRadioBtn = driver.findElement(By.xpath("//input[@value='pizza']"));
        WebElement tacoRadioBtn = driver.findElement(By.xpath("//input[@value='taco']"));
        WebElement burgerRadioBtn = driver.findElement(By.xpath("//input[@value='burger']"));
        Point pizzaRadioBtnLocation = pizzaRadioBtn.getLocation();
        Point tacoRadioBtnLocation = tacoRadioBtn.getLocation();
        Point burgerRadioBtnLocation = burgerRadioBtn.getLocation();

        Assert.assertEquals(pizzaRadioBtnLocation, ogPizzaLocation);
        Assert.assertEquals(tacoRadioBtnLocation, ogTacoLocation);
        Assert.assertEquals(burgerRadioBtnLocation, ogBurgerLocation);
    }





    @Test
    public void testPage2AboutSize() {
        String og2Url = ogUrl + "\\page2.html";
        driver.get(og2Url);
        WebElement ogAbout = driver.findElement(By.id("about"));
        Dimension ogAboutSize = ogAbout.getSize();


        String page2Url = baseUrl + "\\page2.html";
        driver.get(page2Url);
        WebElement aboutTextArea = driver.findElement(By.id("about"));
        Dimension aboutTextAreaSize = aboutTextArea.getSize();

        Assert.assertEquals(aboutTextAreaSize, ogAboutSize);
    }

    @Test
    public void testPage2ButtonLocation() {
        String og2Url = ogUrl + "\\page2.html";
        driver.get(og2Url);
        WebElement ogNextButton = driver.findElement(By.xpath("//button[text()='Next']"));
        WebElement ogPrevButton = driver.findElement(By.xpath("//button[text()='Previous']"));

        Point ogNextLocation = ogNextButton.getLocation();
        Point ogPrevLocation = ogPrevButton.getLocation();

        String page2Url = baseUrl + "\\page2.html";
        driver.get(page2Url);
        WebElement nextButton = driver.findElement(By.xpath("//button[text()='Next']"));
        WebElement prevButton = driver.findElement(By.xpath("//button[text()='Previous']"));

        Point nextLocation = nextButton.getLocation();
        Point prevLocation = prevButton.getLocation();

        Assert.assertEquals(nextLocation, ogNextLocation);
        Assert.assertEquals(prevLocation, ogPrevLocation);

    }

    @Test
    public void testPage3() {
        String page3Url = baseUrl + "\\page3.html";
        driver.get(page3Url);
        // Verify the image on page3
        WebElement imageElement = driver.findElement(By.xpath("//img[@alt='Restaurant image']"));
        Assert.assertTrue(imageElement.isDisplayed());

        // Fill in the address form
        WebElement addressInput = driver.findElement(By.id("address"));
        addressInput.sendKeys("123 Main St");
        WebElement cityInput = driver.findElement(By.id("city"));
        cityInput.sendKeys("Anytown");
        WebElement stateInput = driver.findElement(By.id("state"));
        stateInput.sendKeys("CA");
        WebElement zipInput = driver.findElement(By.id("zip"));
        zipInput.sendKeys("12345");

        // Select delivery speed
        WebElement deliverySpeedSelect = driver.findElement(By.id("delivery-speed"));
        deliverySpeedSelect.click();
        WebElement fastOption = driver.findElement(By.cssSelector("option[value='fast']"));
        fastOption.click();

        // Add order comments
        WebElement textarea = driver.findElement(By.id("textarea"));
        textarea.sendKeys("Please deliver to back door");

        // Check subscribe checkbox
        WebElement subscribeCheckbox = driver.findElement(By.id("subscribe"));
        subscribeCheckbox.click();

        // Click confirm order button
        WebElement confirmOrderButton = driver.findElement(By.xpath("//button[text()='Confirm Your Order']"));
        confirmOrderButton.click();

        // Verify that the user is taken to a confirmation page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("confirmation.html"));


        // To test the functionality of previous button
        driver.get(page3Url);

        // Click on the "Previous" button
        WebElement prevButton = driver.findElement(By.xpath("//button[text()='Previous']"));
        prevButton.click();

        // Verify that we are now on the next page
        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("page2.html"));
    }



    @Test
    public void testPage3AddressLocation() {
        String og3Url = ogUrl + "\\page3.html";
        driver.get(og3Url);
        WebElement ogAddress = driver.findElement(By.id("address"));

        Point ogAddressLocation = ogAddress.getLocation();

        String page3Url = baseUrl + "\\page3.html";
        driver.get(page3Url);
        WebElement addressInput = driver.findElement(By.id("address"));

        Point addressInputLocation = addressInput.getLocation();
        Assert.assertEquals(addressInputLocation, ogAddressLocation);
    }

    @Test
    public void testPage3ConfirmButtonSize() {
        String og3Url = ogUrl + "\\page3.html";
        driver.get(og3Url);
        WebElement ogConfirmOrderButton = driver.findElement(By.xpath("//button[text()='Confirm Your Order']"));

        Dimension ogConfirmOrderButtonSize = ogConfirmOrderButton.getSize();



        String page3Url = baseUrl + "\\page3.html";
        driver.get(page3Url);
        WebElement confirmOrderButton = driver.findElement(By.xpath("//button[text()='Confirm Your Order']"));

        Dimension confirmOrderButtonSize = confirmOrderButton.getSize();


        Assert.assertEquals(confirmOrderButtonSize, ogConfirmOrderButtonSize);

    }

    @Test
    public void testPage3PreviousButtonOrientation() {
        String og3Url = ogUrl + "\\page3.html";
        driver.get(og3Url);

        WebElement ogPrevButton = driver.findElement(By.xpath("//button[text()='Previous']"));

        Point ogPrevButtonOrientation = ogPrevButton.getLocation();


        String page3Url = baseUrl + "\\page3.html";
        driver.get(page3Url);

        WebElement prevButton = driver.findElement(By.xpath("//button[text()='Previous']"));

        Point prevButtonOrientation = prevButton.getLocation();


        Assert.assertEquals(prevButtonOrientation, ogPrevButtonOrientation);
    }

    @AfterClass
    public void tearDown() {
        // Close WebDriver instance
        driver.quit();
    }
}
