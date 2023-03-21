package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class QuestionAboutImportant {

    final By formQuestionAndAnswer = By.xpath(".//div[@class='Home_FAQ__3uVm4']");
    final String questionLocation = ".//div[@class='accordion__item']//*[text()='%s']";
    final String answerLocation = ".//div[@class='accordion__panel']//*[text()='%s']";
    private final WebDriver driver;

    public QuestionAboutImportant(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollIntoQuestionAndAnswer() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(formQuestionAndAnswer));

    }

    public void unwrapAnswer(String question) {
        String currentQuestion = String.format(questionLocation, question);
        driver.findElement(By.xpath(currentQuestion)).click();

    }

    public String getQuestion(String question) {
        String currentQuestion = String.format(questionLocation, question);
        return driver.findElement(By.xpath(currentQuestion)).getText();
    }

    public String getAnswer(String answer) {
        String currentAnswer = String.format(answerLocation, answer);
        return driver.findElement(By.xpath(currentAnswer)).getText();
    }

}
