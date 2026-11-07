package com.healthcare.pages;
import org.openqa.selenium.By;
public class AppointmentsPage extends BasePage {
 private final By heading=By.id("appointments-heading"), patient=By.id("appointment-patient"), date=By.id("appointment-date"), reason=By.id("appointment-reason"), book=By.id("book-appointment"), success=By.id("appointment-success"), rows=By.cssSelector("#appointment-table tbody tr");
 public boolean isLoaded() { return displayed(heading); }
 public void book(String patientName,String dateValue,String why) { type(patient,patientName); type(date,dateValue); type(reason,why); click(book); }
 public String successMessage() { return text(success); }
 public int appointmentCount() { return driver().findElements(rows).size(); }
}
