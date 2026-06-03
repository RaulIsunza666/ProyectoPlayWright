package Hooks;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class HookAPIs {
    protected static Playwright playwright;
    protected static APIRequestContext request;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        // Configuramos el contexto de la API (URL base)
        request = playwright.request().newContext(new APIRequest.NewContextOptions().setBaseURL("https://jsonplaceholder.typicode.com"));
    }

    @AfterAll
    static void tearDown() {
        request.dispose(); // Es importante cerrar el contexto de API
        playwright.close();
    }
}