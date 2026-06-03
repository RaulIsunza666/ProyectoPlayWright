package Saucedemo.Web;

import Saucedemo.Web.Pages.Login;
import com.microsoft.playwright.Page;

public class App {
    private final Page page;

    public App(Page page) {
        this.page = page;
    }

    public Login login() {
        return new Login(page);
    }
}
