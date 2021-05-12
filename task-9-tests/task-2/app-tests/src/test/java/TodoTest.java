import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;

public class TodoTest {
    @Test
    public void userCanAddRecord() {
        open("http://localhost:3000/");
        String recordName = "record 1";
        new TodoPage().addRecord(recordName);

        SearchResultsPage results = new SearchResultsPage();
        results.getRecords().shouldHave(size(1));
        results.getRecord(0).find(By.className("name"))
                .shouldHave(text(recordName));
        results.getRecord(0)
                .shouldHave(cssClass("false"));
    }
    @Test
    public void userCanRemoveRecord() {
        open("http://localhost:3000/");
        String recordName = "record 2";
        new TodoPage().addRecord(recordName);
        new SearchResultsPage().getRecords().filterBy(text(recordName)).shouldHave(size(1));
        new TodoPage().removeRecord(recordName);
        new SearchResultsPage().getRecords().filterBy(text(recordName)).shouldHave(size(0));
    }

    @Test
    public void userCanMarkRecordAsDone() {
        open("http://localhost:3000/");
        String recordName = "record 3";
        new TodoPage().addRecord(recordName);
        new SearchResultsPage().getRecords()
                .findBy(text(recordName)).shouldHave(cssClass("false"));
        new TodoPage().markRecordAsDone(recordName);
        new SearchResultsPage().getRecords()
                .findBy(text(recordName)).parent().parent()
                .findElement(byAttribute("aria-label", "Mark item as incomplete"));
    }
}
