package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class BookingSteps {

    String city;


    @Given("User is looking for hotels in {string} city")
    public void userIsLookingForHotelsInCity(String city) {
        this.city = city;
    }

    @When("User search")
    public void userSearch() {
        open("https://www.booking.com/ru");
        $(By.id("ss")).sendKeys(city);
        $(".sb-searchbox__button").click();
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelApartamentySkyTowerZWannaPrzyOknieShouldBeOnTheFirstPage(String hotel) {
        ArrayList<String>hotelNames = new ArrayList<>();
        for (SelenideElement element : $$(By.xpath("//*[@data-testid='title']"))){
            hotelNames.add(element.getText());
        }
        Assert.assertTrue(hotelNames.contains(hotel));
    }

    @And("{string} score should be {string}")
    public void hotelScoreShouldBeRate(String hotel, String rating) {
        String ratingXpath = "//*[contains(text(), '" +hotel+ "')]/ancestor::div[@data-testid='property-card']//div[@class='_9c5f726ff bd528f9ea6']";
        String getRating = $(By.xpath(ratingXpath)).getText();
        Assert.assertEquals(getRating, rating);
    }
}
