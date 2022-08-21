package stepDefs.UIstepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.GooglePage;
import utilities.Driver;

public class UIsampleStepDefs {

    GooglePage googlePage = new GooglePage();

    @Given("User go to the {string} page")
    public void user_go_to_the_page(String webpage) {
        Driver.getDriver().get(webpage);
    }

    @Then("User verify the page title is not empty")
    public void user_verify_the_page_title_is_not_empty() throws InterruptedException {
        Assert.assertTrue(false);
     //  Assert.assertFalse(Driver.getDriver().getTitle().isEmpty());
       // Thread.sleep(3000);
    }

    @Then("User close the browser")
    public void user_close_the_browser() {
        Driver.close();
    }

}
