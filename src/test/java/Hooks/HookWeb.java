package Hooks;

import Saucedemo.Web.App;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class HookWeb {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected App app;

    @BeforeAll
    static void setupAll() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions());
    }

    @BeforeEach
    void setup() {
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
        page = context.newPage();
        page.setDefaultTimeout(10000);
        app = new App(page);
    }

    @AfterEach
    void teardown() {
        context.close();
    }

    @AfterAll
    static void teardownAll() {
        browser.close();
        playwright.close();
    }
}
