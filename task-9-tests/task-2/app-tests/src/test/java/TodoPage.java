import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TodoPage {
    public void addRecord(String text) {
        $(By.className("form-control")).val(text).pressEnter();
    }
    public void removeRecord(String text) {
        $(byText(text)).parent().parent()
                .find(byAttribute("aria-label", "Remove Item")).click();
    }
    public void markRecordAsDone(String text) {
        $(byText(text)).parent().parent()
                .find(byAttribute("aria-label", "Mark item as complete")).click();
    }
}
