package statsScraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;


public class App
{
    public static void main( String[] args ){
        try (Workbook workbook = new XSSFWorkbook()){

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            WebDriver driver = new ChromeDriver(options);
            driver.get("https://www.ceskyflorbal.cz/person/detail/player/0603030371");

            Actions actions = new Actions(driver);
            actions.scrollToElement(driver.findElement(By.xpath("//img[@class='ProfilePerson--Table-icon plus']"))).perform();
            actions.moveToElement(driver.findElement(By.xpath("//img[@class='ProfilePerson--Table-icon plus']"))).perform();

            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='ProfilePerson--Table-icon plus']"))).click();
            List<WebElement> tbodyElements = driver.findElements(By.cssSelector("tbody.js-collButton-target"));

            Sheet sheet = workbook.createSheet("Proky");

            int rowNum = 0;
            for (WebElement tbodyElement : tbodyElements) {
                List<WebElement> trElements = tbodyElement.findElements(By.tagName("tr"));
                for (WebElement trElement : trElements) {
                    List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
                    Row row = sheet.createRow(rowNum++);
                    int colNum = 0;
                    for (WebElement tdElement : tdElements) {
                        if (colNum<3){
                            Cell cell = row.createCell(colNum++);
                            cell.setCellValue((tdElement.getText()));
                        }else {
                            Cell cell = row.createCell(colNum++);
                            cell.setCellValue((Integer.parseInt(tdElement.getText())));
                        }
                    }
                }
            }
            try(FileOutputStream fileOut = new FileOutputStream("Proky.xlsx")){
                workbook.write(fileOut);
            }
            driver.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}