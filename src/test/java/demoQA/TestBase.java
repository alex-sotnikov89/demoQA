package demoQA;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeAll
    public static void runningBeforeAll() {
        Configuration.reopenBrowserOnFail = true;
//        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = ("https://demoqa.com");
    }

    @BeforeEach
    void name1() {
    }
}
