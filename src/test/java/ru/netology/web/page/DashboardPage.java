package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private ElementsCollection cards = $$(".list__item div");
    private SelenideElement header = $("[data-test-id='dashboard']");




    private SelenideElement getCardElement(DataHelper.CardInformation card) {
        return cards.find(Condition.attribute("data-test-id", card.getTestID()));
    };

    public int getCardBalance(DataHelper.CardInformation card) {
      return extractBalance(getCardElement(card).getText());
    }

    private int extractBalance(String text) {
        return Integer.parseInt(text.split(":")[1].replaceAll("[^0-9]", ""));
    }


    public TransferPage creatTransferPage(DataHelper.CardInformation card) {
        getCardElement(card).$("button").click();
        return new TransferPage();
    }
}