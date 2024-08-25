package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginQLABPage {
    //1 PASO: buscando con f12 en la pagina de prueba y encontrando el id unico de cada uno()
    //Localizadores de elementos: estos estan localizados por id
    //usando el BY. te da opcioes de id, calss, classname y/o xpath
    public static By userInputQLAB = By.xpath("//input[@id='field-email']"); //id="user-name"
    public static By passInputQLAB = By.xpath("//input[@id='field-password']");
    public static By loginButtonQLAB = By.id("submit-login");
    public static By categoriaButton = By.xpath("//*[@id=\'category-3\']/a");
    public static By subCategoriaButton = By.xpath("//*[@id=\'left-column\']/div[1]/ul/li[2]/ul/li[1]/a");
    public static By buttonCerrarSesion = By.cssSelector("a.logout.hidden-sm-down");


}
