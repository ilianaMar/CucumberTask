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

    @Given("I have a Calculator")
    public void createCalculator() {
        System.out.println("test");
    }

    @When("I add {int} and {int}")
    public void sumNumbers(int a, int b) {
        System.out.println(a);
        System.out.println(b);
    }

    @Then("the sum should be {int}")
    public void printOutput(int c) {
        System.out.println(c);
    }
}
