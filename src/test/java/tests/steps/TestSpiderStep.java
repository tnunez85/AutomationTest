package tests.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static tests.Hooks.driver;
import static tests.Hooks.wait;

public class TestSpiderStep {
    @Given("^\"([^\"]*)\" url$")
    public void url(String arg0) {
        driver.navigate().to("http://192.168.242.99:8070/spider-ump/");

    }

    @And("^I type user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iTypeUserAndPassword(String user, String pwd) {
        WebElement username = driver.findElement(By.id("user"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"fm1\"]/fieldset/div/div[6]/button"));

        wait.until(elementToBeClickable(username)).sendKeys(user);
        wait.until(elementToBeClickable(password)).sendKeys(pwd);
        wait.until(elementToBeClickable(loginButton)).click();

    }

    @Then("^I am in the \"([^\"]*)\" page$")
    public void iAmInThePage(String arg0) {
        WebElement layerButtom = driver.findElement(By.id("map-menu-button"));
        wait.until(elementToBeClickable(layerButtom)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
