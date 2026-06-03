package Saucedemo.APIs;

import Hooks.HookAPIs;
import Utilidades.AllureHelper;
import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiPostsTest extends HookAPIs {

    @Test
    void getPost(){
        UserController userController = new UserController(request);
        APIResponse respuesta = userController.obtenerUsuarioPorId(101);
        System.out.println(respuesta.text());
    }

    @Test
    void crearUsuarioPost() {
        // 1. Preparamos los datos usando los Setters de Lombok
        CrearPosts crearPosts = new CrearPosts();
        crearPosts.setUserId(101);
        crearPosts.setId(101);
        crearPosts.setTitle("Post creado desde Java");
        crearPosts.setBody("Este es el cuerpo del registro");

        // 2. Serialización: Convertimos el objeto a String JSON
        Gson gson = new Gson();
        String jsonBody = gson.toJson(crearPosts);

        // 3. Enviamos la petición con Playwright
        APIResponse response = request.post("https://jsonplaceholder.typicode.com/posts/", RequestOptions.create().setData(jsonBody));

        // 4. Adjuntamos evidencia al reporte
        AllureHelper.adjuntarJson("Request Payload (Enviado)", jsonBody);
        AllureHelper.adjuntarJson("Response Body (Recibido)", response.text());

        // 5. Validaciones
        assertEquals(201, response.status());
    }
}