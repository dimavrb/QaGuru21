package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
//        Configuration.holdBrowserOpen = true;
    }

}