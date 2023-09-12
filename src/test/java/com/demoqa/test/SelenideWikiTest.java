package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideWikiTest {
    @BeforeAll
    static void preconditionTests() {


        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    @Disabled
    void positiveSelenideWikiTestJUnit5() {

        open("selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-more-pages-link").scrollTo();
        $(".wiki-more-pages-link").lastChild().click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        $("#wiki-body").shouldHave(text(
                """
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                        @Test
                        void test() {
                        Configuration.assertionMode = SOFT;
                        open("page.html");

                        $("#first").should(visible).click();
                        $("#second").should(visible).click();
                        }
                        }"""));

    }
}