package com.prueba.automatizacion.tcs.questions;

import com.prueba.automatizacion.tcs.userinterfaces.LoginAndMatrizUserInterfaces;
import net.serenitybdd.screenplay.Question;

public class LoginAndMatrizQuestions {

    private LoginAndMatrizQuestions(){}

    public static Question<Boolean> failedCycle(){
        return actor -> LoginAndMatrizUserInterfaces.VALIDATE_CYCLE_FAILED.resolveFor(actor).getText().equals("Ha cometido un error, intente de nuevo");
    }

}
