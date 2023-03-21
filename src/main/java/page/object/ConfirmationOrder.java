package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationOrder {
    private final By buttonAgreeConfirmationOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() ='Да']");
    private final By buttonDisagreeConfirmationOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text() ='Нет']");
    private final By modalSuccessOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text() ='Заказ оформлен']");
    private final WebDriver driver;

    public ConfirmationOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAgreeConfirmationOrder() {
        driver.findElement(buttonAgreeConfirmationOrder).click();

    }

    public void successOrder() {
        driver.findElement(modalSuccessOrder);
    }
}
