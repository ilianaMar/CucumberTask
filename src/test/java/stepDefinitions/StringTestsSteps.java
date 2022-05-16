package stepDefinitions;
import static org.junit.jupiter.api.Assertions.*;

import helpers.StringHelper;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

public class StringTestsSteps {
    private String inputString, inputSentence ;
    private final StringHelper stringHelper = new StringHelper();
    private final List<String> listWithSentences = new ArrayList<>();

    @Given("I use simple string {string}")
    public void iUseSimpleString(String string) {
        inputString = string;
    }

    @When("I remove character {string}")
    public void iRemoveCharacter(String character) {
        inputString = inputString.replace(character, "");
    }

    @Then("I check {word} is equal to my string")
    public void iCheckStringIsEqualToMyString(String string) {
        assertTrue(stringHelper.compareWorlds(inputString, string));
    }

    @Given("I use simple sentence {string}")
    public void iUseSimpleSentence(String sentence) {
        inputSentence = sentence;
    }

    @When("^I remove sign ([()\\[\\],;_])$")
    public void iRemoveSingleSign(String sign) {
        inputSentence = inputSentence.replace(sign, "");
        listWithSentences.add(inputSentence);
    }

    @And("^I remove another single sign ([!?.:])$")
    public void iRemoveAnotherSingle(String sign) {
        inputSentence = inputSentence.replace(sign, "");
        listWithSentences.add(inputSentence);
    }

    @Then("I compare both sentences")
    public void iCompareBothSentences() {
        for (int i = 0; i < listWithSentences.size()-2; i++){
            assertFalse(stringHelper.compareWorlds(listWithSentences.get(i), listWithSentences.get(i+2)));
        }
    }

    @Given("I have the paragraph {string}")
    public void iHaveTheParagraph(String sentence) {
        inputSentence = sentence;
    }

    @Then("^I print the (Words count|Word count)$")
    public void iPrintTheWordsCount(String string) {
        String message = String.format("%s is %s", string, stringHelper.countWords(inputSentence));
        System.out.println(message);
    }
}
