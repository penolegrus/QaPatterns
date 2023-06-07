package tests;

import factories.DriverTestFactory;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class FactoryTests {
    @Test
    public void mobileTests() throws MalformedURLException {
        WebDriver driver = DriverTestFactory.getTestDriver("ios");
        WebElement signButton = driver.findElement(MobileBy.IosUIAutomation("signIn"));
        Assertions.assertTrue(signButton.isDisplayed());
    }

    @Test
    public void androidTest() throws MalformedURLException {
        WebDriver driver = DriverTestFactory.getTestDriver("android");
        WebElement signButton = driver.findElement(MobileBy.AndroidUIAutomator("signIn"));
        Assertions.assertTrue(signButton.isDisplayed());
    }
}
