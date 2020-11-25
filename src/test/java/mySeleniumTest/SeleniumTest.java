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
    void the1stButtonTest() throws InterruptedException {
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

    @Test
    void the2ndButtonTest () throws InterruptedException {
        driver.get("https://ultimateqa.com/automation");
        List<WebElement> buttonsOnTHePage = driver.findElements(new By.ByCssSelector("div.et_pb_text_inner a"));
        assertThat(buttonsOnTHePage.size()).isEqualTo(7);
        WebElement theSecondButton = buttonsOnTHePage.get(1);
        theSecondButton.click();
        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"et-boc\"]/div/div/div[1]/div/div[1]/div[1]/div")));
        WebElement landingPage = driver.findElement(By.xpath("//*[@id=\"et-boc\"]/div/div/div[1]/div/div[1]/div[1]/div/h1"));
        assertThat(landingPage.isDisplayed()).isTrue();
        assertThat(landingPage.getText()).isEqualTo("Learn to Code Websites, Apps & Games");
    }

    @Test
    void the3rdButtonTest () throws InterruptedException {
        driver.get("https://ultimateqa.com/automation");
        List<WebElement> buttonsOnTHePage = driver.findElements(new By.ByCssSelector("div.et_pb_text_inner a"));
        assertThat(buttonsOnTHePage.size()).isEqualTo(7);
        WebElement theThirdButton = buttonsOnTHePage.get(2);
        theThirdButton.click();
        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"et-boc\"]/div/div/div[1]/div[1]/div/div/div")));
        WebElement landingPage = driver.findElement(By.xpath("//*[@id=\"et-boc\"]/div/div/div[1]/div[1]/div/div/div/h1"));
        assertThat(landingPage.isDisplayed()).isTrue();
        assertThat(landingPage.getText()).isEqualTo("Pick a Plan that Works for Your Business Model");
    }

    @Test
    void the4thButtonTest () throws InterruptedException {
        driver.get("https://ultimateqa.com/automation");
        List<WebElement> buttonsOnTHePage = driver.findElements(new By.ByCssSelector("div.et_pb_text_inner a"));
        assertThat(buttonsOnTHePage.size()).isEqualTo(7);
        WebElement theFourthButton = buttonsOnTHePage.get(3);
        theFourthButton.click();
        wait.until(visibilityOfElementLocated(By.className("entry-content")));
        WebElement landingPage = driver.findElement(By.id("et_pb_contact_name_0"));
        assertThat(landingPage.isDisplayed()).isTrue();
        assertThat(landingPage.getTagName()).isEqualTo("input");
    }

    @Test
    void the5thButtonTest () throws InterruptedException {
        driver.get("https://ultimateqa.com/automation");
        List<WebElement> buttonsOnTHePage = driver.findElements(new By.ByCssSelector("div.et_pb_text_inner a"));
        assertThat(buttonsOnTHePage.size()).isEqualTo(7);
        WebElement theFifthButton = buttonsOnTHePage.get(4);
        theFifthButton.click();
        wait.until(visibilityOfElementLocated(By.id("left-area")));
        WebElement landingPage = driver.findElement(By.id("left-area"));
        assertThat(landingPage.isDisplayed()).isTrue();
        //assertThat(landingPage.getText()).isEqualTo("Sample Application Lifecycle – Sprint 1");
    }
    @AfterEach
    void tearDown() {
        driver.close();
    }
}
