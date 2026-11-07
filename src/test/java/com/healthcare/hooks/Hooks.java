package com.healthcare.hooks;
import com.healthcare.config.ConfigReader;
import com.healthcare.driver.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.nio.file.Files;
public class Hooks {
 @Before public void setUp() { DriverFactory.initDriver(); }
 @After public void tearDown(Scenario scenario) {
  try {
   if (scenario.isFailed() && DriverFactory.getDriver() instanceof TakesScreenshot ts) {
    byte[] shot=ts.getScreenshotAs(OutputType.BYTES); scenario.attach(shot,"image/png","failure-screenshot");
    File dir=new File("reports/screenshots"); dir.mkdirs(); Files.write(new File(dir,scenario.getName().replaceAll("[^a-zA-Z0-9-_]","_")+".png").toPath(),shot);
   }
  } catch(Exception e) { scenario.log("Could not capture screenshot: "+e.getMessage()); }
  finally { DriverFactory.quitDriver(); }
 }
}
