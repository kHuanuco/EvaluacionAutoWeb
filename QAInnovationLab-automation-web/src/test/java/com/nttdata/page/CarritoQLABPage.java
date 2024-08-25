package com.nttdata.page;

import io.cucumber.java.es.Entonces;
import org.openqa.selenium.By;

public class CarritoQLABPage {

    public static By tituloCarritoPage = By.xpath("//h1[@class='h1']");
    public static By cantidadProducto = By.xpath("//span[@class='label js-subtotal']");
    public static By precioProducto = By.xpath("//span[@class='price']");
    public static By montoProducto = By.xpath("//*[@id=\'main\']/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");



}
