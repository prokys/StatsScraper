package statsScraper;

import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class App
{
    public static void main( String[] args ){
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            WebDriver driver = new ChromeDriver(options);
            driver.get("https://www.ceskyflorbal.cz/person/detail/player/0603030371");
            driver.findElement(By.id("c-p-bn")).click();
            Actions actions = new Actions(driver);
            actions.scrollToElement(driver.findElement(By.xpath("//img[@class='ProfilePerson--Table-icon plus']"))).perform();
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='ProfilePerson--Table-icon plus']"))).click();
            List<WebElement> tbodyElements = driver.findElements(By.cssSelector("tbody.js-collButton-target"));

            for (WebElement tbodyElement : tbodyElements) {
                List<WebElement> trElements = tbodyElement.findElements(By.tagName("tr"));
                for (WebElement trElement : trElements) {
                    List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
                    for (WebElement tdElement : tdElements) {
                        System.out.println(tdElement.getText());
                    }
                }
            }
            Thread.sleep(3000);
            driver.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
