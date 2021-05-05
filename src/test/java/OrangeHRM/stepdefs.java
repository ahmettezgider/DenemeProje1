package OrangeHRM;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static OrangeHRM.Orange.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class stepdefs {

    @Given("user on homepage")
    public void userOnHomepage() {
        open();
    }

    @When("user navigate to {string}")
    public void userNavigateTo(String link) {
        clickMenuTo(MenuLinks.valueOf(link));
    }

    @And("user select job title as {string}")
    public void userSelectJobTitleAs(String jobTitle) {

        $("#candidateSearch_jobTitle").shouldBe(Condition.visible).selectOption(jobTitle);

    }

    @And("user click to search button")
    public void userClickToSearchButton() {
        $("#btnSrch").shouldBe(Condition.enabled).click();
    }

    @Then("the results should be appear")
    public void theResultsShouldBeAppear() {
        $$("#resultTable tr").shouldHave(CollectionCondition.sizeGreaterThan(1));

        $$("#resultTable tr").forEach(e-> System.out.println(e.getText()));

    }

    @And("user login")
    public void userLogin() {
        login("Admin", "admin123");
    }
}
