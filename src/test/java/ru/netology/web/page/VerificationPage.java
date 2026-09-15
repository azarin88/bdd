package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id='code'] input");
    private final SelenideElement verificationButton = $("[data-test-id='action-verify']");

    public DashboardPage creatDashboardPage(DataHelper.VerificationCode code) {
        codeField.setValue(code.getCode());
        verificationButton.click();
        return new DashboardPage();
    }
}
