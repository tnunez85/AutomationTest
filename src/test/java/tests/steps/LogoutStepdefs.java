package tests.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static tests.Hooks.driver;
import static tests.Hooks.wait;

public class LogoutStepdefs {

    @Given("^the user is \"([^\"]*)\" into website$")
    public void the_user_is_into_website(String arg1) {

        // The user navigate to website
        driver.navigate().to("http://automationpractice.com/index.php");


        // The user click in log in button
        WebElement botonLogin = driver.findElement(By.className("login"));
        wait.until(elementToBeClickable(botonLogin)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // The user send his/her username
        WebElement campoUser = driver.findElement(By.id("email"));
        wait.until(elementToBeClickable(campoUser)).click();
        campoUser.sendKeys("t.nunez@example.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // The user send the password to the website and access to his/her account settings
        WebElement campoPassword = driver.findElement(By.id("passwd"));
        wait.until(elementToBeClickable(campoPassword)).click();
        campoPassword.sendKeys("password");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement botonSignIn = driver.findElement(By.id("SubmitLogin"));
        wait.until(elementToBeClickable(botonSignIn)).click();

    }

    @When("^the user click in \"([^\"]*)\" button$")
    public void the_user_click_in_button(String arg1) {
        WebElement botonLogout = driver.findElement(By.className("logout"));
        wait.until(elementToBeClickable(botonLogout)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("^the user is \"([^\"]*)\"$")
    public void the_user_is(String arg1) {
        WebElement botonLogin = driver.findElement(By.className("login"));
    }


}
