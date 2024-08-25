package com.nttdata.steps;

import com.nttdata.page.LoginQLABPage;
import com.nttdata.page.PupupConfQLABPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class PupupConfQLABSteps {

    private WebDriver driver;

    //contrsuctor
    public PupupConfQLABSteps(WebDriver driver){
        this.driver = driver;
    }


    public String obtenerTituloLabel() {
        return this.driver.findElement(PupupConfQLABPage.pupUpConfirmacion).getText();
    }

    public void validarMontoPupUp() {
        String precioProducto= driver.findElement(PupupConfQLABPage.pupUpPrecioProducto).getText();
        String cantidadProducto= driver.findElement(PupupConfQLABPage.pupUpCantidad).getText();
        String montoTotal= driver.findElement(PupupConfQLABPage.pupUpTotal).getText();
        //Extrayendo los datos de los textos de los elementos
        String precio= precioProducto.substring(3);
        String cantidad= cantidadProducto.substring(10);
        String total = montoTotal.substring(3);
        //pasandolo a integer y doubles
        double precioDouble= Double.parseDouble(precio);
        int cantInt= Integer.parseInt(cantidad);
        Double montoMostrado = Double.parseDouble(total);
        //calculando el monto esperado
        double totalEsperado = precioDouble*cantInt;
        //validando que el monto se haya calculado correctamente
        Assertions.assertEquals(totalEsperado,montoMostrado);


    }

    public void clickFinalizarCompra() {
        this.driver.findElement(PupupConfQLABPage.buttonFinalizar).click();
    }
}
