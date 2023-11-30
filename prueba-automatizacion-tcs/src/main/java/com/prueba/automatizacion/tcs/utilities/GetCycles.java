package com.prueba.automatizacion.tcs.utilities;

import org.openqa.selenium.By;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class GetCycles {

    private GetCycles(){}

    public static String CicloActual(String xpath){
        String texto;
        String cicloactual;
        texto = getProxiedDriver().findElement(By.xpath(xpath)).getText();
        cicloactual = ExtractData.CicloActual(texto);
        return cicloactual;
    }

    public static String CantidadCiclos(String xpath){
        String texto;
        String cantidadciclos;
        texto = getProxiedDriver().findElement(By.xpath(xpath)).getText();
        cantidadciclos = ExtractData.CiclosInciales(texto);
        return cantidadciclos;
    }

}
