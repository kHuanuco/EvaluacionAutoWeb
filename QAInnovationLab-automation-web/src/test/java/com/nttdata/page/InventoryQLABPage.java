package com.nttdata.page;

import org.openqa.selenium.By;

public class InventoryQLABPage {


    public static By firstProduct = By.xpath("//*[@id=\'js-product-list\']/div[1]/div/article/div/div[2]/h2/a");
    public static By titleProduct = By.xpath("//h1[@class='h1']");
    public static By boxCantidad = By.xpath("//*[@id='quantity_wanted']");
    public static By buttonAgregar = By.cssSelector("button.btn.btn-primary.add-to-cart");
    public static By buttonUpAgregar = By.cssSelector("i.material-icons.touchspin-up");

}
