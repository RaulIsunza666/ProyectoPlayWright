package Utilidades;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.io.ByteArrayInputStream;

public class AllureHelper {
    public static void tomarCaptura(Page page, String nombre) {
        byte[] screenshot = page.screenshot();
        Allure.addAttachment(nombre, new ByteArrayInputStream(screenshot));
    }

    @Attachment(value = "{nombreAdjunto}", type = "application/json")
    public static String adjuntarJson(String nombreAdjunto, String contenido) {
        return contenido;
    }
}