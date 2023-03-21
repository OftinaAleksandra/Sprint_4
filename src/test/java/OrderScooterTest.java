import page.object.ConfirmationOrder;
import page.object.MainPage;
import page.object.PersonScooter;
import page.object.RentScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private final WebDriver driver = new ChromeDriver();
    private final String name;
    private final String surname;
    private final String address;
    private final String numberPhone;
    private final String subwayStation;
    private final String rentalPeriod;
    private final String colorScooter;
    private final String comment;

    public OrderScooterTest(String name, String surname, String address, String numberPhone, String subwayStation, String rentalPeriod, String colorScooter, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.numberPhone = numberPhone;
        this.subwayStation = subwayStation;
        this.rentalPeriod = rentalPeriod;
        this.colorScooter = colorScooter;
        this.comment = comment;
    }

    @Parameterized.Parameters(name="Проверка заказа для клиента {0} {1} c номером телефона {3}")
    public static Object[][] getPersonalData() {
        return new Object[][]{
                {"Иванов", "Иван","Москва, ул. Академика Королёва, 12","89889999999","Сокольники","сутки", "серая безысходность", "Позвонить заранее"},
                {"Сидоров", "Семен", "Санкт-Петербург", "89185361245", "Преображенская площадь", "двое суток", "чёрный жемчуг", "no comment"},
        };
    }

    @Before
    public void setUp() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void checkOrderScooterOnHeaderButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnUpperOrder();
        PersonScooter personScooter = new PersonScooter(driver);
        personScooter.fillForm(name, surname, address, subwayStation, numberPhone);
        personScooter.clickButtonNextStep();
        RentScooter rentScooter = new RentScooter(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
        rentScooter.fillRentScooterFormWithGreyScooter(rentalPeriod, colorScooter, comment);
        rentScooter.clickOrderButton();
        ConfirmationOrder confirmationOrder = new ConfirmationOrder(driver);
        confirmationOrder.clickAgreeConfirmationOrder();
        confirmationOrder.successOrder();

    }

    @Test
    public void checkOrderScooterOnLowerButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLowerOrder();
        PersonScooter personScooter = new PersonScooter(driver);
        personScooter.fillForm(name, surname, address, subwayStation, numberPhone);
        personScooter.clickButtonNextStep();
        RentScooter rentScooter = new RentScooter(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
        rentScooter.fillRentScooterFormWithGreyScooter(rentalPeriod, colorScooter, comment);
        rentScooter.clickOrderButton();
        ConfirmationOrder confirmationOrder = new ConfirmationOrder(driver);
        confirmationOrder.clickAgreeConfirmationOrder();
        confirmationOrder.successOrder();

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
