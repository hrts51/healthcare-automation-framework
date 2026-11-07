package com.healthcare.pages;
import com.healthcare.driver.DriverFactory;
import com.healthcare.utils.WaitUtils;
import org.openqa.selenium.*;
public abstract class BasePage {
 protected WebDriver driver() { return DriverFactory.getDriver(); }
 protected void click(By by) { WaitUtils.clickable(by).click(); }
 protected void type(By by,String value) { WebElement e=WaitUtils.visible(by); e.clear(); e.sendKeys(value); }
 protected String text(By by) { return WaitUtils.visible(by).getText(); }
 protected boolean displayed(By by) { try { return WaitUtils.visible(by).isDisplayed(); } catch (TimeoutException e) { return false; } }
}
