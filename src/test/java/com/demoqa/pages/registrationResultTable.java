package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class registrationResultTable {
    SelenideElement table = $(".table-responsive");

    public registrationResultTable assertTable(String value) {
        table.shouldHave(text(value));

        return this;
    }
}
