package com.nttdata.steps;

import com.nttdata.page.CarritoQLABPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarritoQLABSteps {

    private WebDriver driver;

    //contrsuctor
    public CarritoQLABSteps(WebDriver driver){
        this.driver = driver;
    }


    public void validoTitulo(String tituloCarrito) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoQLABPage.tituloCarritoPage));
        String tituloMostrado = this.driver.findElement(CarritoQLABPage.tituloCarritoPage).getText();
        Assertions.assertEquals(tituloCarrito,tituloMostrado);
    }

    public void validarMontoCalculado() {
        String precioProducto= driver.findElement(CarritoQLABPage.precioProducto).getText();
        String cantidadProducto= driver.findElement(CarritoQLABPage.cantidadProducto).getText();
        String montoTotal= driver.findElement(CarritoQLABPage.montoProducto).getText();
        //Extrayendo los datos de los textos de los elementos
        String precio= precioProducto.substring(3);
        String cantidad= cantidadProducto.substring(0,1);
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
}
