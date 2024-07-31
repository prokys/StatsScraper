package statsScraper.rest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.*;
import statsScraper.leagueStats.LeagueStats;
import statsScraper.leagueStats.PlayerAllTimeStats;
import statsScraper.leagueStats.PlayerSuperLeagueStats;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/player")
public class LeagueStatsController {
    private String playerName;
    private List<LeagueStats> listOfAllStats = new ArrayList<>();

    @GetMapping("/all")
    public PlayerAllTimeStats countPlayerAllTimeStats(){
        return new PlayerAllTimeStats(playerName, listOfAllStats);
    }

    @GetMapping("/superleague")
    public PlayerSuperLeagueStats PlayerSuperLeagueStats(){
        return new PlayerSuperLeagueStats(playerName, listOfAllStats);
    }

    @GetMapping("/scrape/{playerID}")
    public void getPlayer(@PathVariable("playerID") String playerID){
        listOfAllStats.clear();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.ceskyflorbal.cz/person/detail/player/"+playerID);

        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//img[@class='ProfilePerson--Table-icon plus']"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//img[@class='ProfilePerson--Table-icon plus']"))).perform();

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='ProfilePerson--Table-icon plus']"))).click();
        List<WebElement> tbodyElements = driver.findElements(By.cssSelector("tbody.js-collButton-target"));



        for (WebElement tbodyElement : tbodyElements) {
            List<WebElement> trElements = tbodyElement.findElements(By.tagName("tr"));
            for (WebElement trElement : trElements) {
                List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
                List<String> scrapedValues = new ArrayList<>();
                for (WebElement tdElement : tdElements) {
                    scrapedValues.add((tdElement.getText()));
                }
                listOfAllStats.add(new LeagueStats(
                        scrapedValues.get(0),
                        scrapedValues.get(1),
                        scrapedValues.get(2),
                        Integer.parseInt(scrapedValues.get(3)),
                        Integer.parseInt(scrapedValues.get(4)),
                        Integer.parseInt(scrapedValues.get(5)),
                        Integer.parseInt(scrapedValues.get(6)),
                        Integer.parseInt(scrapedValues.get(7))));
            }
        }
        playerName = driver.findElement(By.xpath("//h1[@class=\"ProfilePerson-header--heading\"]")).getText();
        driver.quit();

    }
}
