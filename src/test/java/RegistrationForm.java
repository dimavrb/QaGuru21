import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class RegistrationForm {


    @Test
    void successfulSearchTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com/";
        open("automation-practice-form");
        $("[id=firstName]").setValue("Dmitrii");
        $("[id=lastName]").setValue("Kalinin");
        $("[id=userEmail]").setValue("dima@test.ru");
        $("[id=genterWrapper]").$("[for=gender-radio-1]").click();
        $("[id=userNumber]").setValue("79531453389");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").$(byText("1992")).click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__day--010").click();
        $("[id=hobbiesWrapper]").$("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("[id=currentAddress]").setValue("St. Petersburg");
        $("[id=subjectsInput]").val("Math").pressEnter();
        $("#state").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("[id=submit]").click();


        $(".table-responsive").shouldHave(text("Dmitrii Kalinin"));
        $(".table-responsive").shouldHave(text("dima@test.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("7953145338"));
        $(".table-responsive").shouldHave(text("10 May,1992"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("test.jpg"));
        $(".table-responsive").shouldHave(text("St. Petersburg"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

    }
}