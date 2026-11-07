package com.healthcare.utils;
import com.healthcare.config.ConfigReader;
import com.healthcare.driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public final class WaitUtils {
 private WaitUtils() {}
 public static WebElement visible(By by) { return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(ConfigReader.getInt("explicit.wait",10))).until(ExpectedConditions.visibilityOfElementLocated(by)); }
 public static WebElement clickable(By by) { return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(ConfigReader.getInt("explicit.wait",10))).until(ExpectedConditions.elementToBeClickable(by)); }
 public static boolean textPresent(By by, String text) { return new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(ConfigReader.getInt("explicit.wait",10))).until(ExpectedConditions.textToBePresentInElementLocated(by,text)); }
}
