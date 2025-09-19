package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends PageFactory {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/form//input")
    public List<WebElement> checkoutForm;

    @FindBy(xpath = "//button[@data-test='finish']")
    public WebElement finishButton;

    @FindBy(xpath = "//h2[@data-test='complete-header']")
    public WebElement completeHeader;
}
