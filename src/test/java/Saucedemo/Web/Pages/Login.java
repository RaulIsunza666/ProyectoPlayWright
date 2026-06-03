package Saucedemo.Web.Pages;

import Utilidades.ConfigReader;
import Utilidades.CredencialesLogin;
import Utilidades.LoggerBase;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Login extends LoggerBase {

    public Login(Page page){
        super(page);
        this.page = page;
    }

     public SeleccionMultiple realizarLogin (CredencialesLogin credencialesLogin){
        page.navigate(credencialesLogin.getPagina());
        fill(page.getByPlaceholder(ConfigReader.get("login.username")), "Campo Username", credencialesLogin.getUserName());
        fill(page.getByPlaceholder(ConfigReader.get("login.password")),"Campo Password", credencialesLogin.getPassword());
        click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(ConfigReader.get("login.nombreBoton"))), "Boton login");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/saucedemo-test.png")));
     return new SeleccionMultiple(page);
    }

    public OrdenamientoProductos realizarLoginConOrdenamiento (CredencialesLogin credencialesLogin){
        page.navigate(credencialesLogin.getPagina());
        fill(page.getByPlaceholder(ConfigReader.get("login.username")), "Campo Username", credencialesLogin.getUserName());
        fill(page.getByPlaceholder(ConfigReader.get("login.password")),"Campo Password", credencialesLogin.getPassword());
        click(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(ConfigReader.get("login.nombreBoton"))), "Boton login");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/saucedemo-test.png")));
        return new OrdenamientoProductos(page);
    }
}