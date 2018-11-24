package tests.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static tests.Hooks.driver;
import static tests.Hooks.wait;


public class ShoppingStepdefs {
    @Given("^I'm \"([^\"]*)\" into the website$")
    public void iMIntoTheWebsite(String arg2) {
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


    @And("^Enter \"([^\"]*)\" into search box$")
    public void enterIntoSearchBox(String arg0) {
        WebElement cuadroBuscar = driver.findElement(By.id("search_query_top"));
        wait.until(elementToBeClickable(cuadroBuscar)).click();
        cuadroBuscar.sendKeys(arg0);
    }

    @And("^I'm clicking \"([^\"]*)\" button$")
    public void iMClickingButton(String arg0) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement botonBuscar = driver.findElement(By.className("button-search"));
        wait.until(elementToBeClickable(botonBuscar)).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @When("^I sort the output list by \"([^\"]*)\" dress$")
    public void iSortTheOutputListByDress(String filter) {

        Select sortBy = new Select(driver.findElement(By.id("selectProductSort")));
        sortBy.selectByVisibleText(filter);


    }


    @And("^every dresses are \"([^\"]*)\"$")
    public void everyDressesAre(String filter) {
        Select sortBy = new Select(driver.findElement(By.id("selectProductSort")));
        sortBy.selectByVisibleText(filter);


    }

    @And("^add them up to the \"([^\"]*)\"$")
    public void addThemUpToThe(String arg0) {
        WebElement sortList = driver.findElement((By.className("icon-th-list")));
        wait.until(elementToBeClickable(sortList)).click();

        By addToCart = By.className("ajax_add_to_cart_button");
        List<WebElement> myElements = driver.findElements(addToCart);
        for (WebElement t : myElements) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement addCart = driver.findElement(By.className("ajax_add_to_cart_button"));
            wait.until(elementToBeClickable(addCart)).click();
            WebElement buttonContinue = driver.findElement(By.className("continue"));
            wait.until(elementToBeClickable(buttonContinue)).click();
            //System.out.println(t.getText());

        }


    }

    @When("^I go to the cart \"([^\"]*)\"$")
    public void iGoToTheCart(String arg0) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().to("http://automationpractice.com/index.php?controller=order");

    }

    @Then("^I submit \"([^\"]*)\" every dresses$")
    public void iSubmitpayment(String arg0) {

        WebElement checkOut = driver.findElement(By.className("standard-checkout"));
        wait.until(elementToBeClickable(checkOut)).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement buttonMedium = driver.findElement(By.name("processAddress"));
        wait.until(elementToBeClickable(buttonMedium)).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement checkBox = driver.findElement(By.className("checker"));
        wait.until(elementToBeClickable(checkBox)).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement processCarrier = driver.findElement(By.name("processCarrier"));
        wait.until(elementToBeClickable(processCarrier)).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement payByCheck = driver.findElement(By.className("cheque"));
        wait.until(elementToBeClickable(payByCheck)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement payConfirmation = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button"));
        wait.until(elementToBeClickable(payConfirmation)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("They payment has just been confirmed");


        // Print the price and order ID out
        WebElement priceAmount = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/span/strong"));
        System.out.println("The total amount of your order comes to: " + priceAmount.getText());

        WebElement orderID = driver.findElement(By.xpath("//div[@id='center_column']/div"));
        System.out.println(orderID.getText());
        String orderIDText = orderID.getText();

        // Go to my orders

        WebElement myOrder = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/section[5]/div/ul/li[1]/a"));
        wait.until(elementToBeClickable(myOrder)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create list of every orders id


        List<WebElement> myOrdersHistory = driver.findElements(By.className("footable-first-column"));

        //System.out.println("Lista hecha. Ahora el for");
        //System.out.println(orderIDText);
        for (WebElement t : myOrdersHistory) {
            System.out.println(t.getText());
            if (orderIDText.contains(t.getText())) {
                System.out.println(t.getText() + " registered correctly");
                break;
            } else {
                System.out.println(t.getText() + " not found");
            }

        }


    }

    @And("^click in \"([^\"]*)\"$")
    public void clickIn(String arg0) {
        WebElement myOrders = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/section[5]/div/ul/li[1]/a"));
        wait.until(elementToBeClickable(myOrders)).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("^I check \"([^\"]*)\"$")
    public void iCheck(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^click in \"([^\"]*)\" button$")
    public void clickInButton(String arg0)  {
        WebElement contactButton = driver.findElement(By.id("contact-link"));
        wait.until(elementToBeClickable(contactButton)).click();
    }

    @When("^I fulfill every needed \"([^\"]*)\" for send a message$")
    public void iFulfillEveryNeededForSendAMessage(String arg0)  {
        Select contactTO = new Select(driver.findElement(By.id("id_contact")));
        contactTO.selectByVisibleText("Webmaster");

        WebElement messageBody=driver.findElement(By.id("message"));
        wait.until(elementToBeClickable(messageBody)).sendKeys("This is a text");

        WebElement sendMessage=driver.findElement(By.xpath("//*[@id=\"submitMessage\"]/span"));
        wait.until(elementToBeClickable(sendMessage)).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("^\"([^\"]*)\" the message$")
    public void theMessage(String arg0)  {

        WebElement contactButton = driver.findElement(By.id("contact-link"));
        wait.until(elementToBeClickable(contactButton)).click();
    }
}
