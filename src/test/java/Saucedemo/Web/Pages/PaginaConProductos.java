package Saucedemo.Web.Pages;

import Hooks.HookWeb;
import Utilidades.CredencialesLogin;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class PaginaConProductos extends HookWeb {

    public void cierreSesion(Page page, BrowserContext context){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
        page.getByText("logout").click();
        context.close();
    }

    public void crearNuevaSesionBrowser(CredencialesLogin credenciales, Browser browser){
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080).setStorageStatePath(Paths.get("estado.json")));
        Page page = context.newPage();
        app.login().realizarLogin(credenciales);
    }
}
