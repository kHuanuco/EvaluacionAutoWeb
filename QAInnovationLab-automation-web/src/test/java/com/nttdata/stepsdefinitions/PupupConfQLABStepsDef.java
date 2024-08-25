package com.nttdata.stepsdefinitions;

import com.nttdata.page.PupupConfQLABPage;
import com.nttdata.steps.PupupConfQLABSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class PupupConfQLABStepsDef {

    //instancia del webdriver de selenium
    private WebDriver driver;

    private PupupConfQLABSteps pupupConfQLABSteps(WebDriver driver){
        return new PupupConfQLABSteps(driver);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        driver= getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PupupConfQLABPage.pupUpConfirmacion));
        String tituloProducto= "Hummingbird printed t-shirt";
        String titleProductoAgregado =  pupupConfQLABSteps(driver).obtenerTituloLabel();
        //prueba: validamos el título del producto sea el que se agrego
        Assertions.assertEquals(tituloProducto, titleProductoAgregado);
        screenShot();//evidencia
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        pupupConfQLABSteps(driver).validarMontoPupUp();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        pupupConfQLABSteps(driver).clickFinalizarCompra();

    }

}
