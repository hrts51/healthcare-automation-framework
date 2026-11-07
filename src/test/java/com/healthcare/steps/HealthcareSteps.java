package com.healthcare.steps;
import org.junit.Assert;

import com.healthcare.config.ConfigReader;
import com.healthcare.pages.AppointmentsPage;
import com.healthcare.pages.DashboardPage;
import com.healthcare.pages.LoginPage;
import com.healthcare.pages.PatientsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class HealthcareSteps {
 private final LoginPage login=new LoginPage(); private final DashboardPage dashboard=new DashboardPage(); private final PatientsPage patients=new PatientsPage(); private final AppointmentsPage appointments=new AppointmentsPage();
 @Given("the healthcare portal is open") public void portalOpen() { login.open(ConfigReader.get("base.url","http://localhost:8080")); }
 @When("the administrator logs in with valid credentials") public void adminLogin() { login.login("admin@care.local","Care@123"); }
 @When("the staff member logs in with valid credentials") public void staffLogin() { login.login("staff@care.local","Staff@123"); }
 @When("the user logs in with email {string} and password {string}") public void userLogin(String email,String password) { login.login(email,password); }
 @Then("the dashboard should be displayed") public void dashboardDisplayed() { Assert.assertTrue("Dashboard was not displayed",dashboard.isLoaded()); }
 @Then("the signed-in user should be {string}") public void signedInUser(String expected) { Assert.assertEquals(expected,dashboard.currentUser()); }
 @Then("an authentication error should be displayed") public void authError() { Assert.assertTrue(login.errorMessage().contains("Invalid")); }
 @When("the administrator opens patient management") public void openPatients() { dashboard.openPatients(); Assert.assertTrue(patients.isLoaded()); }
 @When("the administrator registers a patient named {string} with email {string} and phone {string}") public void registerPatient(String name,String email,String phone) { patients.addPatient(name,email,phone); }
 @Then("the patient registration confirmation should be displayed") public void patientConfirmation() { Assert.assertTrue(patients.successMessage().contains("registered")); }
 @When("the administrator opens appointment management") public void openAppointments() { dashboard.openAppointments(); Assert.assertTrue(appointments.isLoaded()); }
 @When("the administrator books an appointment for {string} on {string} for {string}") public void bookAppointment(String patient,String date,String reason) { appointments.book(patient,date,reason); }
 @Then("the appointment confirmation should be displayed") public void appointmentConfirmation() { Assert.assertTrue(appointments.successMessage().contains("booked")); }
 @When("the user logs out") public void logout() { dashboard.logout(); }
 
@Then("the login page should be displayed")
public void loginPage() {
    Assert.assertTrue(
        "Login page should be displayed after logout",
        login.isLoginPageDisplayed()
    );
}

}
