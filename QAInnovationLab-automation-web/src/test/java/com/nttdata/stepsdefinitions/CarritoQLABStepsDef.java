package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CarritoQLABSteps;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class CarritoQLABStepsDef {

    //instancia del webdriver de selenium
    private WebDriver driver;

    private CarritoQLABSteps carritoQLABSteps(WebDriver driver){
        return new CarritoQLABSteps(driver);
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        driver= getDriver();
        String tituloCarrito= "CARRITO";
        carritoQLABSteps(driver).validoTitulo(tituloCarrito);
        screenShot();//evidencia
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        carritoQLABSteps(driver).validarMontoCalculado();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
