import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    SelenideElement homeButton = $("a[data-test='home']");
    SelenideElement addressesButton = $("a[data-test='addresses']");
    SelenideElement sighOutButton = $("a[data-test='sign-out']");
    SelenideElement currentUser = $("span[data-test='current-user']");
    SelenideElement welcomeMessage = $(".text-center h1");

}
