package Saucedemo.Web.Pages;

import Utilidades.AllureHelper;
import Utilidades.ConfigReader;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;

public class SeleccionMultiple {
    private final Page page;
    int totalProductosAgregados = 0;

    public SeleccionMultiple(Page page){
        this.page = page;
    }

    public CarritoDeCompras seleccionMultiple() {
        Locator productos = page.locator(ConfigReader.get("productos.div.contenedor"));
        totalProductosAgregados = page.locator(ConfigReader.get("productos.div.contenedor")).count();

        for (Locator producto : productos.all()) {
            producto.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName(ConfigReader.get("productos.botonAgregarCarrito"))).click();
        }
        System.out.println("Total productos agregados desde pagina compra " + totalProductosAgregados);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/saucedemo-test.png")));
        //guardarLocalStorage(context);

        return new CarritoDeCompras(page);
    }

    public CarritoDeCompras verificarPaginaProductos(){
        Assertions.assertEquals(ConfigReader.get("productos.expectedPage"), page.locator(ConfigReader.get("productos.expectedTitlePage")).innerText());

        page.locator(ConfigReader.get("productos.addProductButton")).click();
        page.locator(ConfigReader.get("productos.shoppingCarButton")).click();
        Assertions.assertTrue(page.locator(ConfigReader.get("productos.productAdded")).count() > 0);
        AllureHelper.tomarCaptura(page, "PaginaProductos");

        // Captura de evidencia
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/saucedemo-test.png")));
        return new CarritoDeCompras(page);
    }

    int productosAgregados(){
        return totalProductosAgregados;
    }

    private void guardarLocalStorage(BrowserContext context){
        String localStorage;

        localStorage = context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("estado.json")));
        System.out.println("Productos en localStorage " + localStorage);
    }
}