import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class RegistrationFormTests {



    @BeforeAll
    static void preconditionTests() {


    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.browser = "firefox";}
    @Test
    void positiveTestRegistrationForm() {

        Configuration.baseUrl = "https://demoqa.com/";
        open("automation-practice-form");
        $("#firstName").setValue("Dmitrii");
        $("#lastName").setValue("Kalinin");
        $("#userEmail").setValue("dima@test.ru");
        $("#genterWrapper").$("[for=gender-radio-1]").click();
        $("#userNumber").setValue("79531453389");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1992")).click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__day--010").click();
        $("#hobbiesWrapper").$("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("St. Petersburg");
        $("#subjectsInput").val("Math").pressEnter();
        $("#state").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();


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