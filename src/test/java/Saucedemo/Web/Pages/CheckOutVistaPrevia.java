package Saucedemo.Web.Pages;

import Utilidades.ConfigReader;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;

public class CheckOutVistaPrevia {
    private final Page page;

    public CheckOutVistaPrevia(Page page){
        this.page = page;
    }
    public CompraCompletada verificarVistaPreviaCompra(){
        Assertions.assertEquals(ConfigReader.get("checkout.vistaPrevia.tituloEsperado"), page.locator(ConfigReader.get("productos.expectedTitlePage")).innerText());

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(ConfigReader.get("checkout.vistaPrevia.botonTerminarComprar"))).click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/saucedemo-test.png")));
        return new CompraCompletada(page);
    }
}
