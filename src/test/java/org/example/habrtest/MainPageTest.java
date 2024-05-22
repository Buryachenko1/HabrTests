package org.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/en/feed");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test //check that all topic pages in header will open and load the content
    public void mainMenuTest() {
        System.out.println("Running of Main Menu Test - check that all topic pages in header will open and load the content");

        List <WebElement> myFeed = driver.findElements(By.xpath( "//a[contains(text(), 'My feed')]"));
        assertFalse(myFeed.isEmpty(), "My feed is not found");

        List <WebElement> allStreams = driver.findElements(By.xpath( "//a[contains(text(), 'All streams')]"));
        assertFalse(allStreams.isEmpty(), "All streams is not found");

        List <WebElement> development = driver.findElements(By.xpath( "//a[contains(text(), 'Development')]"));
        assertFalse(development.isEmpty(), "Development is not found");

        List <WebElement> admin = driver.findElements(By.xpath( "//a[contains(text(), 'Admin')]"));
        assertFalse(admin.isEmpty(), "Admin is not found");

        List <WebElement> design = driver.findElements(By.xpath( "//a[contains(text(), 'Design')]"));
        assertFalse(design.isEmpty(), "Design is not found");

        List <WebElement> management = driver.findElements(By.xpath( "//a[contains(text(), 'Management')]"));
        assertFalse(management.isEmpty(), "Management is not found");

        List <WebElement> marketing = driver.findElements(By.xpath( "//a[contains(text(), 'Marketing')]"));
        assertFalse(marketing.isEmpty(), "Marketing is not found");

        List <WebElement> popSci = driver.findElements(By.xpath( "//a[contains(text(), 'PopSci')]"));
        assertFalse(popSci.isEmpty(), "PopSci is not found");
    }
    @Test //check setting button in header
    public void HeaderSettingsTest(){
        System.out.println("Running of Header Settings Test - check settings button in header");

        WebElement settingsButton = driver.findElement(By.xpath( "//button[@data-test-id = 'user-menu-settings']"));
        settingsButton.click();

        WebElement feedCompactButton = driver.findElement(By.xpath("//div[@data-test-id = 'checkbox-labeled-input_feed']"));
        feedCompactButton.click();

        WebElement DarkModeButton = driver.findElement(By.xpath("//div[@data-test-id = 'checkbox-labeled-input_colorTheme']"));
        DarkModeButton.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        submitButton.click();
    }
}