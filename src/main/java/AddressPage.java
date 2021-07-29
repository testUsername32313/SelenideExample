import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class AddressPage extends BasePage {
    SelenideElement createNewAddressButton = $("a[data-test='create']");
    SelenideElement firstNameField = $("#address_first_name");
    SelenideElement lastNameField = $("#address_last_name");
    SelenideElement address1Field = $("#address_street_address");
    SelenideElement address2Field = $("#address_secondary_address");
    SelenideElement cityField = $("#address_city");
    SelenideElement stateSelect = $("#address_state");
    SelenideElement zipCodeField = $("#address_zip_code");
    SelenideElement countryUSRadioButton = $("#address_country_us");
    SelenideElement countryCanadaRadioButton = $("#address_country_canada");
    SelenideElement birthdayCalendar = $("#address_birthday");
    SelenideElement ageField = $("#address_age");
    SelenideElement websiteField = $("#address_website");
    SelenideElement uploadImage = $("input[type='file']");
    SelenideElement phoneField = $("#address_phone");
    SelenideElement interestsClimbCheckBox = $("#address_interest_climb");
    SelenideElement interestsDanceCheckBox = $("#address_interest_dance");
    SelenideElement interestsReadCheckBox = $("#address_interest_read");
    SelenideElement noteFiled = $("#address_note");
    SelenideElement commitButton = $("input[data-test='submit']");
    SelenideElement floridaOption = $("option[value='FL']");
    SelenideElement notice = $("div[data-test='notice']");
    SelenideElement tableBody = $("tbody");


}
