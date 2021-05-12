package java;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {
    @Test
    public void userCanSearch() {
        open("https://yandex.ru");
        new YandexPage().searchFor("ЯрГУ ИВТ");

        SearchResultsPage results = new SearchResultsPage();
        results.getResults().shouldHave(sizeGreaterThan(1));
        results.getResult(0).find(By.className("Link"))
                .shouldHave(href("http://ivt.uniyar.ac.ru/"));
    }
}
