package Saucedemo.Web.Pages;

import com.microsoft.playwright.Page;

public class OrdenamientoProductos {
    private final Page page;
    public OrdenamientoProductos(Page page){
        this.page = page;
    }
    public void realizarOrdenamiento(String tipoOrdenamiento){
        page.locator(".product_sort_container").selectOption(tipoOrdenamiento);
        verificarPrecio(page);
    }

    private void verificarPrecio(Page page ){
        String precioProducto = page.locator(".inventory_item").first().locator(".inventory_item_price").innerText();
        String precioLimpio = precioProducto.replace("$","");
        float precio = Float.parseFloat(precioLimpio);
        if (precio > 7.99) {
            System.out.println("Está ordenado por precio menor");
        } else {
            System.out.println("Está ordenado por el precio mayor");
        }
    }
}
