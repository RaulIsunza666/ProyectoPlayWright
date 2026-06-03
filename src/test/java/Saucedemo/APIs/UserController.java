package Saucedemo.APIs;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

public class UserController{
    private final APIRequestContext request;
    private final String ENDPOINT = "/posts";

    public UserController(APIRequestContext request) {
        this.request = request;
    }

    public APIResponse obtenerTodosLosUsuarios() {

        return request.get(ENDPOINT);
    }

    public APIResponse obtenerUsuarioPorId(int id) {
        return request.get(ENDPOINT + "/" + id);
    }

    public APIResponse crearUsuario(String jsonBody) {
        return request.post(ENDPOINT, RequestOptions.create().setData(jsonBody));
    }
}