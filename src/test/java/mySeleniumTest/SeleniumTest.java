package mySeleniumTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SeleniumTest {
    //todo: import this project into a git new project - Project on github - https://github.com/gr33nishblue/Selenium
    //todo: create tests for all the pages in ultimateQA
    //TODO: provide Mihai Access to the project created in git
    //TODO: work with with branches per page so I could actually CR
    //TODO: add the selenium gecko driver to the project
    //TODO: end date - 14.11.2020
    private FirefoxDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setup() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void browser() {
        driver.get("https://www.google.com/");
        WebElement hplogo = driver.findElement(By.id("hplogo"));
        assertThat(hplogo.isDisplayed()).isTrue();
        //driver.close();
    }

    @Test
    void myFirstTest() throws InterruptedException {
   //     FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://ultimateqa.com/automation");
        List<WebElement> buttonsOnTHePage = driver.findElements(new By.ByCssSelector("div.et_pb_text_inner a"));
        assertThat(buttonsOnTHePage.size()).isEqualTo(7);
        WebElement theFirstButton = buttonsOnTHePage.get(0);
        theFirstButton.click();
        wait.until(visibilityOfElementLocated(By.id("Skills_Improved")));
        WebElement skillsLabel = driver.findElement(By.id("Skills_Improved"));
        assertThat(skillsLabel.isDisplayed()).isTrue();
        assertThat(skillsLabel.getText()).isEqualTo("Skills Improved:");
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}
