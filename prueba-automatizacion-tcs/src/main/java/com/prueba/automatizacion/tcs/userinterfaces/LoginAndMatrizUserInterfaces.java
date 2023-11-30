package com.prueba.automatizacion.tcs.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginAndMatrizUserInterfaces {

    private LoginAndMatrizUserInterfaces(){}

    public static final Target INCOME_USERNAME = Target.the("El usuario ingresa el nombre de usuario").
            located(By.name("username"));

    public static final Target INCOME_PASSWORD = Target.the("El usuario ingresa la contraseña").
            located(By.name("password"));

    public static final Target SELECT_SEND = Target.the("El usuario selecciona enviar").
            located(By.xpath("//*[@type= 'submit']"));

    public static final Target EXTRACT_CYCLES_TOTAL = Target.the("El usuario obtiene la cantidad de ciclos totales").
            locatedBy("//*[@class='text-xl text-center text-green-500']");

    public static final Target EXTRACT_VECTORS = Target.the("El usuario obtiene la coordenada del boton").
            located(By.xpath("//*[@class= 'text-center text-xl font-bold']"));

    public static final Target SELECT_BUTTON = Target.the("El usuario selecciona el boton correcto").
            locatedBy("//*[@name='button_option'][{0}]");

    public static final Target EXTRACT_NUMBER_OPTIONS = Target.the("El usuario obtiene el numero de filas y columnas").
            located(By.xpath("//*[@name= 'button_option']"));

    public static final Target INCOME_SUMROW = Target.the("El usuario ingresa la suma de la fila").
            located(By.name("modal_answer"));

    public static final Target VALIDATE_CYCLE_FAILED = Target.the("El usuario valida que el ciclo no fallo").
            located(By.xpath("//*[@class= 'text-2xl text-center text-red-500']"));

}
