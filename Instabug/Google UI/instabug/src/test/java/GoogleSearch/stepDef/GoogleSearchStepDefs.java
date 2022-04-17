package GoogleSearch.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import browserActions.browserActions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class GoogleSearchStepDefs {
    @Given("browser opens successfully")
    public void browserOpensSuccessfully() {
       browserActions.setDriver("chrome");
    }
    @And("www.google.com is accessed")
    public void WwwGoogleComIsAccessed() {
        browserActions.navigate("https://www.google.com");
    }

    @Given("browser navigates to Google's homepage")
    public void browserNavigatesToGoogleSHomepage() {
       String currentUrl =  browserActions.getUrl();
       Assert.assertTrue(currentUrl.contains("www.google.com"));
    }

    @Then("Company's logo is displayed")
    public void companySLogoIsDisplayed() {
       Assert.assertTrue(browserActions.locatedCenter("xpath","/html/body/div[1]/div[2]/div/img"));
    }

    @And("Company's search box is displayed")
    public void companySSearchBoxIsDisplayed() {
        Assert.assertTrue(browserActions.locatedCenter("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div"));
    }
    @And("Language is in arabic")
    public void languageIsInArabic() {
        Assert.assertEquals(browserActions.getElement("xpath", "/html").getAttribute("lang"), "ar");
    }
    @And("Menu is located on the left")
    public void menuIsLocatedOnTheLeft() {
        Assert.assertEquals(browserActions.elementXLocation(browserActions.getElement("xpath", "/html/body/div[1]/div[1]/div/div/div")) < browserActions.getWindowXSize()/2, true);
    }
    @Then("verify keyboard icon is located and clickable")
    public void verifyKeyboardIconIsLocatedAndClickable() {
        Assert.assertEquals(browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div[2]/span").isDisplayed(), true);
        browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div[2]").click();
        browserActions.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @Then("verify Mic icon is displayed")
    public void verifyMicIconIsDisplayed() {
        Assert.assertEquals(browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div[3]").isDisplayed(), true);
    }
    @Then("verify that virtual keyboard opened in arabic format with clickable buttons")
    public void verifyThatVirtualKeyboardOpenedInArabicFormatWithClickableButtons() {
        Assert.assertEquals(browserActions.getElement("id", "kbd").isDisplayed(),true);
    }
    @Then("click on english option")
    public void clickOnEnglishOption() {
        browserActions.getElement("xpath", "/html/body/div[1]/div[4]/div/div/a").click();
    }

    @Then("Menu is located on the right")
    public void menuIsLocatedOnTheRight() {
        Assert.assertEquals(browserActions.elementXLocation(browserActions.getElement("xpath", "/html/body/div[1]/div[1]/div/div/div")) > browserActions.getWindowXSize()/2, true);
    }

    @When("user enters {string} to search box")
    public void userEntersToSearchBox(String input) {
        browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input").sendKeys(input);
    }

    @Then("auto suggestions appears")
    public void autoSuggestionsAppears() {
        while(true){
            if (browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]").isDisplayed()){
                break;
            }
        }
        Assert.assertTrue(browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]").isDisplayed());
        browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/div/ul/li[1]").click();
    }

    @Then("Verify URI contains {string}")
    public void verifyURIContains(String keyword) {
        Assert.assertEquals(browserActions.getUrl().contains(keyword),true);
    }
    @And("verify time taken to fetch data and total number of results are displayed")
    public void verifyTimeTakenToFetchDataAndTotalNumberOfResultsAreDisplayed(){
        Assert.assertEquals(browserActions.getElement("xpath", "/html/body/div[7]/div/div[7]/div[1]/div/div/div/div").isDisplayed(), true);
    }

    @When("user clicks on first link")
    public void userClicksOnFirstLink() {
        browserActions.getElement("xpath", "/html/body/div[7]/div/div[10]/div[1]/div[1]/div[3]/div/div/div/div/div[1]/a").click();
    }

    @Then("user is navigated to the desired location")
    public void userIsNavigatedToTheDesiredLocation() {
        Assert.assertTrue(browserActions.getUrl().contains("https://www.facebook.com/"));
    }

    @Given("language is in english")
    public void languageIsInEnglish() {
        browserActions.getElement("xpath", "/html/body/div[1]/div[4]/div/div/a").click();
    }

    @When("user clicks on mic icon")
    public void userClicksOnMicIcon() {
        browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div[2]").click();
    }

    @Then("search by voice window is displayed")
    public void searchByVoiceWindowIsDisplayed() {
        while(true){
            if (browserActions.getElement("xpath", "/html/body/div[1]/div[3]/dialog/div").isDisplayed()){
                break;
            }
        }
        Assert.assertTrue(browserActions.getElement("xpath", "/html/body/div[1]/div[3]/dialog/div").isDisplayed());
    }

    @And("verify listening action started and message is displayed")
    public void verifyListeningActionStartedAndIsDisplayed() {
        while(true){
            if(browserActions.getElement("xpath", "/html/body/div[1]/div[3]/dialog/div/div/div[1]/div[2]/span[1]").isDisplayed()){
                break;
            }
        }
        Assert.assertTrue(browserActions.getElement("xpath", "/html/body/div[1]/div[3]/dialog/div/div/div[1]/div[2]/span[1]").isDisplayed());
        System.out.println(browserActions.getElement("xpath", "/html/body/div[1]/div[3]/dialog/div/div/div[1]/div[2]/span[1]").getText());
    }

    @Then("press on the I'm feeling lucky button")
    public void pressOnTheIMFeelingLuckyButton() {
        while(true){
            if(browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[2]").isDisplayed()){
                break;
            }
        }
        browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[2]").click();
    }

    @Then("user is transferred to the first link of the searched keyword")
    public void userIsTransferredToTheFirstLinkOfTheSearchedKeyword() {
        Assert.assertFalse(browserActions.getUrl().contains("www.google.com"));
    }


    @Then("press on the search button")
    public void pressOnTheSearchButton() {
        browserActions.getElement("name", "btnK").submit();
    }

    @Then("a pagination tab should be displayed in the results")
    public void aPaginationTabShouldBeDisplayedInTheResults() {
        while (true){
            if (browserActions.getElement("xpath", "/html/body/div[7]/div/div[10]/div[1]/div[6]").isDisplayed()){
                break;
            }
        }
        Assert.assertTrue(browserActions.getElement("xpath", "/html/body/div[7]/div/div[10]/div[1]/div[6]").isDisplayed());
    }

    @When("user clicks on next button")
    public void userClicksOnNextButton() {
        browserActions.getElement("xpath", "/html/body/div[7]/div/div[10]/div[1]/div[6]/span[1]/table/tbody/tr/td[12]/a/span[2]").click();
    }

    @Then("the next page is displayed")
    public void theNextPageIsDisplayed() {
        Assert.assertTrue(browserActions.getElement("xpath", "/html/body/div[7]/div/div[7]/div[1]/div/div/div/div").getText().contains("Page 2"));
    }

    @When("user clicks on Google's logo")
    public void userClicksOnGoogleSLogo() {
        browserActions.getElement("id", "logo").click();
    }

    @Then("user is directed back to Google's homepage")
    public void userIsDirectedBackToGoogleSHomepage() {
        Assert.assertTrue(browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]").isDisplayed());
    }

    @When("user clicks on image link")
    public void userClicksOnImageLink() {
        browserActions.getElement("xpath", "/html/body/div[1]/div[1]/div/div/div/div[1]/div/div[2]/a").click();
    }

    @Then("image icon is displayed in the search box")
    public void imageIconIsDisplayedInTheSearchBox() {
        Assert.assertTrue(browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div[2]").isDisplayed());
    }

    @Then("user press enter key")
    public void userPressEnterKey() {
        browserActions.getElement("xpath", "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input").sendKeys(Keys.ENTER);
    }

    @Then("search result with multiple images is displayed")
    public void searchResultWithMultipleImagesIsDisplayed() {
        Assert.assertTrue(browserActions.getElement("xpath", "/html/body/div[2]/c-wiz/div[3]").isDisplayed());
    }

    @And("a filter menu is displayed")
    public void aFilterMenuIsDisplayed() {
        Assert.assertTrue(browserActions.getElement("xpath", "/html/body/div[2]/c-wiz/div[2]/div[2]/c-wiz[2]/scrolling-carousel/div[1]").isDisplayed());
    }
    @After()
    public void closeBrowser(){
        browserActions.close();
    }
}
