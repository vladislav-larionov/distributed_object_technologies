import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    public ElementsCollection getRecords() {
        return $$(".item");
    }
    public SelenideElement getRecord(int index) {
        return $(".item", index);
    }
}
