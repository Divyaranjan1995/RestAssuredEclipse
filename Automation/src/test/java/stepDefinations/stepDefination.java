package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefination {

    @Given("^User is on NetBanking langing page$")
    public void user_is_on_netbanking_langing_page() throws Throwable {
    	
    	System.out.println("Navigated to login page");
    	
    }
    

    @When("^User login into application with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_username_something_and_password_something(String strArg1, String strArg2) throws Throwable {
    	
    	System.out.println(strArg1);
    	System.out.println(strArg2);
        
    }

    @Then("^Home page is displayed$")
    public void home_page_is_displayed() throws Throwable {
    	
    	System.out.println("Homepage is populated with all details");
        
    }

    @And("^Cards dsiplayed are \"([^\"]*)\"$")
    public void cards_dsiplayed_are_something(String strArg1) throws Throwable {
        
    	System.out.println(strArg1);
    }

}