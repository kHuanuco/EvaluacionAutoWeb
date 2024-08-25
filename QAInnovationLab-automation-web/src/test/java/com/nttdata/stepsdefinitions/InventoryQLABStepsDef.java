package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventoryQLABSteps;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.*;


public class InventoryQLABStepsDef {

    //instancia del webdriver de selenium
    private WebDriver driver;

    private InventoryQLABSteps inventoryQLABSteps(WebDriver driver){
        return new InventoryQLABSteps(driver);
    }


    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        //Ya que el producto agregar esta abajo
        scrollDown();
        String tituloProducto= "Hummingbird printed t-shirt";
        driver= getDriver();
        inventoryQLABSteps(driver).buscarProducto(tituloProducto);
        screenShot();//evidencia
        inventoryQLABSteps(driver).agregarProducto(tituloProducto,cantidad);

    }


}
