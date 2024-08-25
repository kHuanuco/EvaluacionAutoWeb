package com.nttdata.stepsdefinitions;

import com.nttdata.page.LoginQLABPage;
import com.nttdata.steps.LoginQLABSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.*;


public class LoginQLABStepsDef {

    //instancia del webdriver de selenium
    private WebDriver driver;
    private LoginQLABSteps loginQLABSteps;
    //private InventorySteps inventorySteps;


    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();//este metodo ya viene del WebDriver
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=my-account"); //poner la pagina a probar, el login page
        screenShot(); //toma evidencia para el reporte
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String username, String password) {
        loginQLABSteps = new LoginQLABSteps(driver);//invocar la clase LogingStep donde tiene los pasos y setearlo con el driver
        //las acciones: escribir username, paswword
        loginQLABSteps.escribirUsername(username);
        loginQLABSteps.escribirPassword(password);
        loginQLABSteps.loginQLAB(); //hacer click en el boton "Iniciar Sesion"
        //valido login exitoso en la parte superior
        loginQLABSteps.validoAutenticacion();
        screenShot();//evidencia
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subCategoria) {
        //valido que la categoria exista
        loginQLABSteps.seleccionarCategoria(categoria);
        screenShot();//evidencia
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginQLABPage.subCategoriaButton));
        loginQLABSteps.seleccionarSubCategoria(subCategoria);
        screenShot();//evidencia
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
