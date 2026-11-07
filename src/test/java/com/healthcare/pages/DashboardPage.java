package com.healthcare.pages;
import org.openqa.selenium.By;
public class DashboardPage extends BasePage {
 private final By heading=By.id("dashboard-heading"), user=By.id("current-user"), patients=By.id("nav-patients"), appointments=By.id("nav-appointments"), logout=By.id("logout-button");
 public boolean isLoaded() { return displayed(heading); }
 public String currentUser() { return text(user); }
 public void openPatients() { click(patients); }
 public void openAppointments() { click(appointments); }
 public void logout() { click(logout); }
}
