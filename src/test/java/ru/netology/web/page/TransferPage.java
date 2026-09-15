package ru.netology.web.page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;


import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement moneyField = $("[data-test-id='amount'] input");
    private SelenideElement cardField = $("[data-test-id='from'] input");
    private SelenideElement transactionButton = $("[data-test-id='action-transfer']");

    public TransferPage() {
        moneyField.should(Condition.visible);
        cardField.should(Condition.visible);
        transactionButton.should(Condition.visible);
    }

    public DashboardPage transfer(DataHelper.CardInformation card, int amount) {
        moneyField.setValue(String.valueOf(amount));
        cardField.setValue(card.getCardNumber());
        transactionButton.click();
        return new DashboardPage();
    }
}
