package com.healthcare.driver;

import com.healthcare.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.time.Duration;

public final class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private DriverFactory() {}
    public static void initDriver() {
        String browser = ConfigReader.get("browser", "chrome").toLowerCase();
        boolean headless = ConfigReader.getBoolean("headless", false);
        WebDriver driver;
        switch (browser) {
            case "firefox" -> { FirefoxOptions o = new FirefoxOptions(); if (headless) o.addArguments("-headless"); driver = new FirefoxDriver(o); }
            case "edge" -> { EdgeOptions o = new EdgeOptions(); if (headless) o.addArguments("--headless=new"); driver = new EdgeDriver(o); }
            default -> { ChromeOptions o = new ChromeOptions(); if (headless) o.addArguments("--headless=new"); o.addArguments("--window-size=1440,1000", "--disable-notifications"); driver = new ChromeDriver(o); }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getInt("implicit.wait", 0)));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        if (!headless) driver.manage().window().maximize();
        DRIVER.set(driver);
    }
    public static WebDriver getDriver() {
        if (DRIVER.get() == null) throw new IllegalStateException("WebDriver is not initialized. Check Cucumber hooks.");
        return DRIVER.get();
    }
    public static void quitDriver() { if (DRIVER.get() != null) { DRIVER.get().quit(); DRIVER.remove(); } }
}
