package com.prueba.automatizacion.tcs.tasks;

import com.prueba.automatizacion.tcs.enums.KeysMatriz;
import com.prueba.automatizacion.tcs.userinterfaces.LoginAndMatrizUserInterfaces;
import com.prueba.automatizacion.tcs.utilities.ExtractData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SelectCorrectButtonAndSum implements Task {

    public static Performable selectCorrectButton() {return instrumented(SelectCorrectButtonAndSum.class);}

    @Override
    public <T extends Actor> void performAs(T actor) {

        String coordenada;
        String numerosuma;
        int sumafinal=0;
        int tamañomatriz;

        actor.attemptsTo(WaitUntil.the(LoginAndMatrizUserInterfaces.EXTRACT_VECTORS, isEnabled()).forNoMoreThan(Duration.ofSeconds(4)));

        numerosuma = ExtractData.NumeroFila(LoginAndMatrizUserInterfaces.EXTRACT_VECTORS.resolveFor(actor).getText());
        tamañomatriz = ExtractData.TamañoMatriz(LoginAndMatrizUserInterfaces.EXTRACT_NUMBER_OPTIONS.resolveAllFor(actor).size());

        for (int conteo1=((Integer.parseInt(numerosuma)*tamañomatriz)+1); conteo1<=((Integer.
                parseInt(numerosuma)+1)*tamañomatriz);conteo1++){
            sumafinal = sumafinal+Integer.parseInt(LoginAndMatrizUserInterfaces.SELECT_BUTTON.
                    of(String.valueOf(conteo1)).resolveFor(actor).getText());
        }

        actor.remember(KeysMatriz.KEY2.value(), String.valueOf(sumafinal));

        coordenada = ExtractData.Coordenada(LoginAndMatrizUserInterfaces.EXTRACT_VECTORS.resolveFor(actor).getText(),
                LoginAndMatrizUserInterfaces.EXTRACT_NUMBER_OPTIONS.resolveAllFor(actor).size());
        System.out.println(coordenada);
        actor.attemptsTo(
                Scroll.to(LoginAndMatrizUserInterfaces.SELECT_BUTTON.of(coordenada)).andAlignToBottom(),
                Click.on(LoginAndMatrizUserInterfaces.SELECT_BUTTON.of(coordenada))
        );
    }

}
