package Saucedemo.Web;

import Hooks.HookWeb;
import Saucedemo.Web.Pages.PaginaConProductos;
import Utilidades.CredencialesLogin;
import Utilidades.ConfigReader;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Feature("Login")
public class CodigoBaseTest extends HookWeb {
    CredencialesLogin credenciales = new CredencialesLogin.Builder()
            .conUrl(ConfigReader.get("url"))
            .conUsuario(ConfigReader.get("usuario.userName"))
            .conPassword(ConfigReader.get("usuario.password"))
            .build();

    @Test
    @Story("Usuario válido puede loguearse")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verificar que un usuario con credenciales correctas accede al inventario")
    void loginExitosoYAgregarProducto() {
        app.login()
                .realizarLogin(credenciales)
                .verificarPaginaProductos();
    }

    @Test
    void verificarFlujoCompleto(){
        app.login()
                .realizarLogin(credenciales)
                .seleccionMultiple()
                .verificarCarrito()
                .datosUsuarioCompra()
                .verificarVistaPreviaCompra()
                .verificarPantallaCompraCompletada();
    }

    @Test
    void seleccionMultiple(){
        app.login()
                .realizarLogin(credenciales)
                .seleccionMultiple()
                .verificarCarritoCompras();
    }

    @Test
    void verificarProductosAgregadosPreviamente(){
        app.login()
                .realizarLogin(credenciales)
                .seleccionMultiple();

        PaginaConProductos sesionConProductos = new PaginaConProductos();

        sesionConProductos.cierreSesion(page,context);
        sesionConProductos.crearNuevaSesionBrowser(credenciales, browser);
    }

    @Test
    void verificarOrdenamiento(){
        app.login().realizarLoginConOrdenamiento(credenciales)
                .realizarOrdenamiento(ConfigReader.get("ordanamiento.precioMayor"));
    }
}