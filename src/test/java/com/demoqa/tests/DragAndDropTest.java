package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void preconditionTests() {


        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
    }

    @Test
    void dragAndDropTest() {
        open("drag_and_drop");
        $(".column:first-child").shouldHave(text("A"));
        $(".column:last-child").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $(".column:first-child").shouldHave(text("B"));
        $(".column:last-child").shouldHave(text("A"));
    }

    @Test
    void actionsTest() {
        open("drag_and_drop");
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        sleep(5000);
    }
}
