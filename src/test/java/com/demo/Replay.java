package com.demo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Replay {
    private WebDriver driver;

    @Test
    public void browserTest(){
//        WebDriver driver = new ChromeDriver();
//        File driverPath = new File(".replay/runtimes/Replay-Chromium.app/Contents/MacOS/Chromium");
        String userHome = System.getProperty("user.home");
        String replayPath = userHome + "/.replay/runtimes/Replay-Chromium.app/Contents/MacOS/Chromium";
//        File driverPath = new File(replayPath);
//        System.setProperty("webdriver.chrome.driver", replayPath);

        ChromeDriverService service =
                new ChromeDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
        ChromeOptions options = new ChromeOptions();
        options.setBinary(replayPath);
        options.setBrowserVersion("108");
        driver = new ChromeDriver(service, options);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertEquals("Foo Bar", driver.getTitle());
    }

    @Test
    public void simpleTest(){
        driver = RemoteWebDriver.builder()
                .oneOf(new ChromeOptions())
                .build();
        driver.get("https://www.saucedemo.com");
        assertEquals("Swag Labs", driver.getTitle());
    }
    @AfterEach
    public void cleanUp(){
        driver.quit();
    }
}
