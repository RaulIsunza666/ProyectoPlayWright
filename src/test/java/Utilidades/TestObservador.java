package Utilidades;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;


public class TestObservador {
    public class TestListener implements TestWatcher {
        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {

            //Page page = PlaywrightFactory.getPage();

            //AllureHelper.tomarCaptura(page, "CapturarFallo");
        }
    }
}
