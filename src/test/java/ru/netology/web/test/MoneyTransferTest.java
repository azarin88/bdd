package ru.netology.web.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;


import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldPassHappyPathForMoneyTransfer(){
        var loginPage = new LoginPage();
        var authenticationInformation = DataHelper.getAuthenticationInformation();
        var verificationPage = loginPage.createVerificationPage(authenticationInformation);
        var verificationCode = DataHelper.getVerificationCode();
        var dashboardPage = verificationPage.createDashboardPage(verificationCode);
        var transferPage = dashboardPage.createTransferPage(0);
        var finalPage = transferPage.transfer(DataHelper.getCardsInformation().get(1).getCardNumber(), dashboardPage.amount);
        Assertions.assertEquals(dashboardPage.balanceFirstCard + dashboardPage.amount, finalPage.getCardBalance(0));
        Assertions.assertEquals(dashboardPage.balanceSecondCard - dashboardPage.amount, finalPage.getCardBalance(1));
    }
}
