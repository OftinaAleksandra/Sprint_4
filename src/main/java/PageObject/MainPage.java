package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private static final By ORDER_BUTTON_IN_HEADER = By.xpath(".//button[@class='Button_Button__ra12g' and text() ='Заказать']");
    private static final By ORDER_BUTTON_IN_FOOTER = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() ='Заказать']");


    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver= driver;
    }

    public void open(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOnUpperOrder(){
        driver.findElement(ORDER_BUTTON_IN_HEADER).click();
    }

    public void clickOnLowerOrder(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(ORDER_BUTTON_IN_FOOTER));
        driver.findElement(ORDER_BUTTON_IN_FOOTER).click();
    }

}
