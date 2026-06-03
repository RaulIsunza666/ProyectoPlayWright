package Utilidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            // Asegúrate de que la ruta coincida con donde guardaste el archivo
            FileInputStream fis = new FileInputStream("src/test/resources/locators.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo cargar el archivo de localizadores.");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
