package ru.netology.web.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;


import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
    @Test
    public void shouldPassHappyPathForMoneyTransfer(){
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authenticationInformation = DataHelper.getAuthenticationInformation();
        var verificationPage = loginPage.creatVerificationPage(authenticationInformation);
        var verificationCode = DataHelper.getVerificationCode();
        var dashboardPage = verificationPage.creatDashboardPage(verificationCode);
        var cardInformation = DataHelper.getCardsInformation().get(0);
        var transferPage = dashboardPage.creatTransferPage(cardInformation);
        var finalPage = transferPage.transfer(DataHelper.getCardsInformation().get(1), 5000);
        Assertions.assertEquals(15000, finalPage.getCardBalance(DataHelper.getCardsInformation().get(0)));
    }
}
