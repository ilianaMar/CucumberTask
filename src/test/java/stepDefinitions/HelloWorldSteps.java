package stepDefinitions;

import io.cucumber.java.en.*;

public class HelloWorldSteps {
    @Given("today is Sunday")
    public void todayIsSunday() {
        System.out.println("Today is Sunday?");
    }

    @When("I ask whether it's Friday yet")
    public void askWhetherIsFriday() {
        System.out.println("I ask whether it is Friday yet");
    }

    @Then("I should be told {string}")
    public void returnAnswer(String string) {
        System.out.println(string);
    }
}
