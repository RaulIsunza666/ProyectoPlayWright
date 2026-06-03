package Saucedemo.Web.Pages;

import Utilidades.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;

public class CarritoDeCompras {
    private final Page page;

    public CarritoDeCompras(Page page){
        this.page = page;
    }

    public void verificarCarritoCompras (){
        Locator productos = page.locator(ConfigReader.get("carrito.cantidadProductos"));

        // Ir al carrito
        page.locator(ConfigReader.get("carrito.linkBotonCarrito")).click();

        int totalElementos = productos.count();
        System.out.println("Total elementos " + totalElementos);

        int totalProductosCarrito = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(ConfigReader.get("carrito.tituloBoton"))).count();
        System.out.println("Total productos " + totalProductosCarrito);

        //Assertions.assertEquals(productosAgregadosDeesCompras,totalProductosCarrito);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/saucedemo-test.png")));
        regresarPaginaCompras(page);
    }

    public CheckOut verificarCarrito (){
        Locator productos = page.locator(ConfigReader.get("carrito.cantidadProductos"));

        // Ir al carrito
        page.locator(ConfigReader.get("carrito.linkBotonCarrito")).click();

        int totalElementos = productos.count();
        System.out.println("Total elementos " + totalElementos);

        int totalProductosCarrito = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(ConfigReader.get("carrito.tituloBoton"))).count();
        System.out.println("Total productos " + totalProductosCarrito);

        Assertions.assertEquals(ConfigReader.get("carrito.titulo.espeado"), page.locator(ConfigReader.get("carrito.titulo.actual")).innerText());

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(ConfigReader.get("carrito.boton.checkout"))).click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/saucedemo-test.png")));

        return new CheckOut(page);
    }
    
    private void regresarPaginaCompras(Page page){
        page.getByAltText("Go back").click();
        Assertions.assertEquals(ConfigReader.get("productos.expectedPage"), page.locator(ConfigReader.get("carrito.titulo.actual")).textContent());
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/saucedemo-test.png")));
    }
}
