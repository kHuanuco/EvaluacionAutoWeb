package com.nttdata.steps;

import com.nttdata.page.LoginQLABPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//PASO 2: LAS ACCIONES
public class LoginQLABSteps {

    private WebDriver driver;
    //private WebElement userInputElement;
    //private WebElement userPassword;
    //private WebElment buttonLogin;
    //constructor
    public LoginQLABSteps(WebDriver driver){
        this.driver = driver;
    }


    public void escribirUsername(String username) {
        WebElement userInputElement = driver.findElement(LoginQLABPage.userInputQLAB);
        userInputElement.sendKeys(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        //espera explicita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginQLABPage.loginButtonQLAB));
    }

    public void escribirPassword(String password) {
        this.driver.findElement(LoginQLABPage.passInputQLAB).sendKeys(password);

    }

    public void loginQLAB() {
        this.driver.findElement(LoginQLABPage.loginButtonQLAB).click();
    }

    public void seleccionarCategoria(String categoria) {
        String textoBotonCatActual = this.driver.findElement(LoginQLABPage.categoriaButton).getText();
        //Valido la existencia de la categoria
        Assertions.assertTrue(textoBotonCatActual.equalsIgnoreCase(categoria));
        this.driver.findElement(LoginQLABPage.categoriaButton).click();
    }

    public void seleccionarSubCategoria(String subCategoria) {
        String textoBotonSubActual= this.driver.findElement(LoginQLABPage.subCategoriaButton).getText();
        //System.out.println("El texto del boton subcategoria es: "+textoBotonSubActual);
        Assertions.assertEquals(subCategoria,textoBotonSubActual);
        this.driver.findElement(LoginQLABPage.subCategoriaButton).click();
    }

    public void validoAutenticacion() {
        //Ya que no tengo el nombre completo del usuario como dato de entrada en el Gherkin
        //se opta por ver el boton de Cerrar Sesion cuando se loguee exitosamente
        String cadena= "Cerrar sesión";
        String textoBotonSubActual= this.driver.findElement(LoginQLABPage.buttonCerrarSesion).getText();
        boolean condicion = textoBotonSubActual.contains(cadena);
        Assertions.assertTrue(condicion);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginQLABPage.buttonCerrarSesion));
    }

}
