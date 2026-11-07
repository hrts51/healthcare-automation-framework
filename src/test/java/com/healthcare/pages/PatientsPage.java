package com.healthcare.pages;
import org.openqa.selenium.By;
public class PatientsPage extends BasePage {
 private final By heading=By.id("patients-heading"), name=By.id("patient-name"), email=By.id("patient-email"), phone=By.id("patient-phone"), save=By.id("save-patient"), success=By.id("patient-success"), rows=By.cssSelector("#patient-table tbody tr");
 public boolean isLoaded() { return displayed(heading); }
 public void addPatient(String n,String e,String p) { type(name,n); type(email,e); type(phone,p); click(save); }
 public String successMessage() { return text(success); }
 public int patientCount() { return driver().findElements(rows).size(); }
}
