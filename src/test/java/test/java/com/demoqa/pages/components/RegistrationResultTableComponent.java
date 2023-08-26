package test.java.com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultTableComponent {
    SelenideElement table = $(".table-responsive");

    public RegistrationResultTableComponent assertTable(String value) {
        table.shouldHave(text(value));

        return this;
    }
}
