package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id='login'] input");
    private final SelenideElement passwordField = $("[data-test-id='password'] input");
    private final SelenideElement loginButton = $("[data-test-id='action-login']");


    public VerificationPage creatVerificationPage(DataHelper.AuthenticationInformation information) {
        loginField.setValue(information.getLogin());
        passwordField.setValue(information.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
