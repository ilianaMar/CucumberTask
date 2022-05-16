package stepDefinitions;

import enums.Operations;
import helpers.CalculatorHelper;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTestsSteps {
    private int totalInt;
    private double totalDouble;
    private CalculatorHelper calculator;
    private ArrayList<Integer> listNum, listCalculations;

    @ParameterType("sum|difference")
    public Operations operationType(String operationType){
        return Operations.valueOf(operationType);
    }

    @Given("I have a Calculator")
    public void initializeCalculator() {
        calculator = new CalculatorHelper();
    }

    @When("I add integer numbers {int} and {int}")
    public void sumIntNumbers(int a, int b) throws Throwable {
        totalInt = calculator.add(a, b);
    }

    @Then("the integer sum should be {int}")
    public void validateIntResult(int c) throws Throwable {
        assertEquals(totalInt, c);
    }

    @When("I add double numbers {double} and {double}")
    public void sumDoubleNumbers(double a, double b) throws Throwable{
       totalDouble = calculator.add(a, b);
       System.out.println(totalDouble);
    }

    @Then("the double sum should be {double}")
    public void validateDoubleResult(double c) throws Throwable{
        assertEquals(totalDouble, c);
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void addDifferentNumbers(int a, int b) throws Throwable{
        totalInt = calculator.add(a,b);
        System.out.println(totalInt);
    }

    @When("^I add (\\d+.\\d+) and (\\d+.\\d+)$")
    public void addDifferentNumbers(double a, double b) throws Throwable{
        totalDouble = calculator.add(a,b);
        System.out.println(totalDouble);
    }

    @Then("^the expected result should be (\\d+)$")
    public void validateDiffResult(int c) throws Throwable{
        assertEquals(totalInt, c);
    }

    @Then("^the expected result should be (\\d+.\\d+)$")
    public void validateDiffResult(double c) throws Throwable{
        assertEquals((float) totalDouble, (float) c);
    }

    @Given("I have input numbers")
    public void iHaveInputNumbers(List<List<String>> numbers) {
        listNum = new ArrayList<>();
        for (List<String> number : numbers) {
            number.forEach(n -> listNum.add(Integer.parseInt(n)));
        }
    }

    @And("I use operator {operationType}")
    public void iUseOperationTypeOperator(Operations operator) {
        int sum, diff;
        listCalculations = new ArrayList<>();
        for (int i = 0; i < listNum.size() - 2; i++) {
            if (operator.name().equals("sum")) {
                sum = listNum.get(i) + listNum.get(i + 2);
                listCalculations.add(sum);
            } else {
                diff = listNum.get(i) - listNum.get(i+2);
                listCalculations.add(diff);
            }
        }
    }

    @Then("I print the results")
    public void iPrintTheResults() {
        String text, sign;

        for (Integer listCalculation : listCalculations) {
            sign = (listCalculation >= 0) ? "Positive" : "Negative";
            text = String.format("%s number is %s", sign, listCalculation);
            System.out.println(text);
        }
    }
}
