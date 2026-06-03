package Saucedemo.Web.Pages;

import Utilidades.ConfigReader;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;

public class CheckOut {
    private final Page page;

    public CheckOut(Page page){
        this.page = page;
    }
    public CheckOutVistaPrevia datosUsuarioCompra() {
        Assertions.assertEquals(ConfigReader.get("checkout.tituloEsperado"), page.locator(ConfigReader.get("carrito.titulo.actual")).innerText());

        page.getByPlaceholder(ConfigReader.get("checkout.placeholderLocator.nombre")).fill(ConfigReader.get("checkout.placeholderTextBox.nombre"));
        page.getByPlaceholder(ConfigReader.get("checkout.placeholderLocator.apellido")).fill(ConfigReader.get("checkout.placeholderTextBox.apellido"));
        page.getByPlaceholder(ConfigReader.get("checkout.placeholderLocator.codigoPostal")).fill(ConfigReader.get("checkout.placeholderTextBox.codigoPostal"));

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(ConfigReader.get("checkout.boton.continuarCompra"))).click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/saucedemo-test.png")));
        return new CheckOutVistaPrevia(page);
    }
}
