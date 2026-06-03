package Saucedemo.Web.Pages;

import Utilidades.ConfigReader;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;

public class CompraCompletada {
    private final Page page;

    public CompraCompletada(Page page){

        this.page = page;
    }

    public void verificarPantallaCompraCompletada(){
        Assertions.assertEquals(ConfigReader.get("compraterminada.tituloEsperado"), page.locator(ConfigReader.get("productos.expectedTitlePage")).textContent());

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(ConfigReader.get("compraterminada.boton,regresarHomePage"))).click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/saucedemo-test.png")));
        Assertions.assertEquals(ConfigReader.get("productos.expectedPage"), page.locator(ConfigReader.get("productos.expectedTitlePage")).textContent());
    }
}