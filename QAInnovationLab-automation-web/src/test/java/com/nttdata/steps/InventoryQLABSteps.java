package com.nttdata.steps;

import com.nttdata.page.InventoryQLABPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.screenShot;

public class InventoryQLABSteps {

    private WebDriver driver;

    //contrsuctor
    public InventoryQLABSteps(WebDriver driver){
        this.driver = driver;
    }

    public void buscarProducto(String tituloProducto) {
        String tituloProductActual= this.driver.findElement(InventoryQLABPage.firstProduct).getText();
        //System.out.println("el titulo de la primera imagen es: "+tituloProductActual);
        //Asegurando que sea el primer producto a seleccionar
        Assertions.assertTrue(tituloProducto.equalsIgnoreCase(tituloProductActual));
        this.driver.findElement(InventoryQLABPage.firstProduct).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryQLABPage.titleProduct));
        //validando estar en la siguiente pagina con el titulo del producto seleccionado
        String titleProduct= this.driver.findElement(InventoryQLABPage.titleProduct).getText();
        Assertions.assertTrue(tituloProducto.equalsIgnoreCase(titleProduct));

    }

    public void agregarProducto(String tituloProducto, int cantidad) {
        //busco el elemento de la flecha para subir la cantidad hasta 2
        WebElement botonUpAgregar = driver.findElement(InventoryQLABPage.buttonUpAgregar);
        //agregando el producto de acuerdo a cantidad, por defecto ya viene con 1 cantidad
        for(int i=0;i<cantidad-1;i++){
            botonUpAgregar.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        screenShot();//evidencia
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //haciendo click en agregar al carrito
        WebElement botonAgregar = driver.findElement(InventoryQLABPage.buttonAgregar);
        botonAgregar.click();

    }
}
