package Utilidades;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.logging.Logger;

public class LoggerBase {
    protected Page page;
    protected Logger logger = Logger.getLogger(this.getClass().getName());
    public LoggerBase(Page page){
        this.page = page;
    }

    protected void click(Locator locator, String description){
        logger.info("[ACTION] Click ->" + description + " | Locator: " + locator);
        locator.click();
    }

    protected void fill(Locator locator, String description, String text) {
        logger.info("[ACTION] Fill -> " + description + " : " + text);
        locator.fill(text);
    }
}
