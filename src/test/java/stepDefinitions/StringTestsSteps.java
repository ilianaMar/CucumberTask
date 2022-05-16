package stepDefinitions;
import static org.junit.jupiter.api.Assertions.*;

import helpers.StringHelper;
import io.cucumber.java.en.*;

public class StringTestsSteps {
    private String inputString, inputParagraph;
    private String inputFirstSentence, inputSecondSentence = "";
    private final StringHelper stringHelper = new StringHelper();
    private boolean caseSensitive = false;

    @Given("I use simple string {string}")
    public void iUseSimpleString(String string) {
        inputString = string;
    }

    @When("^I remove character (.)$")
    public void iRemoveCharacter(String character) {
        inputString = inputString.replace(character, "");
    }

    @Then("I check {word} is equal to my string")
    public void iCheckStringIsEqualToMyString(String string) {
        assertEquals(0, stringHelper.compareWorlds(inputString, string, caseSensitive));
    }

    @Given("I use simple sentence {string}")
    public void iUseSimpleSentence(String sentence) {
        inputFirstSentence = sentence;
    }

    @Given("I use another simple sentence {string}")
    public void iUseAnotherSimpleSentence(String sentence) {
        inputSecondSentence = sentence;
    }

    @When("^I remove sign ([()\\[\\],;_])$")
    public void iRemoveSingleSign(String sign) {
        if(!inputFirstSentence.isEmpty() && !inputSecondSentence.isEmpty()){
            inputFirstSentence = inputFirstSentence.replace(sign, "");
            inputSecondSentence = inputSecondSentence.replace(sign, "");
        }
    }

    @And("^I remove another single sign ([!?.:])$")
    public void iRemoveAnotherSingle(String sign) {
        if(!inputFirstSentence.isEmpty() && !inputSecondSentence.isEmpty()){
            inputFirstSentence = inputFirstSentence.replace(sign, "");
            inputSecondSentence = inputSecondSentence.replace(sign, "");
        }
    }

    @Then("I compare both sentences")
    public void iCompareBothSentences() {
        assertNotEquals(0, stringHelper.compareWorlds(inputFirstSentence, inputSecondSentence, caseSensitive));

    }

    @Given("I have the paragraph")
    public void iHaveTheParagraph(String paragraph) {
        inputParagraph = paragraph;
    }

    @Then("^I print the (Words count|Word count)$")
    public void iPrintTheWordsCount(String string) {
        String message = String.format("%s is %s", string, stringHelper.countWords(inputParagraph));
        System.out.println(message);
    }

    @Given("^I use case (sensitive|insensitive) compare$")
    public void iUseCaseSensitiveCompare(String op) {
        caseSensitive = op.equalsIgnoreCase("sensitive");
    }
}
