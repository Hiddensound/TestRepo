// The sample test script in this section is compatible with JSON wire protocol-based 
// client bindings. Check out our W3C-based scripts in 
// the selenium-4 branch of the same repository.
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BstackDemo {
    public static final String AUTOMATE_USERNAME = "ajinkyakunjir_OY6TDU";
    public static final String AUTOMATE_ACCESS_KEY = "gzF6ix2pCHzNUGxHGNKB";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "11");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
        final WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        try {
            driver.get("https://bstackdemo.com/");
            final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
            wait.until(ExpectedConditions.titleIs("StackDemo"));
            // getting name of the product
            String product_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'1\']/p"))).getText();
            // waiting for the Add to cart button to be clickable
            WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'1\']/div[4]")));
            // clicking the 'Add to cart' button
            cart_btn.click();
            // checking if the Cart pane is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("float-cart__content")));
            // getting the product's name added in the cart
            final String product_in_cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'__next\']/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]"))).getText();
            // verifying whether the product added to cart is available in the cart
            if (product_name.equals(product_in_cart)) {
                markTestStatus("passed", "Product has been successfully added to the cart!", driver);
            }

            //Test 2

            driver.findElement(By.cssSelector(".float-cart__close-btn")).click();
            Thread.sleep(2000);

            WebElement btn2 = driver.findElement(By.xpath("//span[normalize-space()='Samsung']"));
            btn2.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Galaxy Note 20 Ultra']")));
            WebElement bt3 = driver.findElement(By.cssSelector("div[id='16'] div[class='shelf-item__buy-btn']"));
            bt3.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("float-cart__content")));
            String note_ultra = driver.findElement(By.className("title")).getText();
            String expec_note = "Galaxy Note 20 Ultra";
            if(note_ultra.equals(expec_note))
            {
                markTestStatus("passed","Product has been added to cart successfully", driver);
            }

            driver.findElement(By.cssSelector(".buy-btn")).click();
            Thread.sleep(2000);

          driver.navigate().to("https://saucedemo.com");
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name"))).sendKeys("standard_user");
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password"))).sendKeys("secret_sauce");
          Thread.sleep(2000);

          WebElement sub1 = driver.findElement(By.cssSelector("#login-button"));
          sub1.click();

          String tit1 = driver.getTitle();
          String tit_expec = "Products";

          if(tit1.equals(tit_expec))
          {
              markTestStatus("Passed", "Logged in successfully to Saucelabs", driver);
          }

        } catch (Exception e) {
            markTestStatus("failed", "Some elements failed to load", driver);
        }
        driver.quit();
    }
    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        final JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+ status + "\", \"reason\": \"" + reason + "\"}}");
    }
} 