package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentScooter {
    private final By fieldDateDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By dateDelivery = By.cssSelector("div > div.react-datepicker__day.react-datepicker__day--030");
    private final By fieldRentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    private final String selectRentalPeriod =".//div[@class='Dropdown-menu']//*[text() = '%s']";
    private final String colorScooterCheckbox = ".//label[@class='Checkbox_Label__3wxSf' and text()='%s']";
    private final By fieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By buttonOrderScooter = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final WebDriver driver;

    public RentScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRentScooterFormWithGreyScooter(String rentalPeriod, String colorScooter, String comment){
        driver.findElement(fieldDateDelivery).click();
        driver.findElement(dateDelivery).click();
        driver.findElement(fieldRentalPeriod).click();
        String currentRentalPeriod = String.format(selectRentalPeriod, rentalPeriod);
        driver.findElement(By.xpath(currentRentalPeriod)).click();
        String currentColorScooter = String.format(colorScooterCheckbox,colorScooter);
        driver.findElement(By.xpath(currentColorScooter)).click();
        driver.findElement(fieldComment).sendKeys(comment);

    }
    public void clickOrderButton(){
        driver.findElement(buttonOrderScooter).click();
    }


}
