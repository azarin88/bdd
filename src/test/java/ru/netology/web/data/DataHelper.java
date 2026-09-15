package ru.netology.web.data;

import lombok.Value;

import java.util.List;

public class DataHelper {
    private DataHelper() {}
    @Value
    public static class AuthenticationInformation {
        private String login;
        private String password;
    }

    public static AuthenticationInformation getAuthenticationInformation() {
        return new AuthenticationInformation("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardInformation {
        private String cardNumber;
        private String testID;
    }

    public static List<CardInformation> getCardsInformation() {
        return  List.of(
                new CardInformation("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0"),
                new CardInformation("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d")
        );
    }
}
