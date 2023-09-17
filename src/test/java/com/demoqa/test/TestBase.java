package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.Map;

import static com.codeborne.selenide.Selenide.executeJavaScript;
public class TestBase {
    @BeforeAll
    static void beforeAll() {
        String browser = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String remote = System.getProperty("remote","https://user1:1234@selenoid.autotests.cloud/wd/hub");
        String browserVersion = System.getProperty("browserVersion","100.0");
        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = remote;
        Configuration.browserVersion = browserVersion;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }
        public static void closeBanner() {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @AfterEach
    void addAttach(){
        Attach.screenshotAs("Attach");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}