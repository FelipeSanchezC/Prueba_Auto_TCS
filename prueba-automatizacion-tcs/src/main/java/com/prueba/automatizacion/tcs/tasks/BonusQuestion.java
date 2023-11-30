package com.prueba.automatizacion.tcs.tasks;

import com.prueba.automatizacion.tcs.enums.KeysMatriz;
import com.prueba.automatizacion.tcs.userinterfaces.LoginAndMatrizUserInterfaces;
import com.prueba.automatizacion.tcs.utilities.ExtractData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class BonusQuestion implements Task {

    public static Performable bonusQuestion() {
        return instrumented(BonusQuestion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LoginAndMatrizUserInterfaces.INCOME_SUMROW, isEnabled()).forNoMoreThan(Duration.ofSeconds(4)),
                Click.on(LoginAndMatrizUserInterfaces.INCOME_SUMROW),
                Enter.keyValues(actor.recall(KeysMatriz.KEY2.value())+"").into(LoginAndMatrizUserInterfaces.INCOME_SUMROW),
                Click.on(LoginAndMatrizUserInterfaces.SELECT_SEND)
        );

    }

}
