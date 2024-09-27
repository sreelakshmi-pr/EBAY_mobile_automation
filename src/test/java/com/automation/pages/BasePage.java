package com.automation.pages;

import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import static java.time.Duration.ofSeconds;

public class BasePage {

    static AppiumDriver driver;
    WebDriverWait wait;

    BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, ofSeconds(10));
    }


    public void scrollOrSwipe(int startX, int startY, int endX, int endY) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence scroll = new Sequence(finger, 1);

        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(new Pause(finger,Duration.ofSeconds(1)));
        scroll.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(scroll));
    }


    private static final String[] DOMAINS = {"example.com", "test.com", "sample.org", "demo.net"};

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static final Random RANDOM = new Random();

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    public static String generateRandomEmail() {
        String username = generateRandomString(7 + RANDOM.nextInt(6));

        String domain = DOMAINS[RANDOM.nextInt(DOMAINS.length)];

        return username + "@" + domain;
    }


    public boolean isDisplayed(WebElement element) {

        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isPresent(WebElement element) {
        try {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

            System.out.println(element.isDisplayed());
            return element.isDisplayed();

        } catch (Exception e) {
            return false;

        } finally {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        }
    }

}


