package stepDefinitions;

import io.cucumber.java.en.*;

public class HelloWorldSteps {
    @Given("today is Sunday")
    public void today_is_Sunday() {
        System.out.println("Today is Sunday?");
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        System.out.println("I ask whether it is Friday yet");
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        System.out.println(string);
    }
}
