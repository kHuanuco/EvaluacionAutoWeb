package com.nttdata.page;

import org.openqa.selenium.By;

public class PupupConfQLABPage {

    public static By pupUpConfirmacion = By.xpath("//h6[@class='h6 product-name']");
    public static By pupUpCantidad = By.xpath("//span[@class='product-quantity']");
    public static By pupUpPrecioProducto = By.xpath("//p[@class='product-price']");
    public static By pupUpTotal = By.xpath("//*[@id=\'blockcart-modal\']/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By buttonFinalizar = By.xpath("//*[@id=\'blockcart-modal\']/div/div/div[2]/div/div[2]/div/div/a");


}
