package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonScooter {
    private final By fieldName = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");
    private final By fieldSurname = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");
    private final By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By buttonSubway = By.xpath(".//input[@placeholder='* Станция метро']");
    private final String selectSubwayStation = ".//div[@class='select-search__select']//*[text()='%s']";
    private final By fieldPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNextStep = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final WebDriver driver;


    public PersonScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String name, String surname, String address, String subwayStation, String phoneNumber) {
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldSurname).sendKeys(surname);
        driver.findElement(fieldAddress).sendKeys(address);
        driver.findElement(buttonSubway).sendKeys(subwayStation);
        String currentSubwayStation = String.format(selectSubwayStation, subwayStation);
        driver.findElement(By.xpath(currentSubwayStation)).click();
        driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
    }

    public void clickButtonNextStep() {
        driver.findElement(buttonNextStep).click();
    }

}
