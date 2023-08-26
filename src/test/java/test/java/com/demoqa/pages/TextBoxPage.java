package test.java.com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    SelenideElement
            fullName = $("#userName"),
            email = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit"),
            output = $("#output");


    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage setFullName(String value) {

        fullName.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {

        email.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {

        currentAddress.setValue(value);

        return this;
    }

    public TextBoxPage submit() {
        submit.scrollTo();
        submit.click();

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {

        permanentAddress.setValue(value);

        return this;
    }

    public TextBoxPage assertTable(String value) {
        output.shouldHave(text(value));

        return this;
    }


}




