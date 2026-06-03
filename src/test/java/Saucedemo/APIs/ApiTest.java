package Saucedemo.APIs;

import Hooks.HookAPIs;
import Utilidades.AllureHelper;
import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ApiTest extends HookAPIs {
    @Test
    void verificarUsuarioUno() {
        // Hacemos un GET a /users/1
        APIResponse response = request.get("/posts/1");

        // Validaciones básicas
        assertEquals(200, response.status());
        assertTrue(response.ok());

        // Validar contenido del JSON
        String body = response.text();
        assertTrue(body.contains("sunt aut facere "));
        System.out.println(body);
    }
    
    @Disabled("Utiliza otro servicio")
    @Test
    void verificarUsuarios(){
        UserController userController = new UserController(request);
        APIResponse response = userController.obtenerUsuarioPorId(1);
        assertEquals(200, response.status());

        // 1. Instanciamos Gson
        Gson gson = new Gson();

        // 2. Convertimos el cuerpo de la respuesta al objeto User
        Users usuario = gson.fromJson(response.text(), Users.class);

        assertEquals("Leanne Graham", usuario.getName());
        assertEquals("Sincere@april.biz", usuario.getEmail());
        System.out.println("El nombre de usuario es: " + usuario.getName());

        AllureHelper.adjuntarJson("JSON de prueba",response.text());
    }
}
