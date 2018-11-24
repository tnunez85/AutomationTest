package tests.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static tests.Hooks.driver;
import static tests.Hooks.wait;
public class LoginStepDefs {

    @Given("^I click in \"([^\"]*)\" button$")
    public void kInButton(String arg0) {
        // The user click in log in button
        WebElement botonLogin = driver.findElement(By.className("login"));
        wait.until(elementToBeClickable(botonLogin)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^I set \"([^\"]*)\" as user$")
    public void iSetAsUser(String user) {
        // The user send his/her username
        WebElement campoUser = driver.findElement(By.id("email"));
        wait.until(elementToBeClickable(campoUser)).click();
        campoUser.sendKeys(user);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^I set \"([^\"]*)\" as password$")
    public void iSetAsPassword(String password) {
        // The user send the password to the website and access to his/her account settings
        WebElement campoPassword = driver.findElement(By.id("passwd"));
        wait.until(elementToBeClickable(campoPassword)).click();
        campoPassword.sendKeys(password);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement botonSignIn = driver.findElement(By.id("SubmitLogin"));
        wait.until(elementToBeClickable(botonSignIn)).click();


    }


    @Given("^Account \"([^\"]*)\" is already created$")
    public void accountIsAlreadyCreated(String user) {
        // The user received the create account error message due to a duplicated login
        WebElement botonCreate = driver.findElement(By.id("email_create"));
        wait.until(elementToBeClickable(botonCreate)).click();
        botonCreate.sendKeys(user);
        WebElement create_error = driver.findElement(By.id("create_account_error"));

    }


    @Given("^I enter into \"([^\"]*)\"$")
    public void iEnterInto(String url) {
        // The user navigate to the shop website.
        driver.navigate().to(url);

    }

    @Then("^I got \"([^\"]*)\" error because user does not exist$")
    public void iGotErrorBecauseUserDoesNotExist(String arg0) {
        // The user received the invalid password message
        WebElement invPasswd = driver.findElement(By.className("alert-danger"));

    }

    @Then("^I am \"([^\"]*)\" into the web$")
    public void iAmIntoTheWeb(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        WebElement botonLogout = driver.findElement(By.className("logout"));
    }


    @And("^the user \"([^\"]*)\" from the website$")
    public void theUserFromTheWebsite(String arg0)  {
        // The user click in sign out button
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement botonLogout = driver.findElement(By.className("logout"));
        wait.until(elementToBeClickable(botonLogout)).click();

    }


    @Given("^the user is \"([^\"]*)\" into the web$")
    public void theUserIsIntoTheWeb(String arg0)  {
        // The user is logged into the website
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement botonLogout = driver.findElement(By.className("logout"));
    }



}
