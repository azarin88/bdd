package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private ElementsCollection cards = $$(".list__item div");


    private SelenideElement getCardElement(int index) {
        return cards.get(index);
    }

    public int getCardBalance(int index) {
      return extractBalance(getCardElement(index).getText());
    }

    private int extractBalance(String text) {
        return Integer.parseInt(text.split(":")[1].replaceAll("[^0-9]", ""));
    }

    public TransferPage createTransferPage(int index) {
        getCardElement(index).$("button").click();
        return new TransferPage();
    }
}