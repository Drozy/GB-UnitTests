package seminars.five;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest {
    /**
     * Напишите автоматизированный тест, который выполнит следующие шаги:
     * 1. Открывает главную страницу Google.
     * 2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
     * 3. В результатах поиска ищет ссылку на официальный сайт Selenium
     * (https://www.selenium.dev) и проверяет, что ссылка действительно присутствует
     * среди результатов поиска.
     */
    @Test
    void seleniumTest() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();
        WebElement seleniumEl = webDriver.findElement(By.tagName("cite"));

        assertThat(seleniumEl.getText()).isEqualTo("https://www.selenium.dev");

        Thread.sleep(3000);
        webDriver.quit();
    }

    /**
     * Нужно написать сквозной тест с использованием Selenium, который авторизует пользователя
     * на сайте https://www.saucedemo.com/
     * Данные для входа
     * логин: "standart_user"
     * пароль: "secret_sauce"
     * Необходимо использовать WebDriver для открытия страницы и методы sendKeys() для ввода
     * данных в поля формы и submit() для отправки формы.
     * Проверьте, что на странице отображаются продукты (productsLabel.getText() = "Products")
     */
    @Test
    void authTest() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");
        WebElement nameElement = webDriver.findElement(By.name("user-name"));
        nameElement.sendKeys("standard_user");
        WebElement passElement = webDriver.findElement(By.name("password"));
        passElement.sendKeys("secret_sauce");
        passElement.submit();

        WebElement citeElement = webDriver.findElement(By.className("title"));
        assertThat(citeElement.getText()).isEqualTo("Products");

        Thread.sleep(3000);
        webDriver.quit();
    }
}
